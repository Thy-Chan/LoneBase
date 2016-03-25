package com.mpqi.myjiujiujintu.widget;

import com.mpqi.myjiujiujintu.R;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * �ײ�ͼƬ���ֲ���Ⱦ
 * 
 * @author mpqi
 *
 */
public class MaskImage extends ImageView {
	int mImageSource = 0; // ͼƬ��Դ
	int mMaskSource = 0; // �ײ�ͼƬ��Դ
	RuntimeException mException;

	/**
	 * AttributeSet ����
	 */
	public MaskImage(Context context, AttributeSet attrs) {
		super(context, attrs);
		TypedArray a = getContext().obtainStyledAttributes(attrs,
				R.styleable.MaskImage, 0, 0);

		mImageSource = a.getResourceId(R.styleable.MaskImage_image, 0);
		mMaskSource = a.getResourceId(R.styleable.MaskImage_mask, 0);

		if (mImageSource == 0 || mMaskSource == 0) {// ����һ��Ϊ�գ��͒���
			mException = new IllegalArgumentException(
					a.getPositionDescription()
							+ ": The content attribute is required and must refer to a valid image.");
		}

		if (mException != null)
			throw mException;
		refresh();
		a.recycle();// ������Դ
	}

	/**
	 * ��Ҫ����ʵ��
	 */
	public void refresh() {
		// ��ȡͼƬ����Դ�ļ� ����ͼ ��ɫ �� ��ɫ
		Bitmap original = BitmapFactory.decodeResource(getResources(),
				mImageSource);
		// ��ȡ���ֲ�ͼƬ ���ֵ���ͼƬ
		Bitmap mask = BitmapFactory.decodeResource(getResources(), mMaskSource);
		// ����յĽ��ͼƬ �������ø�imageview src ��ʾ����
		Bitmap result = Bitmap.createBitmap(mask.getWidth(), mask.getHeight(),
				Config.ARGB_8888);

		// �������ƵĹ���
		// Ϊ���ͼ reslut ����һ�Ż��� ���ڻ���Ч��
		Canvas canvas = new Canvas(result);
		// ����һֻ����Ļ��� ���ڻ��� ��ȾЧ��
		Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
		// Ϊ����������Ⱦ ���� Ч�� �����ظ��Ĳ��֣���ʾ���������
		paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));

		// ��ʼ��������Ч��ͼƬ
		// ���Ʊ��� �����ε���ɫ����ɫ��
		canvas.drawBitmap(original, 0, 0, null);
		// �������ֲ� ����ͼƬ
		canvas.drawBitmap(mask, 0, 0, paint);

		// �� �ͷ���Դ
		paint.setXfermode(null);

		// ����ͼƬ�ؼ���ʾ��ͼƬ��Դ
		setImageBitmap(result);
		// ΪͼƬ���þ���
		setScaleType(ScaleType.CENTER);
	}

	public void setmImageSource(int mImageSource) {
		this.mImageSource = mImageSource;
	}

	public void setmMaskSource(int mMaskSource) {
		this.mMaskSource = mMaskSource;
	}

}
