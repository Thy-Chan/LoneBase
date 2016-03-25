package com.jiujiu.jintu;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.LogInCallback;
import com.avos.avoscloud.RequestMobileCodeCallback;
import com.jiujiu.jintu.util.Code;

import android.app.Activity;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class RegisterActivity extends Activity {
	private ImageView verCodeImageView;
	private String realCode;// ��֤��
	private EditText phoneEditText// �ֻ��ſ�
			,
			pwdEditText// �����
			, verificationCodeEditText // ��֤���
			, phonecodeEditText; // �ֻ���֤���
	private ImageView showPwdImageView;// ��ʾ���� ��������
	private boolean showPwdFlag = false;// false ���� true ��ʾ
	private String phonenum// �ֻ�����
			,
			verificationCode // ��֤��
			, phoneCode// �ֻ���֤��
			, password;// ����

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_regist);
		initView();
	}

	public void initView() {
		pwdEditText = (EditText) findViewById(R.id.regist_edt_pwd);
		phoneEditText = (EditText) findViewById(R.id.regist_edit_phone);
		verificationCodeEditText = (EditText) findViewById(R.id.regist_edit_verification_code);
		phonecodeEditText = (EditText) findViewById(R.id.regist_edit_phone_code);
		
		showPwdImageView = (ImageView) findViewById(R.id.regist_img_show_pwd);
		verCodeImageView = (ImageView) findViewById(R.id.regist_img_verification_code);
		// ����֤����ͼƬ����ʽ��ʾ����
		verCodeImageView.setImageBitmap(Code.getInstance().createBitmap());
		realCode = Code.getInstance().getCode();
	}

	public void btnOnclick(View view) {
		int id = view.getId();
		switch (id) {
		case R.id.regist_close:// �ر�
			finish();
			break;
		case R.id.regist_img_verification_code:// ��֤�����
			initVerificationCode();
			break;
		case R.id.regist_img_show_pwd:// ��ʾ���� ��������
			if (showPwdFlag) {
				showPwdFlag = false;
				pwdEditText.setInputType(InputType.TYPE_CLASS_TEXT
						| InputType.TYPE_TEXT_VARIATION_PASSWORD);
				showPwdImageView.setImageResource(R.drawable.show_password);
			} else {
				showPwdFlag = true;
				pwdEditText
						.setInputType((InputType.TYPE_CLASS_TEXT
								| InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD));
				showPwdImageView
						.setImageResource(R.drawable.show_password_pressed);
			}
			break;
		case R.id.regist_text_phone_code:// ������֤��
			phonenum = phoneEditText.getText().toString();// ��ȡ�绰����
			if (isMobileNO(phonenum)) {// ͨ���绰������֤

				new Thread(new Runnable() {

					@Override
					public void run() {
						try {
							AVOSCloud.requestSMSCode(phonenum, getResources()
									.getString(R.string.app_name), "���û�ע��", 5);// ������֤�롢�ֻ��š�Ӧ��������������10����
						} catch (AVException e) {
							e.printStackTrace();
						}
					}
				}).start();

			} else {
				Toast.makeText(this, "�ֻ��������벻��ȷ", Toast.LENGTH_SHORT).show();
			}
			break;
		case R.id.regist_btn_regist:// ���ע��
			phonenum = phoneEditText.getText().toString();
			password = pwdEditText.getText().toString();
			verificationCode = verificationCodeEditText.getText().toString();
			phoneCode = phonecodeEditText.getText().toString();
			if (TextUtils.isEmpty(verificationCode)) {// ��֤��Ϊ��
				Toast.makeText(this, "��֤�벻��Ϊ��", Toast.LENGTH_SHORT).show();
				initVerificationCode();
				return;
			} else if (!realCode.toLowerCase().equals(verificationCode.toLowerCase())) {
				Toast.makeText(this, "��֤�����", Toast.LENGTH_SHORT).show();
				initVerificationCode();
				return;
			}
			if (TextUtils.isEmpty(phonenum)) {
				Toast.makeText(this, "�ֻ����벻��Ϊ��", Toast.LENGTH_SHORT).show();
				initVerificationCode();
				return;
			} else if (!isMobileNO(phonenum)) {
				Toast.makeText(this, "�ֻ��������벻��ȷ", Toast.LENGTH_SHORT).show();
				initVerificationCode();
				return;
			}
			if (TextUtils.isEmpty(phoneCode)) {
				Toast.makeText(this, "�ֻ���֤�벻��Ϊ��", Toast.LENGTH_SHORT).show();
				initVerificationCode();
				return;
			}
			if (TextUtils.isEmpty(password)) {
				Toast.makeText(this, "���벻��Ϊ��", Toast.LENGTH_SHORT).show();
				initVerificationCode();
				return;
			} else if (password.length() < 6 || password.length() > 16) {
				Toast.makeText(this, "���볤��Ϊ6��16λ", Toast.LENGTH_SHORT).show();
				initVerificationCode();
				return;
			}
			AVUser.signUpOrLoginByMobilePhoneInBackground(phonenum,
					phoneCode, new LogInCallback<AVUser>() {
						public void done(AVUser user, AVException e) {
							// ���˾������ע����¼�Ĺ��ܡ��û����û�����Ϊ�ֻ�����
							if (e == null) {// ��֤�ɹ�
								user.setPassword(password);
								user.saveInBackground();
								Toast.makeText(RegisterActivity.this,
										"��ϲ����ע��ɹ���", Toast.LENGTH_SHORT).show();
							} else {// ��֤ʧ��
								Toast.makeText(RegisterActivity.this,
										"�ֻ���֤���������", Toast.LENGTH_SHORT).show();
							}

						}
					});
			break;
		}

	}

	private void initVerificationCode() {
		verificationCodeEditText.setText("");
		verCodeImageView.setImageBitmap(Code.getInstance().createBitmap());
		realCode = Code.getInstance().getCode();
	}

	/**
	 * ��֤�ֻ���ʽ
	 */
	private boolean isMobileNO(String mobiles) {
		/*
		 * �ƶ���134��135��136��137��138��139��150��151��157(TD)��158��159��187��188
		 * ��ͨ��130��131��132��152��155��156��185��186 ���ţ�133��153��180��189����1349��ͨ��
		 * �ܽ��������ǵ�һλ�ض�Ϊ1���ڶ�λ�ض�Ϊ3��5��8������λ�õĿ���Ϊ0-9
		 */
		String telRegex = "[1][358]\\d{9}";// "[1]"�����1λΪ����1��"[358]"����ڶ�λ����Ϊ3��5��8�е�һ����"\\d{9}"��������ǿ�����0��9�����֣���9λ��
		if (TextUtils.isEmpty(mobiles))
			return false;
		else
			return mobiles.matches(telRegex);
	}

	/**
	 * ���ؼ���Ӧ
	 */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			finish();
		}
		return false;
	}
}
