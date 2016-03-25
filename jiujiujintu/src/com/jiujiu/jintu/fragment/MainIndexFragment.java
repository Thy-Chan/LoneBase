package com.jiujiu.jintu.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.FindCallback;
import com.jiujiu.jintu.R;
import com.jiujiu.jintu.TourismDetailActivity;
import com.jiujiu.jintu.adapter.DefaultImgPagerAdapter;
import com.jiujiu.jintu.adapter.IndexManagerAdapter;
import com.jiujiu.jintu.bean.ADPic;
import com.jiujiu.jintu.bean.TourismProduct;
import com.jiujiu.jintu.util.IMGSize;
import com.jiujiu.jintu.util.JJJCONFIG;
import com.jiujiu.jintu.util.JLog;
import com.jiujiu.jintu.util.Options;
import com.nostra13.universalimageloader.core.ImageLoader;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;

/**
 * ��ҳ
 * 
 * @author mpqi-i7
 *
 */
public class MainIndexFragment extends Fragment {

	private ViewPager lviewPager;
	private GridView lGridView;
	private ListView lrecommendListView;// �����Ƽ�
	private List<TourismProduct> ltourismProducts;// �����Ƽ��Ĳ�Ʒ����
	private IndexManagerAdapter lIndexManagerAdapter;// �����Ƽ���adapter

	/**
	 * �ֻ��������ͼƬ
	 */
	private ImageView lADPicPhone0ImageView;
	private ImageView lADPicPhone1ImageView;
	private ImageView lADPicPhone2ImageView;
	private ImageView lADPicPhone3ImageView;
	private ImageView lADPicPhone4ImageView;
	private ImageView lADPicPhone5ImageView;

	private ImageView[] lADPicPhoneImageViews;

	/**
	 * �����ι��ͼƬ
	 */
	private ImageView lADPicTheme0ImageView;
	private ImageView lADPicTheme1ImageView;
	private ImageView lADPicTheme2ImageView;
	private ImageView lADPicTheme3ImageView;
	private ImageView lADPicTheme4ImageView;

	private ImageView[] lADPicThemeImageViews;

	private ImageView[] ltips; // װ����ImageView����
	private List<ImageView> limgList;
	private int lcurrentItem;// ��ǰ����ͼƬitem
	private ViewGroup pointGroup;// СԲ����
	private boolean isAutoPlay = true; // �Զ����ţ�����ָ����ʱ��ΪFALSE

	private ImageLoader imageLoader;

