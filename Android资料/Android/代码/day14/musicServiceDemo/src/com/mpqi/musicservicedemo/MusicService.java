package com.mpqi.musicservicedemo;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MusicService extends Service {
	// Ϊ��־�������ñ�ǩ
	private static String TAG = "MusicService";

	// �������ֲ���������
	private MediaPlayer mPlayer;

	@Override
	// �÷��񲻴�����Ҫ������ʱ�����ã�����startService()����bindService()��������ʱ���ø÷���
	public void onCreate() {
		Toast.makeText(this, "MusicSevice onCreate()", Toast.LENGTH_SHORT)
				.show();
		Log.e(TAG, "MusicSerice onCreate()");

		mPlayer = MediaPlayer.create(getApplicationContext(), R.raw.music);
		// ����ѭ������
		mPlayer.setLooping(true);
		super.onCreate();
	}

	@Override
	public void onStart(Intent intent, int startId) {
		Toast.makeText(this, "MusicSevice onStart()"
				, Toast.LENGTH_SHORT).show();
		Log.e(TAG, "MusicSerice onStart()");
		
		mPlayer.start();
		
		super.onStart(intent, startId);
	}

	@Override
	public void onDestroy() {
		Toast.makeText(this, "MusicSevice onDestroy()"
				, Toast.LENGTH_SHORT).show();
		Log.e(TAG, "MusicSerice onDestroy()");
		
		mPlayer.stop();
		
		super.onDestroy();
	}

	@Override
	//��������ͨ��bindService ����֪ͨ��Serviceʱ�÷���������
	public IBinder onBind(Intent intent) {
		Toast.makeText(this, "MusicSevice onBind()"
				, Toast.LENGTH_SHORT).show();
		Log.e(TAG, "MusicSerice onBind()");
		
		mPlayer.start();
		
		return null;
	}
	
	@Override
	//��������ͨ��unbindService����֪ͨ��Serviceʱ�÷���������
	public boolean onUnbind(Intent intent) {
		Toast.makeText(this, "MusicSevice onUnbind()"
				, Toast.LENGTH_SHORT).show();
		Log.e(TAG, "MusicSerice onUnbind()");
		
		mPlayer.stop();
		
		return super.onUnbind(intent);
	}

}
