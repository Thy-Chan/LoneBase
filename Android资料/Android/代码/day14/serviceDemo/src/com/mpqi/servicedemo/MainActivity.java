package com.mpqi.servicedemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	Button startServiceButton;// ��������ť
	Button shutDownServiceButton;// �رշ���ť
	Button startBindServiceButton;// �����󶨷���ť
	Button startActionServerButton;// ͨ��Action��������ť

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		getWidget();
		regiestListener();
	}

	/** ������ */
	public void getWidget() {
		startServiceButton = (Button) findViewById(R.id.startServerButton);
		startBindServiceButton = (Button) findViewById(R.id.startBindServerButton);
		shutDownServiceButton = (Button) findViewById(R.id.sutdownServerButton);
		startActionServerButton = (Button) findViewById(R.id.startActionServerButton);
	}

	/** Ϊ��ť��Ӽ��� */
	public void regiestListener() {
		startServiceButton.setOnClickListener(startService);
		shutDownServiceButton.setOnClickListener(shutdownService);
		startBindServiceButton.setOnClickListener(startBinderService);
		startActionServerButton.setOnClickListener(startActionService);
	}

	/** ͨ��Action����������¼����� */
	public OnClickListener startActionService = new OnClickListener() {

		@Override
		public void onClick(View v) {
			/** ������ťʱ�������� */
			Intent intent = new Intent();
			intent.setAction("com.mpqi.servicedemo.service.MY_FIRSTSERVICE");
			startService(intent);
			Log.v("MainStadyServics", "By Action start Service");
		}
	};

	/** ����������¼����� */
	public OnClickListener startService = new OnClickListener() {

		@Override
		public void onClick(View v) {
			/** ������ťʱ�������� */
			Intent intent = new Intent(MainActivity.this, FirstService.class);
			startService(intent);
			Log.v("MainStadyServics", "start Service");
		}
	};

	/** �رշ��� */
	public OnClickListener shutdownService = new OnClickListener() {

		@Override
		public void onClick(View v) {
			/** ������ťʱ�������� */
			Intent intent = new Intent(MainActivity.this, FirstService.class);
			/** ֹͣ���� */
			stopService(intent);
			Log.v("MainStadyServics", "shutDown serveice");
		}
	};

	/** �򿪰󶨷����Activity */
	public OnClickListener startBinderService = new OnClickListener() {

		@Override
		public void onClick(View v) {
			/** ������ťʱ�������� */
			Intent intent = new Intent(MainActivity.this,
					UseBriderServiceActivity.class);
			startActivity(intent);
			Log.v("MainStadyServics", "start Binder Service");
		}
	};
}