	private boolean isInitTopADImages = false;//true �Ѿ���ʼ����
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_index, container, false);
		initViews(view);
		initViewPager();
		initGridView();
		initPhoneADPics();
		initThemeADPics();
		initRecommendManagerListView();
		return view;

	}

	private void initViews(View view) {
		pointGroup = (ViewGroup) view.findViewById(R.id.viewGroup);
		lviewPager = (ViewPager) view.findViewById(R.id.viewPager);
		lGridView = (GridView) view.findViewById(R.id.index_gridview);
		lrecommendListView = (ListView) view
				.findViewById(R.id.index_recommend_list);

		lADPicPhone0ImageView = (ImageView) view
				.findViewById(R.id.index_phone_adpic0);
		lADPicPhone1ImageView = (ImageView) view
				.findViewById(R.id.index_phone_adpic1);
		lADPicPhone2ImageView = (ImageView) view
				.findViewById(R.id.index_phone_adpic2);
		lADPicPhone3ImageView = (ImageView) view
				.findViewById(R.id.index_phone_adpic3);
		lADPicPhone4ImageView = (ImageView) view
				.findViewById(R.id.index_phone_adpic4);
		lADPicPhone5ImageView = (ImageView) view
				.findViewById(R.id.index_phone_adpic5);
		lADPicPhoneImageViews = new ImageView[] { lADPicPhone0ImageView,
				lADPicPhone1ImageView, lADPicPhone2ImageView,
				lADPicPhone3ImageView, lADPicPhone4ImageView,
				lADPicPhone5ImageView };

		lADPicTheme0ImageView = (ImageView) view
				.findViewById(R.id.index_theme_img0);
		lADPicTheme1ImageView = (ImageView) view
				.findViewById(R.id.index_theme_img1);
		lADPicTheme2ImageView = (ImageView) view
				.findViewById(R.id.index_theme_img2);
		lADPicTheme3ImageView = (ImageView) view
				.findViewById(R.id.index_theme_img3);
		lADPicTheme4ImageView = (ImageView) view
				.findViewById(R.id.index_theme_img4);
		lADPicThemeImageViews = new ImageView[] { lADPicTheme0ImageView,
				lADPicTheme1ImageView, lADPicTheme2ImageView,
				lADPicTheme3ImageView, lADPicTheme4ImageView };

		imageLoader = ImageLoader.getInstance();
	}

	/**
	 * ��ʼ�� viewpager
	 */
	private void initViewPager() {
		limgList = new ArrayList<ImageView>();// Ҫ���ŵ�ͼƬ
		AVQuery<ADPic> query = new AVQuery<ADPic>(ADPic.class.getSimpleName());
		query.whereEqualTo(ADPic.ADTYPE_TEXT, ADPic.TYPE_INDEX_TOP);
		// ���� createdAt �ֶ�������ʾ����
		query.orderByAscending(ADPic.POSTION_TEXT);
		query.findInBackground(new FindCallback<ADPic>() {

			@Override
			public void done(List<ADPic> arg0, AVException arg1) {
				if (arg0 != null && arg0.size() != 0) {

					String url = null;
					for (int i = 0, len = arg0.size(); i < len; i++) {

						// ��ʼ��ͼƬ��Դ
						ImageView image = new ImageView(getActivity());
						image.setScaleType(ScaleType.FIT_XY);
						LinearLayout.LayoutParams imgParam = new LinearLayout.LayoutParams(
								LinearLayout.LayoutParams.WRAP_CONTENT,
								LinearLayout.LayoutParams.WRAP_CONTENT);
						imgParam.height = JJJCONFIG.INDEX_TOP_H_DPI;// ����ͼƬ�ĸ߶�
						image.setLayoutParams(imgParam);

						url = IMGSize.getImgUrl_imageView(arg0.get(i)
								.getImgUrl(), JJJCONFIG.INDEX_TOP_W,
								JJJCONFIG.INDEX_TOP_H, 2);
						JLog.iTest(url);
						imageLoader.displayImage(url, image,
								Options.getListOptions());

						limgList.add(image);// ���õ���ͼƬ�ӵ�ͼƬ����

						// ���ָʾ��
						ImageView point = new ImageView(getActivity());
						LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
								LinearLayout.LayoutParams.WRAP_CONTENT,
								LinearLayout.LayoutParams.WRAP_CONTENT);
						params.rightMargin = 15;// ����ָʾ��֮��ľ���
						params.height = 10;
						params.width = 10;
						point.setLayoutParams(params);

						// �����ʾ���ǵ�һҳ���򽫵�һ��ָʾ�������������ָʾ��ΪĬ��״̬
						if (i == 0) {
							point.setImageResource(R.drawable.point_green);
						} else {
							point.setImageResource(R.drawable.point_gray);
						}
						pointGroup.addView(point);// ��ָʾ��ӵ���ʾ��LinearLayout
					}
					lviewPager.setAdapter(new DefaultImgPagerAdapter(limgList));
					lviewPager
							.setOnPageChangeListener(new MyOnPageChangeListener());
					url = null;
				}
			}
		});

	}

	private void initGridView() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		int[] titleimgs = new int[] { R.drawable.icon_index_travel,
				R.drawable.icon_index_phone,
				R.drawable.icon_index_outbound_travel,
				R.drawable.icon_index_special_line,
				R.drawable.icon_index_customization,
				R.drawable.icon_index_local };
		String[] title = new String[] { "�ܱ�����", "�ֻ�ר��", "����ר��", "ţ��ר��", "ţ�˶���",
				"��������", };
		String[] title2 = new String[] { "һ������", "������", "��������", "������ѡ",
				"���ŷ���", "�������", };
		String[] from = new String[] { "img", "title", "title2" };
		int[] to = new int[] { R.id.item_icon, R.id.item_title,
				R.id.item_title2 };

		for (int i = 0, len = title2.length; i < len; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put(from[0], titleimgs[i]);
			map.put(from[1], title[i]);
			map.put(from[2], title2[i]);
			list.add(map);
		}

		SimpleAdapter simpleAdapter = new SimpleAdapter(getActivity(), list,
				R.layout.item_fragment_index_square, from, to);
		lGridView.setAdapter(simpleAdapter);
	}

	/**
	 * ��ʼ���ֻ�����ͼƬ
	 */
	private void initPhoneADPics() {

		AVQuery<ADPic> query = new AVQuery<ADPic>(ADPic.class.getSimpleName());
		query.whereEqualTo(ADPic.ADTYPE_TEXT, ADPic.TYPE_INDEX_PHONE);
		// ���� createdAt �ֶ�������ʾ����
		query.orderByAscending(ADPic.POSTION_TEXT);
		query.findInBackground(new FindCallback<ADPic>() {

			@Override
			public void done(List<ADPic> arg0, AVException arg1) {
				/*
				 * String imageUri = "http://site.com/image.png"; // from Web
				 * String imageUri = "file:///mnt/sdcard/image.png"; // from SD
				 * card String imageUri =
				 * "content://media/external/audio/albumart/13"; // from content
				 * provider String imageUri = "assets://image.png"; // from
				 * assets
				 */
				if (arg0 != null && arg0.size() != 0) {

					String url = null;
					for (int i = 0, len = arg0.size(); i < len; i++) {
						url = IMGSize.getImgUrl_imageView(arg0.get(i)
								.getImgUrl(), JJJCONFIG.INDEX_PHONE_W,
								JJJCONFIG.INDEX_PHONE_H, 2);
						JLog.iTest(url);
						imageLoader.displayImage(url, lADPicPhoneImageViews[i],
								Options.getListOptions());
					}
					url = null;
				}
			}
		});

	}

	/**
	 * ��ʼ��������ͼ
	 */
	private void initThemeADPics() {
		AVQuery<ADPic> query = new AVQuery<ADPic>(ADPic.class.getSimpleName());
		query.whereEqualTo(ADPic.ADTYPE_TEXT, ADPic.TYPE_INDEX_THEME);
		// ���� createdAt �ֶ�������ʾ����
		query.orderByAscending(ADPic.POSTION_TEXT);
		query.findInBackground(new FindCallback<ADPic>() {

			@Override
			public void done(List<ADPic> arg0, AVException arg1) {
				String url = null;
				if (arg0 != null && arg0.size() != 0) {
					for (int i = 0, len = arg0.size(); i < len; i++) {

						if (i < 3) { // ǰ����
							url = IMGSize.getImgUrl_imageView(arg0.get(i)
									.getImgUrl(),
									JJJCONFIG.INDEX_THEME_W_SMALL,
									JJJCONFIG.INDEX_THEME_H_SMALL, 2);
						} else {
							url = IMGSize.getImgUrl_imageView(arg0.get(i)
									.getImgUrl(),
									JJJCONFIG.INDEX_THEME_W_LARGE,
									JJJCONFIG.INDEX_THEME_H_LARGE, 2);
						}
						JLog.iTest(url);
						imageLoader.displayImage(url, lADPicThemeImageViews[i],
								Options.getListOptions());
					}
					url = null;
				}
			}

		});
	}

	/**
	 * ��ʼ�������Ƽ�
	 */
	private void initRecommendManagerListView() {
		AVQuery<TourismProduct> query = new AVQuery<TourismProduct>(
				TourismProduct.class.getSimpleName());
		query.findInBackground(new FindCallback<TourismProduct>() {

			@Override
			public void done(List<TourismProduct> arg0, AVException arg1) {
				ltourismProducts = arg0;
				if (arg0 != null && arg0.size() != 0) {
					lIndexManagerAdapter = new IndexManagerAdapter(
							getActivity(), ltourismProducts);
					lrecommendListView.setAdapter(lIndexManagerAdapter);
					lrecommendListView.setOnItemClickListener(new OnItemClickListener() {

						@Override
						public void onItemClick(AdapterView<?> parent,
								View view, int position, long id) {
							startActivity(new Intent(getActivity(),TourismDetailActivity.class));
							
						}
					});
				}
			}
		});
	}

	@Override
	public void onStart() {
		super.onStart();
		if (!isInitTopADImages) {
			new TimeThread().start();
			isInitTopADImages = true;
		}		
	}
	

	private class MyOnPageChangeListener implements OnPageChangeListener {
		@Override
		public void onPageSelected(int position) {
			// �ı�ָʾ���״̬
			for (int i = 0; i < limgList.size(); i++) {
				if (i == position) {
					ImageView imgPoint = (ImageView) pointGroup
							.getChildAt(position);
					imgPoint.setImageResource(R.drawable.point_green);
					break;
				}

			}
			// ����û���ڵ�ǰҳ���ָʾ��
			for (int i = 0; i < limgList.size(); i++) {
				ImageView imgPoint = (ImageView) pointGroup.getChildAt(i);
				if (i == position) {
					continue;
				} else {
					imgPoint.setImageResource(R.drawable.point_gray);
				}
			}
			lcurrentItem = position;
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {

		}

		@Override
		public void onPageScrollStateChanged(int arg0) {
			// arg0 ==1��ʱ��Ĭʾ���ڻ�����arg0==2��ʱ��Ĭʾ��������ˣ�arg0==0��ʱ��Ĭʾʲô��û����
			switch (arg0) {
			case 1:
				isAutoPlay = false;
				break;
			case 2:
				isAutoPlay = true;
				break;
			case 0:
				isAutoPlay = true;
				break;
			}
		}
	}

	public class TimeThread extends Thread {
		@Override
		public void run() {
			do {
				try {
					Thread.sleep(1000 * 5);
					if (isAutoPlay) {
						Message msg = new Message();
						msg.what = 1;
						mHandler.sendMessage(msg);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} while (true);
		}
	}

	private Handler mHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			switch (msg.what) {
			case 1:
				lcurrentItem += 1;
				if (lcurrentItem == limgList.size()) {
					lcurrentItem = 0;
				}
				lviewPager.setCurrentItem(lcurrentItem, false);
				break;
			default:
				break;
			}
		}
	};

}
