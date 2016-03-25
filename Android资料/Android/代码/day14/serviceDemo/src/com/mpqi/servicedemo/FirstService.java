package com.mpqi.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class FirstService extends Service {

	/** �������� */
	boolean threadDisable;// ���Ƶ�ǰ�Ƿ���Ҫ��ӡ count falseʱ��ӡ true ʱֹͣ��ӡ
	int count;

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		/** ����һ���̣߳�ÿ���������һ�����ڿ���̨����Log��� */
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (!threadDisable) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					count++;
					Log.v("FirstService", "Count is " + count);
				}

			}
		}).start();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		/** ����ֹͣʱ����ֹ�������� */
		this.threadDisable = true;
		Log.i("CountService", "����������أ�");
	}

	public int getConunt() {
		return count;
	}
	
	//�˷�����Ϊ�˿�����Acitity�л�÷����ʵ��   
	public class ServiceBinder extends Binder {
		public FirstService getService(){
			return FirstService.this;
		}
	}
}
