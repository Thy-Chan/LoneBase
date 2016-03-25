package com.mpqi.imageloaderdemo;

import com.mpqi.imageloaderdemo.util.IMGSize;
import com.mpqi.imageloaderdemo.util.Options;
import com.nostra13.universalimageloader.core.ImageLoader;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class MainActivity extends Activity {
	private ImageView limageView1, limageView2, limageView3, limageView4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		limageView1 = (ImageView) findViewById(R.id.imageView1);
		limageView2 = (ImageView) findViewById(R.id.imageView2);
		limageView3 = (ImageView) findViewById(R.id.imageView3);
		limageView4 = (ImageView) findViewById(R.id.imageView4);

		// Ĭ����ʾͼƬ û���κ���ʾ����
		ImageLoader.getInstance().displayImage(
				"http://qiniuphotos.qiniudn.com/gogopher.jpg", limageView1);

		// ��ʾ����ͼƬ ������ʾ���� �м���ʱ��Ĭ��ͼƬ ����������ص�ͼƬ���浽���ش���
		ImageLoader.getInstance().displayImage(
				"http://ac-sxp70bmr.clouddn.com/3a97974a4deaa02b.jpg", limageView2,
				Options.getListOptions());

		ImageLoader.getInstance().displayImage(
				IMGSize.getImgUrl_imageView("http://ac-sxp70bmr.clouddn.com/3a97974a4deaa02b.jpg",
						20, 45, 1), limageView3, Options.getListOptions());

		ImageLoader.getInstance().displayImage(
				IMGSize.getImgUrl_imageMogr("http://ac-sxp70bmr.clouddn.com/3a97974a4deaa02b.jpg",
						230, 50, 150, 150), limageView4,
				Options.getListOptions());

		// �ֶ��������Ŀ¼�µ�ͼƬ�ļ�
		// ImageLoader.getInstance().clearDiscCache();
	}
}
