package com.mpqi.myjiujiujintu.fragment;

import java.util.ArrayList;
import java.util.List;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.FindCallback;
import com.mpqi.myjiujiujintu.R;
import com.mpqi.myjiujiujintu.adapter.DefaultImgPagerAdapter;
import com.mpqi.myjiujiujintu.bean.ADPic;
import com.mpqi.myjiujiujintu.util.IMGSize;
import com.mpqi.myjiujiujintu.util.JJJCONFIG;
import com.mpqi.myjiujiujintu.util.JLog;
import com.nostra13.universalimageloader.core.ImageLoader;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ImageView.ScaleType;

public class MainIndexFragment extends Fragment {
	private ViewPager lviewPager;
	private ImageView[] ltips; // װ����ImageView����
	private List<ImageView> limgList;
	private ViewGroup pointGroup;// СԲ����
	private int lcurrentItem;// ��ǰ����ͼƬitem
	private boolean isAutoPlay = true; // �Զ����ţ�����ָ����ʱ��ΪFALSE

	private boolean isInitTopADImages = false;// true �Ѿ���ʼ����

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_index, null);
		initViews(view);
		initViewPager();
		return view;
	}

	@Override
	public void onStart() {
		super.onStart();
		if (!isInitTopADImages) {
			new TimeThread().start();
			isInitTopADImages = true;
		}
	}

	private void initViews(View view) {
		pointGroup = (ViewGroup) view.findViewById(R.id.viewGroup);
		lviewPager = (ViewPager) view.findViewById(R.id.viewPager);
	}

	/**
	 * ��ʼ�� viewpager
	 */
	private void initViewPager() {
		limgList = new ArrayList<ImageView>();// Ҫ���ŵ�ͼƬ
		// List<String> urls = new ArrayList<String>();
		// urls.add("http://qiniuphotos.qiniudn.com/gogopher.jpg");
		// urls.add("http://img4.imgtn.bdimg.com/it/u=984757508,3163070235&fm=21");
		// urls.add("http://img1.imgtn.bdimg.com/it/u=191698150,3774242073&fm=21&gp=0.jpg");
		// urls.add("http://img5.imgtn.bdimg.com/it/u=1606258999,420145522&fm=21&gp=0.jpg");
		// urls.add("http://img1.imgtn.bdimg.com/it/u=1023868808,2982592043&fm=21&gp=0.jpg");

		AVQuery<ADPic> query = new AVQuery<ADPic>(ADPic.class.getSimpleName());
		query.whereEqualTo(ADPic.ADTYPE_TEXT, ADPic.TYPE_INDEX_TOP);
		// ����POSTION �±� �ֶ�������ʾ����
		query.orderByAscending(ADPic.POSTION_TEXT);
		query.findInBackground(new FindCallback<ADPic>() {

			@Override
			public void done(List<ADPic> urls, AVException arg1) {
				String url;
				for (int i = 0, len = urls.size(); i < len; i++) {

					// ��ʼ��ͼƬ��Դ
					ImageView imageView = new ImageView(getActivity());
					LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
							LayoutParams.WRAP_CONTENT,
							LayoutParams.WRAP_CONTENT);
					imageView.setScaleType(ScaleType.FIT_XY);
					params.height = JJJCONFIG.INDEX_TOP_H_DPI;// ����ͼƬ�ؼ��ĸ߶�
					imageView.setLayoutParams(params);

					url = IMGSize.getImgUrl_imageView(urls.get(i).getImgUrl(),
							JJJCONFIG.INDEX_TOP_W, JJJCONFIG.INDEX_TOP_H, 2);

					JLog.iTest(url);
					limgList.add(imageView);
					ImageLoader.getInstance().displayImage(url, imageView);

					// ���ָʾ��
					ImageView point = new ImageView(getActivity());
					LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(
							LinearLayout.LayoutParams.WRAP_CONTENT,
							LinearLayout.LayoutParams.WRAP_CONTENT);
					params1.rightMargin = 15;// ����ָʾ��֮��ľ���
					params1.height = 10;
					params1.width = 10;
					point.setLayoutParams(params1);

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
				lcurrentItem = 0;
			}
		});

	}

	private class MyOnPageChangeListener implements OnPageChangeListener {

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

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onPageSelected(int position) {
			// �ı�ָʾ���״̬
			for (int i = 0, len = limgList.size(); i < len; i++) {
				if (i == position) {
					ImageView imgPoint = (ImageView) pointGroup
							.getChildAt(position);
					imgPoint.setImageResource(R.drawable.point_green);
					break;
				}

			}
			// ����û���ڵ�ǰҳ���ָʾ��
			for (int i = 0, len = limgList.size(); i < len; i++) {
				ImageView imgPoint = (ImageView) pointGroup.getChildAt(i);
				if (i == position) {
					continue;
				} else {
					imgPoint.setImageResource(R.drawable.point_gray);
				}
			}
			lcurrentItem = position;
		}

	}

	private class TimeThread extends Thread {
		@Override
		public void run() {
			do {
				try {
					Thread.sleep(5000);
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
