package com.mpqi.hello.impl;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class ButtonOnclickListener implements OnClickListener{
	private Context context;
	
	public ButtonOnclickListener(Context context) {
		super();
		this.context = context;
	}

	@Override
	public void onClick(View v) {
		Toast.makeText(context, "�ҵ���һ���ⲿʵ�ֵĵ���ӿ�", Toast.LENGTH_SHORT).show();		
	}

}
