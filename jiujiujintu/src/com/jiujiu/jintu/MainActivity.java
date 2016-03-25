package com.jiujiu.jintu;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.FindCallback;
import com.jiujiu.jintu.bean.TourismProduct;
import com.jiujiu.jintu.fragment.MainIndexFragment;
import com.jiujiu.jintu.fragment.MainMoreFragment;
import com.jiujiu.jintu.fragment.MainTypeFragment;
import com.jiujiu.jintu.fragment.MainUserFragment;
import com.jiujiu.jintu.widget.MaskImage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

public class MainActivity extends FragmentActivity {

	private int lcurmainMaskImageId = R.id.mainbar1;
	private ViewPager lviewPager;
	private ArrayList<Fragment> lfragments;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		initViews();
		initViewPager();

	}

	/**
	 * ��ʼ���ؼ�
	 */
	private void initViews() {
		lviewPager = (ViewPager) findViewById(R.id.mainviewPager);
	}

	private void initViewPager() {
		lfragments = new ArrayList<Fragment>();

		MainIndexFragment indexFragment = new MainIndexFragment();
		MainTypeFragment typeFragment = new MainTypeFragment();
		MainUserFragment userFragment = new MainUserFragment();
		MainMoreFragment mainMoreFragment = new MainMoreFragment();
		MainUserFragment userFragment2 = new MainUserFragment();

		lfragments.add(indexFragment);
		lfragments.add(typeFragment);
		lfragments.add(userFragment2);
		lfragments.add(userFragment);
		lfragments.add(mainMoreFragment);

		// ��ViewPager����������
		lviewPager.setAdapter(new FragmentPagerAdapter(
				getSupportFragmentManager()) {

			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return lfragments.size();
			}

			@Override
			public Fragment getItem(int arg0) {
				// TODO Auto-generated method stub
				return lfragments.get(arg0);
			}
		});
		lviewPager.setCurrentItem(0);// ���õ�ǰ��ʾ��ǩҳΪ��һҳ
	}

	/**
	 * �ײ��˵�����¼�
	 * 
	 * @param view
	 */
	public void onclcikMainrBar(View view) {
		int id = view.getId();
		if (lcurmainMaskImageId == id) {
			return;
		}
		MaskImage maskImage = (MaskImage) findViewById(lcurmainMaskImageId);
		maskImage.setmImageSource(R.drawable.mainbarbackground_norlmal);
		maskImage.refresh();
		switch (view.getId()) {
		case R.id.mainbar1:
			lcurmainMaskImageId = R.id.mainbar1;
			lviewPager.setCurrentItem(0);
			break;

		case R.id.mainbar2:
			lcurmainMaskImageId = R.id.mainbar2;
			lviewPager.setCurrentItem(1);
			break;
		case R.id.mainbar3:
			lcurmainMaskImageId = R.id.mainbar3;
			lviewPager.setCurrentItem(2);
			break;
		case R.id.mainbar4:
			lcurmainMaskImageId = R.id.mainbar4;
			lviewPager.setCurrentItem(3);
			break;
		case R.id.mainbar5:
			lcurmainMaskImageId = R.id.mainbar5;
			lviewPager.setCurrentItem(4);
			break;
		}
		maskImage = (MaskImage) findViewById(lcurmainMaskImageId);
		maskImage.setmImageSource(R.drawable.mainbarbackground_green);
		maskImage.refresh();
		maskImage = null;
	}

	/**
	 * �˵������ؼ���Ӧ
	 */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			exitBy2Click(); // ����˫���˳�����
		}
		return false;
	}

	/**
	 * ˫���˳�����
	 */
	private static Boolean isExit = false;

	private void exitBy2Click() {
		Timer tExit = null;
		if (isExit == false) {
			isExit = true; // ׼���˳�
			Toast.makeText(this, "�ٰ�һ���˳�����", Toast.LENGTH_SHORT).show();
			tExit = new Timer();
			tExit.schedule(new TimerTask() {
				@Override
				public void run() {
					isExit = false; // ȡ���˳�
				}
			}, 2000); // ���2������û�а��·��ؼ�����������ʱ��ȡ�����ղ�ִ�е�����

		} else {
			finish();
			System.exit(0);
		}
	}
}
