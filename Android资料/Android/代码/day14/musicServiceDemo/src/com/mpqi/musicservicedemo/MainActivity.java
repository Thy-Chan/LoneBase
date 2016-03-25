package com.mpqi.musicservicedemo;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	// Ϊ��־�������ñ�ǩ
	private static String TAG = "MusicService";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// ���Toast��Ϣ����־��¼
		Toast.makeText(this, "MusicServiceActivity", Toast.LENGTH_SHORT).show();
		Log.e(TAG, "MusicServiceActivity");

		initlizeViews();
	}

	private void initlizeViews() {
		Button btnStart = (Button) findViewById(R.id.startMusic);
		Button btnStop = (Button) findViewById(R.id.stopMusic);
		Button btnBind = (Button) findViewById(R.id.bindMusic);
		Button btnUnbind = (Button) findViewById(R.id.unbindMusic);

		// ������������
		OnClickListener ocl = new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this,
						MusicService.class);

				switch (v.getId()) {
				case R.id.startMusic:
					// ��ʼ����
					startService(intent);
					break;
				case R.id.stopMusic:
					// ֹͣ����
					stopService(intent);
					break;
				case R.id.bindMusic:
					// �󶨷���
					bindService(intent, conn, Context.BIND_AUTO_CREATE);
					break;
				case R.id.unbindMusic:
					// ������
					unbindService(conn);
					break;
				}

			}
		};

		// �󶨵������
		btnStart.setOnClickListener(ocl);
		btnStop.setOnClickListener(ocl);
		btnBind.setOnClickListener(ocl);
		btnUnbind.setOnClickListener(ocl);

	}

	// ����������Ӷ���
	ServiceConnection conn = new ServiceConnection() {

		@Override
		public void onServiceDisconnected(ComponentName name) {

		}

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {

		}
	};
}
