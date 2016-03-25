package com.mpqi.fragmentdemo;

import com.mpqi.fragmentdemo.fragment.ContentFragment;
import com.mpqi.fragmentdemo.fragment.FriendFragment;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {
	private Button mTabWeixin;
	private Button mTabFriend;

	private ContentFragment mWeixin;
	private FriendFragment mFriend;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		// ��ʼ���ؼ��������¼�
		mTabWeixin = (Button) findViewById(R.id.bottombar_btn1);
		mTabFriend = (Button) findViewById(R.id.bottombar_btn2);
		mTabWeixin.setOnClickListener(this);
		mTabFriend.setOnClickListener(this);

		// ����Ĭ�ϵ�Fragment
		setDefaultFragment();
	}

	private void setDefaultFragment() {
		FragmentManager fm = getFragmentManager();
		// ����һ��fragment ������
		FragmentTransaction transaction = fm.beginTransaction();
		mWeixin = new ContentFragment();
		transaction.replace(R.id.id_content, mWeixin);
		transaction.commit();
	}

	@Override
	public void onClick(View v) {
		FragmentManager fm = getFragmentManager();
		// ����һ��fragment ������
		FragmentTransaction transaction = fm.beginTransaction();
		switch (v.getId()) {
		case R.id.bottombar_btn1:
			transaction.replace(R.id.id_content, mWeixin);
			break;

		case R.id.bottombar_btn2:
			mFriend = new FriendFragment();
			transaction.replace(R.id.id_content, mFriend);
			break;
		}
		//�����ύ
		transaction.commit();
	}
}
