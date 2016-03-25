package com.mpqi.leanclouddemo;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVUser;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private TextView contentTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		contentTextView = (TextView) findViewById(R.id.content);
	}

	public void myOnclick(View view) {
		Intent intent = new Intent(this, LoginOrRegisAtctivity.class);
		switch (view.getId()) {
		case R.id.button1:
			intent.putExtra("requestCode", 1);
			startActivityForResult(intent, 1);
			break;

		case R.id.button2:
			intent.putExtra("requestCode", 2);
			startActivityForResult(intent, 2);
			break;
		case R.id.button3://ֱ�ӵ�¼
			AVUser avUser = AVUser.getCurrentUser();
			if (avUser != null) {//���ڻ���
				String username = avUser.getUsername();
				contentTextView.setText(username+" ֱ�ӵ�¼�ɹ��ˣ�");
			}else {
				contentTextView.setText("��ǰû�л����û�����");
			}
			break;
		case R.id.button4://�˳���¼
			AVUser.logOut();
			contentTextView.setText("�˳��ɹ�");
			break;
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch (resultCode) {
		case 1://��¼
			Toast.makeText(this, "��¼�ɹ�", Toast.LENGTH_SHORT).show();
			AVUser user = data.getParcelableExtra("user");
			contentTextView.setText(user.getUsername()+"��¼�ɹ�");
			break;

		case 2://ע��
			Toast.makeText(this, "ע��ɹ�", Toast.LENGTH_SHORT).show();
			AVUser user1 = data.getParcelableExtra("user");
			contentTextView.setText(user1.getUsername()+"ע��ɹ�");
			break;
		}
	}
}
