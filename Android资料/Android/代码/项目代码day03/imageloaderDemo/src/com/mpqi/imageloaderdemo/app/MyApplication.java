package com.mpqi.imageloaderdemo.app;

import java.io.File;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.utils.StorageUtils;

import android.app.Application;

public class MyApplication extends Application{
	
	@Override
	public void onCreate() {
		super.onCreate();
		initimagelodaer();
	}

	/**
	 * ��ʼ�� imagelaoder �������
	 */
	private void initimagelodaer(){
		//���û���·��
		File cacheDir = StorageUtils.getOwnCacheDirectory(this,"MPQI/Cache" );
		// 1.���ImageLoaderConfiguration������
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
				this)
				// max width, max,height���������ÿ�������ļ�����󳤿�
				// .memoryCacheExtraOptions(400, 400)
				// �̳߳��ڼ��ص�����
				.threadPoolSize(3)
				// �߳����ȼ�
				.threadPriority(Thread.NORM_PRIORITY - 2)
				// Ӳ�̻���50MB
				.discCacheSize(50 * 1024 * 1024)
				// �������ʱ���URI������MD5
				.discCacheFileNameGenerator(new Md5FileNameGenerator())
				// �������ʱ���URI������HASHCODE����
				.discCacheFileNameGenerator(new HashCodeFileNameGenerator())
				.tasksProcessingOrder(QueueProcessingType.LIFO)
				// �����File����
				.discCacheFileCount(100)
				// �Զ��建��·��
				.discCache(new UnlimitedDiscCache(cacheDir))
				.defaultDisplayImageOptions(DisplayImageOptions.createSimple())
				// connectTimeout (5 s), readTimeout (30 s)��ʱʱ��
				.imageDownloader(
						new BaseImageDownloader(this, 5 * 1000, 30 * 1000))
				.build();
		ImageLoader.getInstance().init(config);
	}
}
