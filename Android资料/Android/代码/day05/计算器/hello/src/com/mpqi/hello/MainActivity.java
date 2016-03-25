package com.mpqi.hello;


import com.mpqi.hello.impl.ButtonOnclickListener;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{
	private Button nmyButton;
	private Button nmyWaiButton;
	private Button nmyNeiButton;
	private Button nmyActivityButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.textdemo);
		
		initViews();
		
		nmyButton.setOnClickListener(new OnClickListener() {//�����ڲ���
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, MySecondActivity.class);
				startActivity(intent);
			}
		});
		
		nmyWaiButton.setOnClickListener(new ButtonOnclickListener(this));//�ⲿ��
		nmyNeiButton.setOnClickListener(new ButtonNeiOnClickListner());//�ڲ���
		nmyActivityButton.setOnClickListener(this);//activity ����ʵ�ֵ���ӿ�
	}
	
	private void initViews(){
		nmyButton = (Button) findViewById(R.id.button);
		nmyWaiButton = (Button) findViewById(R.id.button_wai);
		nmyNeiButton = (Button) findViewById(R.id.button_nei);
		nmyActivityButton = (Button) findViewById(R.id.button_activity);
	}
	
	
	private class ButtonNeiOnClickListner implements OnClickListener{

		@Override
		public void onClick(View v) {
			Toast.makeText(MainActivity.this, "�ڲ���ʵ�ֵĵ���ӿ�", Toast.LENGTH_SHORT).show();
			Intent intent = new Intent(MainActivity.this , myThirdActivity.class);
			startActivity(intent);
		}
		
	}


	@Override
	public void onClick(View v) {
		Toast.makeText(this, "activity����ʵ�ֵĵ���ӿ�", Toast.LENGTH_SHORT).show();
		
	}
}
