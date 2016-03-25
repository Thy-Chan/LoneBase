package com.mpqi.testactionbardemo;

import com.mpqi.testactionbardemo.fragement.Fragment1;
import com.mpqi.testactionbardemo.fragement.Fragment2;
import com.mpqi.testactionbardemo.fragement.Fragment3;

import android.app.ActionBar;
import android.app.ActionBar.OnNavigationListener;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.SearchView;
import android.widget.ShareActionProvider;
import android.widget.SpinnerAdapter;

public class MainActivity extends Activity {
	SpinnerAdapter mSpinnerAdapter;
	String[] strings;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mSpinnerAdapter = ArrayAdapter.createFromResource(this,
				R.array.action_list,
				android.R.layout.simple_spinner_dropdown_item);
		strings = new String[] { "fragment1", "fragment2", "fragment3" };
	}

	public void myOnclick(View view) {
		switch (view.getId()) {
		case R.id.actionbar_xialadaohang:
			ActionBar actionBar = getActionBar();
			actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);// ����ģʽ������ΪNAVIGATION_MODE_LIST
			actionBar.setListNavigationCallbacks(mSpinnerAdapter,
					mOnNavigationListener);
			break;
		case R.id.actionbar_caozuoshitu:

			break;
		case R.id.actionbar_daohangxuanxiang:
			Intent intent = new Intent(this,TabActionActivity.class);
			startActivity(intent);
			break;
		}

	}

	/**
	 * ���������Fragment��ʵ�ֲ�ͬ��ҳ�浼��
	 */
	OnNavigationListener mOnNavigationListener = new OnNavigationListener() {

		@Override
		public boolean onNavigationItemSelected(int position, long itemId) {
			Fragment newFragment = null;
			switch (position) {
			case 0:
				newFragment = new Fragment1();
				break;
			case 1:
				newFragment = new Fragment2();
				break;
			case 2:
				newFragment = new Fragment3();
				break;
			default:
				break;
			}
			getFragmentManager().beginTransaction()
					.replace(R.id.container, newFragment, strings[position])
					.commit();
			return true;
		}
	};

	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.options, menu);

		// �����Ӵ�����ΪshowAsAction="ifRoom"������ͼ���г�����������ť
		SearchView searchView = (SearchView) menu.findItem(R.id.menu_search)
				.getActionView();

		// �����Ӵ�����ΪshowAsAction="never"������ֻ��������˵��вſ�����
		ShareActionProvider mShareActionProvider = (ShareActionProvider) menu
				.findItem(R.id.menu_share).getActionProvider();
		Intent shareIntent = new Intent(Intent.ACTION_SEND);
		shareIntent.setType("image/*");
		mShareActionProvider.setShareIntent(shareIntent);

		// �����Ӵ���MyActionProvider���������Զ����ActionProvider
//		MyActionProvider myactionprovider = (MyActionProvider) menu.findItem(
//				R.id.menu_setting).getActionProvider();
		return super.onCreateOptionsMenu(menu);
	};
//	
//	@Override
//	public boolean onOptionsItemSelected(MenuItem item) {
//		switch (item.getItemId()) 
//		   {        
//		      case android.R.id.home:            
//		         Intent intent = new Intent(this, MainActivity.class);            
//		         intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
//		         startActivity(intent);            
//		         return true;        
//		      default:            
//		         return super.onOptionsItemSelected(item);    
//		   }
//	}
}
