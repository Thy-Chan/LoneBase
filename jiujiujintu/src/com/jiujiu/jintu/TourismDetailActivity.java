package com.jiujiu.jintu;

import android.app.Activity;
import android.os.Bundle;

/**
 * ���β�Ʒ����
 * 
 * @author mpqi
 *
 */
public class TourismDetailActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_tourism_detail);
		initViews();
		initDetail();
		/*Drawable drawable = getResources().getDrawable(img[i]);
		drawable.setBounds(0, 0, drawable.getMinimumWidth(),
				drawable.getMinimumHeight());
		mTextView.setCompoundDrawables(drawable, null, null, null);// ����TextView��drawableleft
		mTextView.setCompoundDrawablePadding(10);// ����ͼƬ��text֮��ļ��
		mTextView.setText(mSelfSelect[i]);*/
	}
	
	private void initViews(){
		
	}
	
	/**
	 * ��ʼ������
	 */
	private void initDetail(){
		
	}
}
