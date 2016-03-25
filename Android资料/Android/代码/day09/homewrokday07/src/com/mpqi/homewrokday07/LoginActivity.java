package com.mpqi.homewrokday07;

import com.mpqi.homewrokday07.cfg.CONFIG;
import com.mpqi.homewrokday07.cfg.User;
import com.mpqi.homewrokday07.cfg.Users;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {

	private EditText usernameEditText // �û���
			,
			pwdEditText;// ����
	private Button commitBtn;// �ύ��ť

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.userlogin_main);
		initViews();
		commitBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// ��ȡ�û���������
				String username = usernameEditText.getText().toString();
				String pwd = pwdEditText.getText().toString();
				//�ж������Ϊ��
				if (TextUtils.isEmpty(username) || TextUtils.isEmpty(pwd)) {
					Toast.makeText(LoginActivity.this, "�û������벻��Ϊ��", Toast.LENGTH_SHORT).show();
					return;
				}
				// �ȶ��û���������
				// �û��������ڻ����������
				if (!Users.isUser(username)) {
					Toast.makeText(LoginActivity.this, "�û��������ڻ����������", Toast.LENGTH_SHORT).show();
					return;
				}
				//�����������
				if (!Users.login(username, pwd)) {
					Toast.makeText(LoginActivity.this, "�����������", Toast.LENGTH_SHORT).show();
					return;
				}
				//�û���������������ȷ  ��¼
				// ��ת  ����  useranme
				Intent intent = new Intent();
				intent.putExtra(User.USERNAME, username);
				setResult(CONFIG.login_RESULTCODE, intent);
				finish();
			}
		});
	}

	private void initViews() {
		usernameEditText = (EditText) findViewById(R.id.login_username);
		pwdEditText = (EditText) findViewById(R.id.login_pwd);
		commitBtn = (Button) findViewById(R.id.login_commit);
	}
}
