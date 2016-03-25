package com.mpqi.broadcastreceiverdemo.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class OrderedReceive1 extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		String msg = intent.getStringExtra("msg");
		Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
		Log.i("Receiver", msg);
		
		Bundle bundle = new Bundle();
		bundle.putString("first", "���Ǵ�����㲥1���洫������Ϣ�����ǣ�");
		setResultExtras(bundle);//����Ϣ���ݰ� ���ݸ��ڶ����㲥
		abortBroadcast();//ȡ��BroadcastReceiver�ļ������� Ӱ��2�Ƿ����
	}

}
