package com.mpqi.myjiujiujintu.util;

import android.graphics.Bitmap;

import com.mpqi.myjiujiujintu.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

public class Options {
	/**
	 * �б����õ���ͼƬ��������
	 */
	public static DisplayImageOptions getListOptions() {
		DisplayImageOptions options = new DisplayImageOptions.Builder()
		// ����ͼƬ�������ڼ���ʾ��ͼƬ
				.showImageOnLoading(R.drawable.item_index_img_bg)
				// ����ͼƬUriΪ�ջ��Ǵ����ʱ����ʾ��ͼƬ
				.showImageForEmptyUri(R.drawable.item_index_img_bg_error)
				// ����ͼƬ����/��������д���ʱ����ʾ��ͼƬ
				.showImageOnFail(R.drawable.item_index_img_bg_error)
				// �������ص�ͼƬ�Ƿ񻺴����ڴ���
				.cacheInMemory(false)
				// �������ص�ͼƬ�Ƿ񻺴���SD����
				.cacheOnDisc(true)
				// ����Exif��Ϣ
				.considerExifParams(true)
				// ����ͼƬ����εı��뷽ʽ��ʾ
				.imageScaleType(ImageScaleType.EXACTLY_STRETCHED)
				// ����ͼƬ�Ľ�������
				.bitmapConfig(Bitmap.Config.RGB_565)
				// .decodingOptions(android.graphics.BitmapFactory.Options
				// decodingOptions)//����ͼƬ�Ľ�������
				.considerExifParams(true)
				// ����ͼƬ����ǰ���ӳ�
				.delayBeforeLoading(100)// int
				// delayInMillisΪ�����õ��ӳ�ʱ��
				// ����ͼƬ���뻺��ǰ����bitmap��������
				// .preProcessor(BitmapProcessor preProcessor)
				.resetViewBeforeLoading(true)// ����ͼƬ������ǰ�Ƿ����ã���λ
//				.displayer(new RoundedBitmapDisplayer(20))// �Ƿ�����ΪԲ�ǣ�����Ϊ����
//				.displayer(new FadeInBitmapDisplayer(100))// ����
				.build();
		return options;
	}
}
