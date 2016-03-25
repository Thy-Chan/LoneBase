package com.mpqi.myjiujiujintu.adapter;

import java.util.List;

import com.mpqi.myjiujiujintu.R;
import com.mpqi.myjiujiujintu.bean.TourismProduct;
import com.mpqi.myjiujiujintu.util.IMGSize;
import com.mpqi.myjiujiujintu.util.JJJCONFIG;
import com.mpqi.myjiujiujintu.util.JLog;
import com.mpqi.myjiujiujintu.util.Options;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageLoadingListener;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * ��ҳ ��Ʒ�����Ƽ�
 * 
 * @author mpqi-i7
 *
 */
public class IndexManagerAdapter extends BaseAdapter implements
		OnScrollListener {
	/**
	 * ��ǰlistview�Ƿ����ڹ���״̬
	 */
	private boolean isScrolling;
	private List<TourismProduct> list;
	private LayoutInflater layoutinflater;
	private Context context;
	private ImageLoader imageLoader;

	private class CoverHolver {
		private ImageView titleImageView;
		private TextView titleTextView;
		private TextView priceTextView;
		private TextView assessTextView;

	}

	public IndexManagerAdapter(Context context, List<TourismProduct> list) {
		super();
		this.list = list;
		this.context = context;
		layoutinflater = LayoutInflater.from(context);
		imageLoader = ImageLoader.getInstance();
	}

	public void setList(List<TourismProduct> list) {
		this.list = list;
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		CoverHolver holver = null;
		TourismProduct tourismProduct = list.get(position);
		if (convertView == null) {
			convertView = layoutinflater.inflate(
					R.layout.item_fragment_index_manager_recommend, null);
			holver = new CoverHolver();
			holver.titleImageView = (ImageView) convertView
					.findViewById(R.id.item_recommend_img);
			holver.titleTextView = (TextView) convertView
					.findViewById(R.id.item_recommend_title);
			holver.priceTextView = (TextView) convertView
					.findViewById(R.id.item_recommend_money);
			holver.assessTextView = (TextView) convertView
					.findViewById(R.id.item_recommend_assess);
			convertView.setTag(holver);
		} else {
			holver = (CoverHolver) convertView.getTag();
		}
		holver.titleTextView.setText(tourismProduct.getTitle());

		String price = context.getString(R.string.calendar_yuan);
		price = String.format(price, tourismProduct.getPriceNew());
		holver.priceTextView.setText(price);

		String assess = context.getString(R.string.satisfaction);
		assess = String.format(assess, tourismProduct.getAtisfaction());
		holver.assessTextView.setText(assess);
		String url = IMGSize.getImgUrl_imageMogr(
				tourismProduct.getImgTitleUrl(), JJJCONFIG.ITEM_ICON_CROP_W,
				JJJCONFIG.ITEM_ICON_CROP_H, JJJCONFIG.ITEM_ICON_W,
				JJJCONFIG.ITEM_ICON_H);
		JLog.iTest(url);
		holver.titleImageView.setTag(url);

		imageLoader.displayImage(url, holver.titleImageView,
				Options.getListOptions(), new ImageLoadingListener() {

					@Override
					public void onLoadingStarted(String arg0, View arg1) {
						// ��ʼ����
					}

					@Override
					public void onLoadingFailed(String arg0, View arg1,
							FailReason arg2) {
						// ����ʧ��
					}

					@Override
					public void onLoadingComplete(String arg0, View arg1,
							Bitmap arg2) {
						if (arg1.getTag().toString().equals(arg0)) {
							((ImageView) arg1).setImageBitmap(arg2);
						}
					}

					@Override
					public void onLoadingCancelled(String arg0, View arg1) {
						// ����ȡ��
					}

				});

		return convertView;
	}

	boolean isLastRow = false;

	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {
		// ���ڹ���ʱ�ص����ص�2-3�Σ���ָû����ص�2�Ρ�scrollState = 2����β��ص�
		// �ص�˳������
		// ��1�Σ�scrollState = SCROLL_STATE_TOUCH_SCROLL(1) ���ڹ���
		// ��2�Σ�scrollState = SCROLL_STATE_FLING(2) ��ָ�����׵Ķ�������ָ�뿪��Ļǰ����������һ�£�
		// ��3�Σ�scrollState = SCROLL_STATE_IDLE(0) ֹͣ����

		// ���������һ����ֹͣ����ʱ��ִ�м���
		if (isLastRow
				&& scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE) {
			// ����Ԫ��
			isLastRow = false;
			imageLoader.pause();
		}

	}

	@Override
	public void onScroll(AbsListView view, int firstVisibleItem,
			int visibleItemCount, int totalItemCount) {
		// ����ʱһֱ�ص���ֱ��ֹͣ����ʱ��ֹͣ�ص�������ʱ�ص�һ�Ρ�
		// firstVisibleItem����ǰ�ܿ����ĵ�һ���б���ID����0��ʼ��
		// visibleItemCount����ǰ�ܿ������б��������С���Ҳ�㣩
		// totalItemCount���б����

		// �ж��Ƿ�������һ��
		if (firstVisibleItem + visibleItemCount == totalItemCount
				&& totalItemCount > 0) {
			isLastRow = true;
			imageLoader.notify();
		}

	}

}
