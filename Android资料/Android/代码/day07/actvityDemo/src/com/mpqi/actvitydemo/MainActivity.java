package com.mpqi.actvitydemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

	
	public void MyOnclick(View view) {
		finish();
	}
	
	
	public void MyOnclick2(View view) {
		Intent intent = new Intent(this , myGoActivity.class);
		startActivity(intent);
	}
	
	@Override
	/***
	 * ��ʼ������
	 */
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.i("ActivityDemo", "-----------onCreate-----------");
	}
	
	
	@Override
	/**
	 * ��������
	 */
	protected void onStart() {
		super.onStart();
		Log.i("ActivityDemo", "-----------onStart-----------");
	}
	
	@Override
	/**
	 * ����������
	 */
	protected void onResume() {
		super.onResume();
		Log.i("ActivityDemo", "-----------onResume-----------");
	}
	
	
	@Override
	/**
	 * ��ͣ  ���ݵȴ�
	 */
	protected void onPause() {
		super.onPause();
		Log.i("ActivityDemo", "-----------onPause-----------");
	}
	
	@Override
	/**
	 *  ��̨�ȴ�  �ϳ�ʱ�� ---> onRestart() --->onStart
	 *        ���̱�ϵͳɱ���� ----> onCreate()
	 */
	protected void onStop() {
		super.onStop();
		Log.i("ActivityDemo", "-----------onStop-----------");
	}
	
	@Override
	/**
	 * ����
	 */
	protected void onDestroy() {
		super.onDestroy();
		Log.i("ActivityDemo", "-----------onDestroy-----------");
	}
	
	@Override
	/**
	 * �ϳ��ȴ��� ���±����� ---> onStart
	 */
	protected void onRestart() {
		super.onRestart();
		Log.i("ActivityDemo", "-----------onRestart-----------");
	}
}
