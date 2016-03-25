package com.mpqi.dialogdemo;

import com.mpqi.dialogdemo.LoginDialogFragment.LoginInputListener;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements LoginInputListener {

	private EditText usernameEditText, pwdEditText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	}

	public void DialogOnclick(View view) {
		switch (view.getId()) {
		case R.id.btn_1:
			normalDialog();
			break;
		case R.id.btn_2:
			listDialog();
			break;
		case R.id.btn_3:
			RadioButtonDialog();
			break;
		case R.id.btn_4:
			MultiChoiceDialog();
			break;
		case R.id.btn_5:
			loginDialog();
			break;
		case R.id.btn_6:
			EditNameDialogFragment dialogFragment = new EditNameDialogFragment();
			dialogFragment.show(getFragmentManager(), "EditNameDialog");
			break;
		case R.id.btn_7:
			LoginDialogFragment loginDialogFragment = new LoginDialogFragment();
			loginDialogFragment.show(getFragmentManager(), "LoginDialog");
			break;
		}
	}

	/**
	 * ��ʾһ��Ի���
	 */
	private void normalDialog() {
		AlertDialog.Builder dialog = new AlertDialog.Builder(this);
		dialog.setTitle("��ʾ");
		dialog.setMessage("��ȷ��Ҫ�˳�ô��");
		dialog.setIcon(R.drawable.ic_launcher);// ���ñ���ͼ ѡ��
		dialog.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(MainActivity.this, "������ȷ��", Toast.LENGTH_SHORT)
						.show();
				dialog.dismiss();// �Ի�����ʧ
			}
		});
		dialog.setNeutralButton("����", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(MainActivity.this, "�����˺���", Toast.LENGTH_SHORT)
						.show();
				dialog.dismiss();// �Ի�����ʧ
			}
		});
		dialog.setNegativeButton("ȡ��", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(MainActivity.this, "������ȡ��", Toast.LENGTH_SHORT)
						.show();
				dialog.dismiss();// �Ի�����ʧ
			}
		});

		dialog.create();// ����dialog
		dialog.show();// ��ʾdialog
	}

	/**
	 * �б�Ի���
	 */
	private void listDialog() {
		final String[] items = new String[] { "����", "����", "����", "����" };
		AlertDialog.Builder dialog = new AlertDialog.Builder(this);
		dialog.setTitle("��ʾ");
		dialog.setIcon(R.drawable.ic_launcher);
		dialog.setItems(items, new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(MainActivity.this, items[which],
						Toast.LENGTH_SHORT).show();

			}
		});
		dialog.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(MainActivity.this, "������ȷ��", Toast.LENGTH_SHORT)
						.show();
				dialog.dismiss();// �Ի�����ʧ
			}
		});
		dialog.create();// �����Ի���
		dialog.show();// ��ʾ�Ի���
	}

	/**
	 * ��ѡ��ť�Ի���
	 */
	private void RadioButtonDialog() {
		final String[] items = new String[] { "Java", ".net", "Android", "php",
				"ast" };
		AlertDialog.Builder dialog = new AlertDialog.Builder(this);
		dialog.setTitle("��ʾ");
		dialog.setIcon(R.drawable.ic_launcher);
		dialog.setSingleChoiceItems(items, 2,
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						Toast.makeText(MainActivity.this, items[which],
								Toast.LENGTH_SHORT).show();
						;

					}
				});
		dialog.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(MainActivity.this, "������ȷ��", Toast.LENGTH_SHORT)
						.show();
				dialog.dismiss();// �Ի�����ʧ
			}
		});
		dialog.create().show();
	}

	/**
	 * ��ѡ��ť�Ի���
	 */
	private void MultiChoiceDialog() {
		final String[] items = new String[] { "Java", ".net", "Android", "php",
				"ast" };
		boolean[] checkedItems = new boolean[] { false, true, false, false,
				true };
		AlertDialog.Builder dialog = new AlertDialog.Builder(this);
		dialog.setTitle("��ʾ");
		dialog.setIcon(R.drawable.ic_launcher);
		dialog.setMultiChoiceItems(items, checkedItems,
				new DialogInterface.OnMultiChoiceClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which,
							boolean isChecked) {
						Toast.makeText(MainActivity.this,
								items[which] + isChecked, Toast.LENGTH_SHORT)
								.show();
					}
				});
		dialog.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(MainActivity.this, "������ȷ��", Toast.LENGTH_SHORT)
						.show();
				dialog.dismiss();// �Ի�����ʧ
			}
		});
		dialog.create().show();
	}

	/**
	 * �Զ�����ʽ�Ի��򣨵�¼��
	 */
	private void loginDialog() {
		LayoutInflater layout = LayoutInflater.from(this);
		View view = layout.inflate(R.layout.login_main, null);

		usernameEditText = (EditText) view.findViewById(R.id.ed_username);
		pwdEditText = (EditText) view.findViewById(R.id.ed_password);

		AlertDialog.Builder dialog = new AlertDialog.Builder(this);
		dialog.setTitle("���¼");
		dialog.setIcon(R.drawable.ic_launcher);
		dialog.setView(view);
		dialog.setNegativeButton("ȡ��", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(MainActivity.this, "�����ȡ��", Toast.LENGTH_SHORT)
						.show();
				dialog.dismiss();
			}
		});
		dialog.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(
						MainActivity.this,
						"�����ȷ��\t" + "�û�����"
								+ usernameEditText.getText().toString()
								+ "\t����:" + pwdEditText.getText().toString(),
						Toast.LENGTH_SHORT).show();
				dialog.dismiss();
			}
		});
		dialog.create().show();
	}

	@Override
	public void onLoginInputComplete(String username, String password) {
		Toast.makeText(this, "�ʺţ�" + username + ",  ���� :" + password,
				Toast.LENGTH_SHORT).show();
	}
}
