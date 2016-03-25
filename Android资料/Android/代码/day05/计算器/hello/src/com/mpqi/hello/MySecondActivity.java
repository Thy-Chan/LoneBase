package com.mpqi.hello;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MySecondActivity extends Activity{

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.buttondemo);
	}
	
	
	public void myOnClick(View view){
		int id = view.getId();
		switch (id) {
		case R.id.button_second01:
			Toast.makeText(this, "�ҵ����һ��01", Toast.LENGTH_SHORT).show();
			break;
		case R.id.button_second02:
			Toast.makeText(this, "�ҵ����һ��02", Toast.LENGTH_SHORT).show();
			break;
		case R.id.button_second03:
			Toast.makeText(this, "�ҵ����һ��03", Toast.LENGTH_SHORT).show();
			break;
		case R.id.button_second04:
			Toast.makeText(this, "�ҵ����һ��04", Toast.LENGTH_SHORT).show();
			break;
		case R.id.button_second05:
			Toast.makeText(this, "�ҵ����һ��img", Toast.LENGTH_SHORT).show();
			break;
		}
	
	}
	
}
