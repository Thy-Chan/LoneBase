package com.mpqi.myjiujiujintu;

import java.util.ArrayList;

import com.mpqi.myjiujiujintu.fragment.MainIndexFragment;
import com.mpqi.myjiujiujintu.fragment.MainMoreFragment;
import com.mpqi.myjiujiujintu.fragment.MainPicFragment;
import com.mpqi.myjiujiujintu.fragment.MainTypeFragment;
import com.mpqi.myjiujiujintu.fragment.MainUserFragment;
import com.mpqi.myjiujiujintu.widget.MaskImage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * ������
 * 
 * @author mpqi
 *
 */
public class MainActivity extends FragmentActivity {
	private ViewPager lviewPager;
	private ArrayList<Fragment> lfragments;
	private int lcurmainMaskImageId = R.id.mainbar1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
		initViewPager();
	}

	private void initView() {
		lviewPager = (ViewPager) findViewById(R.id.mainviewPager);
	}

	private void initViewPager() {
		lfragments = new ArrayList<Fragment>();

		MainIndexFragment fragment1 = new MainIndexFragment();
		MainTypeFragment fragment2 = new MainTypeFragment();
		MainUserFragment fragment4 = new MainUserFragment();
		MainPicFragment fragment3 = new MainPicFragment();
		MainMoreFragment fragment5 = new MainMoreFragment();

		lfragments.add(fragment1);
		lfragments.add(fragment2);
		lfragments.add(fragment3);
		lfragments.add(fragment4);
		lfragments.add(fragment5);

		lviewPager.setAdapter(new FragmentPagerAdapter(
				getSupportFragmentManager()) {

			@Override
			public int getCount() {
				return lfragments.size();
			}

			@Override
			public Fragment getItem(int arg0) {
				return lfragments.get(arg0);
			}
		});

		lviewPager.setCurrentItem(0);
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

		switch (id) {
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

		// �ѵ�ǰ�ĵ�����ť�����ɫ����
		maskImage = (MaskImage) findViewById(lcurmainMaskImageId);
		maskImage.setmImageSource(R.drawable.mainbarbackground_green);
		maskImage.refresh();
		
		maskImage = null;
	}
}
