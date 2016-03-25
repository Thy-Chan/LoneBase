package com.mpqi.myjiujiujintu;

import java.util.Timer;
import java.util.TimerTask;

import com.mpqi.myjiujiujintu.fragment.MainIndexFragment;
import com.mpqi.myjiujiujintu.fragment.MainMoreFragment;
import com.mpqi.myjiujiujintu.fragment.MainPicFragment;
import com.mpqi.myjiujiujintu.fragment.MainTypeFragment;
import com.mpqi.myjiujiujintu.fragment.MainUserFragment;
import com.mpqi.myjiujiujintu.fragment.SearchCityFragment;
import com.mpqi.myjiujiujintu.fragment.iTopTitleListener;
import com.mpqi.myjiujiujintu.fragment.SearchCityFragment.SetChoosedNameListner;
import com.mpqi.myjiujiujintu.util.JJJCONFIG;
import com.mpqi.myjiujiujintu.widget.MaskImage;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

/**
 * ������
 * 
 * @author mpqi
 *
 */
public class MainActivity extends Activity implements SetChoosedNameListner {
	// private ViewPager lviewPager;
	// private ArrayList<Fragment> lfragments;
	private int lcurmainMaskImageId = R.id.mainbar1;

	private SearchCityFragment lSearchCityFragment;// ��λλ��
	private MainIndexFragment fragment1;// MainIndexFragment();
	private MainTypeFragment fragment2;// MainTypeFragment();
	private MainUserFragment fragment4;// MainUserFragment();
	private MainPicFragment fragment3;// MainPicFragment();
	private MainMoreFragment fragment5;// new MainMoreFragment
	private Fragment[] lfragments;

	private int lcurFragment;//��ǰfragment

