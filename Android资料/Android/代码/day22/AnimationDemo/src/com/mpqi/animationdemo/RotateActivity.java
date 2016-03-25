package com.mpqi.animationdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;

public class RotateActivity extends Activity {

	private int currAngle;//��ǰͼƬ�ĽǶ� ��ʼ��0
	private View piechart;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.rotate);
		piechart = findViewById(R.id.piechart);// �ҵ�ͼƬ�ؼ�
		Animation animation = AnimationUtils.loadAnimation(this, R.anim.rotate);// ��ȡ����
		piechart.startAnimation(animation);
		currAngle = 0;
	}

	/**
	 * ˳ʱ��
	 */
	public void positive(View v) {
		//Animation.RELATIVE_TO_SELF ������Լ��İٷ���
		Animation animation = new RotateAnimation(currAngle, currAngle + 90,
				Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
				0.5f);
		/** ���ٲ�ֵ�� */
		LinearInterpolator lr = new LinearInterpolator();
		animation.setInterpolator(lr);
		animation.setDuration(1000);//����ʱ��1��
		/** ������ɺ󲻻ָ�ԭ״ */
		animation.setFillAfter(true);
		currAngle += 90;//��¼��ǰ�ĽǶ�
		if (currAngle > 360) {
			currAngle = currAngle - 360;
		}
		piechart.startAnimation(animation);
	}
	
	/**
	 * ��ʱ��
	 * @param v
	 */
	public void negative(View v) {
		Animation anim = new RotateAnimation(currAngle, currAngle - 180, Animation.RELATIVE_TO_SELF, 0.5f,
				Animation.RELATIVE_TO_SELF, 0.5f);
		/** ���ٲ�ֵ�� */
		LinearInterpolator lir = new LinearInterpolator();
		anim.setInterpolator(lir);
		anim.setDuration(1000);
		/** ������ɺ󲻻ָ�ԭ״ */
		anim.setFillAfter(true);
		currAngle -= 180;
		if (currAngle < -360) {
			currAngle = currAngle + 360;
		}
		piechart.startAnimation(anim);
	}
}
