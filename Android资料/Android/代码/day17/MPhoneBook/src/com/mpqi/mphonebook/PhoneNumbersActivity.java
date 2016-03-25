package com.mpqi.mphonebook;

import java.util.ArrayList;
import java.util.List;

import com.mpqi.mphonebook.adapter.Contact;
import com.mpqi.mphonebook.adapter.ContactAdapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Contacts;
import android.provider.ContactsContract.PhoneLookup;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AlphabetIndexer;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * ��ϵ��
 * 
 * @author mpqi
 *
 */
@SuppressLint("InflateParams")
public class PhoneNumbersActivity extends Activity {
	private Button phoneNumbersBtn;
	private ListView contactListView;
	private Cursor cursor;
	private LayoutInflater inflater;
	/**
	 * ����Ĳ���
	 */
	private LinearLayout titleLayout;

	/**
	 * ����ʽ����Ĳ���
	 */
	private RelativeLayout sectionToastLayout;
	/**
	 * �洢�����ֻ��е���ϵ��
	 */
	private List<Contact> contacts;

	/**
	 * ��������ʾ����ĸ
	 */
	private TextView title;

	/**
	 * ����ʽ�����ϵ�����
	 */
	private TextView sectionToastText;
	/**
	 * �ϴε�һ���ɼ�Ԫ�أ����ڹ���ʱ��¼��ʶ��
	 */
	private int lastFirstVisibleItem = -1;
	/**
	 * ���ڽ�����ĸ�����
	 */
	private AlphabetIndexer indexer;
	/**
	 * ������ĸ����������
	 */
	private String alphabet = "#ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	private ContactAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.phonenumbers_layout);
		initView();
	}

	/**
	 * ��ʼ���ؼ�
	 */
	private void initView() {
		phoneNumbersBtn = (Button) findViewById(R.id.gophonenumbers);
		phoneNumbersBtn.setBackgroundColor(getResources().getColor(
				R.color.lightblue));
		contactListView = (ListView) findViewById(R.id.contact_listview);
		titleLayout = (LinearLayout) findViewById(R.id.contact_title_layout);
		title = (TextView) findViewById(R.id.contact_title);
		sectionToastLayout = (RelativeLayout) findViewById(R.id.section_toast_layout);

		inflater = LayoutInflater.from(this);
		showAllContact();
	}

	/**
	 * �ײ��˵�������¼�
	 * 
	 * @param view
	 */
	public void footbarOnclick(View view) {
		Intent intent = null;
		switch (view.getId()) {
		case R.id.gocall:
			intent = new Intent(this, CallActivity.class);
			startActivity(intent);
			finish();
			break;
		case R.id.gocalllog:
			intent = new Intent(this, CallLogActivity.class);
			startActivity(intent);
			finish();
			break;
		case R.id.gotelephonedir:
			intent = new Intent(this, TelephoneDirAcitivty.class);
			startActivity(intent);
			finish();
			break;
		}

	}

	/**
	 * ��ť����¼�
	 */
	public void onclick(View view) {
		Intent intent = new Intent(this, addUserActivity.class);
		startActivity(intent);
	}

	/**
	 * ��ʾ��ϵ���б�
	 */
	private void showAllContact() {
		contacts = new ArrayList<Contact>();

		ContentResolver resolver = getContentResolver();
		String[] projection = new String[] {
				ContactsContract.Contacts.DISPLAY_NAME,
				ContactsContract.Contacts.SORT_KEY_PRIMARY };
		cursor = resolver.query(ContactsContract.Contacts.CONTENT_URI,
				projection, null, null,
				ContactsContract.Contacts.SORT_KEY_ALTERNATIVE);
		while (cursor.moveToNext()) {
			Contact contact = new Contact();
			contact.setName(cursor.getString(0));
			contact.setSortKey(getSortKey(cursor.getString(1)));
			contacts.add(contact);
		}
		adapter = new ContactAdapter(this, R.layout.phonenumbers_item, contacts);
		contactListView.setAdapter(adapter);
		indexer = new AlphabetIndexer(cursor, 1, alphabet);
		adapter.setIndexer(indexer);
		if (contacts.size() > 0) {
			setupContactsListView();
		}
	}

	/**
	 * Ϊ��ϵ��ListView���ü����¼������ݵ�ǰ�Ļ���״̬���ı�������ʾλ�ã��Ӷ�ʵ�ּ�ѹ������Ч����
	 */
	private void setupContactsListView() {
		contactListView.setOnScrollListener(new OnScrollListener() {

			@Override
			public void onScrollStateChanged(AbsListView view, int scrollState) {
			}

			@Override
			public void onScroll(AbsListView view, int firstVisibleItem,
					int visibleItemCount, int totalItemCount) {

				int section = indexer.getSectionForPosition(firstVisibleItem);
				int nextSecPosition = indexer
						.getPositionForSection(section + 1);
				if (firstVisibleItem != lastFirstVisibleItem) {
					MarginLayoutParams params = (MarginLayoutParams) titleLayout
							.getLayoutParams();
					params.topMargin = 0;
					titleLayout.setLayoutParams(params);
					title.setText(String.valueOf(alphabet.charAt(section)));
				}
				if (nextSecPosition == firstVisibleItem + 1) {
					View childView = view.getChildAt(0);
					if (childView != null) {
						int titleHeight = titleLayout.getHeight();
						int bottom = childView.getBottom();
						MarginLayoutParams params = (MarginLayoutParams) titleLayout
								.getLayoutParams();
						if (bottom < titleHeight) {
							float pushedDistance = bottom - titleHeight;
							params.topMargin = (int) pushedDistance;
							titleLayout.setLayoutParams(params);
						} else {
							if (params.topMargin != 0) {
								params.topMargin = 0;
								titleLayout.setLayoutParams(params);
							}
						}
					}
				}
				lastFirstVisibleItem = firstVisibleItem;

			}
		});
	}

	/**
	 * ��ȡsort key���׸��ַ��������Ӣ����ĸ��ֱ�ӷ��أ����򷵻�#��
	 * 
	 * @param sortKeyString
	 *            ���ݿ��ж�ȡ����sort key
	 * @return Ӣ����ĸ����#
	 */
	private String getSortKey(String sortKeyString) {
		String key = sortKeyString.substring(0, 1).toUpperCase();
		if (key.matches("[A-Z]")) {
			return key;
		}
		return "#";
	}
}