	private boolean searchFlag = false;// true ��ʾ��λλ������
	private String choosedName = "�ɶ�";
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
		initViewPager();
	}

	private void initView() {
		// lviewPager = (ViewPager) findViewById(R.id.mainviewPager);
		lSearchCityFragment = new SearchCityFragment();
		
	}

	private void initViewPager() {
		// lfragments = new ArrayList<Fragment>();

		fragment1 = new MainIndexFragment();
		fragment2 = new MainTypeFragment();
		fragment4 = new MainUserFragment();
		fragment3 = new MainPicFragment();
		fragment5 = new MainMoreFragment();

		lfragments = new Fragment[] { fragment1, fragment2, fragment3,
				fragment4, fragment5 };
		FragmentTransaction ftTransaction = getFragmentManager()
				.beginTransaction();
		ftTransaction.add(R.id.main_content, lfragments[4]);
		ftTransaction.add(R.id.main_content, lfragments[3]);
		ftTransaction.add(R.id.main_content, lfragments[2]);
		ftTransaction.add(R.id.main_content, lfragments[1]);
		ftTransaction.add(R.id.main_content, lfragments[0]);
		ftTransaction.hide(lfragments[4]);
		ftTransaction.hide(lfragments[3]);
		ftTransaction.hide(lfragments[2]);
		ftTransaction.hide(lfragments[1]);
		ftTransaction.commit();
		lcurFragment = 0;
		
		// lfragments.add(fragment1);
		// lfragments.add(fragment2);
		// lfragments.add(fragment3);
		// lfragments.add(fragment4);
		// lfragments.add(fragment5);

		// lviewPager.setAdapter(new FragmentPagerAdapter(
		// getSupportFragmentManager()) {
		//
		// @Override
		// public int getCount() {
		// return lfragments.size();
		// }
		//
		// @Override
		// public Fragment getItem(int arg0) {
		// return lfragments.get(arg0);
		// }
		// });
		//
		// lviewPager.setCurrentItem(0);
	}

	/**
	 * �ײ��˵�����¼�
	 * 
	 * @param view
	 */
	public void onclcikMainrBar(View view) {
		int id = view.getId();
		if (id == lcurmainMaskImageId) {// �����ǰ������ǵ�ǰҳ��ĵ������������ú���
			return;
		}
		// �Ѹղŵ��Ǹ�������ť��ɻ�ɫ����
		MaskImage maskImage = (MaskImage) findViewById(lcurmainMaskImageId);
		maskImage.setmImageSource(R.drawable.mainbarbackground_norlmal);
		maskImage.refresh();
		FragmentTransaction ftTransaction = getFragmentManager()
				.beginTransaction();
		ftTransaction.hide(lfragments[lcurFragment]);
		switch (id) {
		case R.id.mainbar1:
			lcurmainMaskImageId = R.id.mainbar1;
			lcurFragment = 0;
			((iTopTitleListener)lfragments[lcurFragment]).setLocal(choosedName);
			// lviewPager.setCurrentItem(0);
			break;
		case R.id.mainbar2:
			lcurmainMaskImageId = R.id.mainbar2;
			lcurFragment = 1;
			((iTopTitleListener)lfragments[lcurFragment]).setLocal(choosedName);
			// lviewPager.setCurrentItem(1);
			break;
		case R.id.mainbar3:
			lcurmainMaskImageId = R.id.mainbar3;
			lcurFragment = 2;
			// lviewPager.setCurrentItem(2);
			break;
		case R.id.mainbar4:
			lcurmainMaskImageId = R.id.mainbar4;
			lcurFragment = 3;
			// lviewPager.setCurrentItem(3);
			break;
		case R.id.mainbar5:
			lcurmainMaskImageId = R.id.mainbar5;
			lcurFragment = 4;
			// lviewPager.setCurrentItem(4);
			break;
		}

		// �ѵ�ǰ�ĵ�����ť�����ɫ����
		maskImage = (MaskImage) findViewById(lcurmainMaskImageId);
		maskImage.setmImageSource(R.drawable.mainbarbackground_green);
		maskImage.refresh();

		maskImage = null;
		ftTransaction.show(lfragments[lcurFragment]);
		ftTransaction.commit();
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch (resultCode) {
		case JJJCONFIG.REGIST_RESULT_SUCCESS:// ע��ɹ�
			Toast.makeText(this, "��ϲ��ע��ɹ�", Toast.LENGTH_SHORT).show();
			fragment4.isLogin();
			break;
		case JJJCONFIG.LOGIN_RESULT_SUCCESS:// ��¼�ɹ�
			Toast.makeText(this, "��¼�ɹ�", Toast.LENGTH_SHORT).show();
			fragment4.isLogin();
			break;
		}
	}

	/**
	 * ѡ��ǰλ��
	 * 
	 * @param view
	 */
	public void searchOnclick(View view) {
		switch (view.getId()) {
		case R.id.top_location_text:
			lSearchCityFragment.setChoosedName(choosedName);
			FragmentTransaction ftTransaction = getFragmentManager()
					.beginTransaction();
			ftTransaction.setCustomAnimations(
					R.anim.fragment_searchcity_silde_bottom_in, 0);
			ftTransaction.add(R.id.main_search_city_content,
					lSearchCityFragment);
			ftTransaction.commit();
			searchFlag = true;
			break;
		}
	}

	/**
	 * �˵������ؼ���Ӧ
	 */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			if (searchFlag) {
				searchFlag = false;
				FragmentTransaction ftTransaction = getFragmentManager()
						.beginTransaction();
				ftTransaction.setCustomAnimations(0,
						R.anim.fragment_searchcity_silde_bottom_out);
				ftTransaction.remove(lSearchCityFragment);
				ftTransaction.commit();
			} else {
				exitBy2Click(); // ����˫���˳�����
			}

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

	@Override
	public void setChoosedName(String choosedName) {
		this.choosedName = choosedName;

	}

	@Override
	public void close() {
		searchFlag = false;
		FragmentTransaction ftTransaction = getFragmentManager()
				.beginTransaction();
		ftTransaction.setCustomAnimations(0,
				R.anim.fragment_searchcity_silde_bottom_out);
		ftTransaction.remove(lSearchCityFragment);
		ftTransaction.commit();
		((iTopTitleListener)lfragments[lcurFragment]).setLocal(choosedName);
	}

	@Override
	public String getChoosedName() {
		return choosedName;
	}
}
