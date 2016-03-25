package com.mpqi.myjiujiujintu;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

/**
 * ��ȡ���ؽ���
 * 
 * @author mpqi
 *
 */
public class LoadingActivity extends Activity {
	private ImageView nloadingImg, nskipImg;// �м��֡����ͼƬ ���Ͻǵ�����ͼƬ
	private AnimationDrawable nloadingAnimationDrawable;// ֡����
	private Handler handler = new Handler();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.loading);

		initView();
		initLoadingImg();
	}

	/**
	 * �ؼ���ʼ��
	 */
	private void initView() {
		nloadingImg = (ImageView) findViewById(R.id.loading_img);
		nskipImg = (ImageView) findViewById(R.id.loading_skip);

		nskipImg.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (!isFinishing()) {
					startActivity(new Intent(LoadingActivity.this,
							MainActivity.class));
					finish();
				}
			}
		});
	}

	/**
	 * ��ʼ�����ض���
	 */
	private void initLoadingImg() {
		nloadingAnimationDrawable = (AnimationDrawable) nloadingImg
				.getDrawable();
		nloadingAnimationDrawable.start();// ����֡����
		new Thread(new Runnable() {// �������߳�

					@Override
					public void run() {
						try {
							Thread.sleep(10000);// �߳�˯ʮ�� ����ת����activity
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						handler.post(new Runnable() {// ֪ͨ���̹߳رյ�ǰ activity
														// ����mainActivity

							@Override
							public void run() {
								if (!isFinishing()) {
									startActivity(new Intent(
											LoadingActivity.this,
											MainActivity.class));
									finish();
								}

							}
						});
					}
				}).start();
	}

	@Override
	public void finish() {
		nloadingAnimationDrawable.stop();// ֹͣ֡����
		nloadingAnimationDrawable.setCallback(null);
		nloadingAnimationDrawable = null;
		nloadingImg = null;
		nskipImg = null;
		super.finish();
	}
}
