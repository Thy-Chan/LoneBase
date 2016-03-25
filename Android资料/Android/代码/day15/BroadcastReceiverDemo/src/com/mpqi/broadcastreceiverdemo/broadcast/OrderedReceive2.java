package com.mpqi.broadcastreceiverdemo.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class OrderedReceive2 extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		//����ǰһ��BroadcastReceiver �������key Ϊfirst����Ϣ
		Bundle bundle = getResultExtras(true);
		String msg = bundle.getString("first");
		Toast.makeText(context, msg+"�ڶ�������㲥", Toast.LENGTH_SHORT).show();
		Log.i("Receiver", msg);
	}

}
