package com.mpqi.animationdemo;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class FrameActivity extends Activity {

	private ImageView image;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.frame);
		image = (ImageView) findViewById(R.id.frame_image);

		image.setBackgroundResource(R.drawable.frame);
		AnimationDrawable anim = (AnimationDrawable) image.getBackground();
		anim.start();
	}
	
	/**
	 * ֹͣ
	 * @param view
	 */
	public void stopFrame(View view) {
		AnimationDrawable anim = (AnimationDrawable) image.getBackground();
		if (anim.isRunning()) {	//�����������,��ֹͣ
			anim.stop();
		}
	}
	
	public void runFrame(View view) {
		AnimationDrawable anim = (AnimationDrawable) image.getBackground();
		if (!anim.isRunning()) {	//�������ֹͣ,������
			anim.start();
		}
	}
}
