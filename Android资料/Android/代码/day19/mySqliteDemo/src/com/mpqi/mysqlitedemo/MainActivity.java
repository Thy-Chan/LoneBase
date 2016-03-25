package com.mpqi.mysqlitedemo;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {
	private DataHelper helper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		helper = new DataHelper(this);
		// insert();
		// insertEXECSQL();
		// update();
		// delete();
		// query();
		rawquery();
	}

	private void insert() {
		// SQLiteDatabase db = helper.getWritableDatabase();//��ȡ�ɶ�д���ݿ�
		// ContentValues values = new ContentValues();
		// values.put("timu_title",
		// "1	 __dull he may be, he is certainly a very successful top executive.	Although	whatever 	As	However 				D	however�������ò�״��Ӿ�,��˼������(��ô��),�Ӿ���Ҫ��װ,��However+adj/adv+��+ν. However dull he may be=Dull as he may be. although��as�����ò�״��Ӿ�,ָ�����ܡ�, whatever�����������ʴӾ�,��˼��: ����ʲô. ����: ��������ô�����˸е���ζ.������һλ�ǳ��ɹ��Ķ���������Ա.	��ѡ	0");
		// values.put("timu1","Although");
		// values.put("daan1","A");
		// db.insert("answer", null, values);

		SQLiteDatabase db = helper.getWritableDatabase();//
		ContentValues values = new ContentValues();
		values.put("username", "С��");
		db.insert("user", "username", values);
		db.close();
	}

	private void insertEXECSQL() {
		SQLiteDatabase db = helper.getWritableDatabase();//
		ContentValues values = new ContentValues();
		String insert1 = "insert into user(username , age) values ('С��',13)";
		db.execSQL(insert1);

		String insert2 = "insert into user values (null,'С��','abccc',13)";// _id
																			// null
		db.execSQL(insert2);
		db.close();
	}

	private void update() {
		SQLiteDatabase db = helper.getWritableDatabase();//
		ContentValues values = new ContentValues();
		values.put("username", "С��");
		db.update("user", values, "_id = ?", new String[] { "3" });

		String update = "update user set username = 'С��'  where _id = ?";
		db.execSQL(update, new String[] { "2" });
		db.close();
	}

	private void delete() {
		SQLiteDatabase db = helper.getWritableDatabase();//
		db.delete("user", "_id = ?", new String[] { "-1" });
		db.close();
	}

	private void query() {
		SQLiteDatabase db = helper.getWritableDatabase();
		// select * from user
		Cursor cursor1 = db.query("user", null, null, null, null, null, null);
		String msg = null;
		String name = null;
		String pwd = null;
		String _id = null;
		String age = null;
		while (cursor1.moveToNext()) {
			name = cursor1.getString(cursor1.getColumnIndex("username"));
			pwd = cursor1.getString(cursor1.getColumnIndex("pwd"));
			_id = cursor1.getInt(cursor1.getColumnIndex("_id")) + "";
			age = cursor1.getInt(cursor1.getColumnIndex("age")) + "";
			msg = "_id : " + _id + " name : " + name + " pwd : " + pwd
					+ " age : " + age;
			Log.i("sqlite_demo", msg);

		}

		Log.i("sqlite_demo", "������ѯ");
		Cursor cursor2 = db.query("user", new String[] { "username , _id " },
				"pwd = ?", new String[] { "abccc" }, null, null, null);
		while (cursor2.moveToNext()) {
			name = cursor2.getString(cursor2.getColumnIndex("username"));
			_id = cursor2.getInt(cursor2.getColumnIndex("_id")) + "";
			msg = "_id : " + _id + " name : " + name;
			Log.i("sqlite_demo", msg);

		}
		db.close();
	}

	private void rawquery() {
		SQLiteDatabase db = helper.getWritableDatabase();
		Cursor cursor = db.rawQuery("select * from user where username = ?",
				new String[] { "С��" });
		String msg = null;
		String name = null;
		String pwd = null;
		String _id = null;
		String age = null;
		while (cursor.moveToNext()) {
			name = cursor.getString(cursor.getColumnIndex("username"));
			pwd = cursor.getString(cursor.getColumnIndex("pwd"));
			_id = cursor.getInt(cursor.getColumnIndex("_id")) + "";
			age = cursor.getInt(cursor.getColumnIndex("age")) + "";
			msg = "_id : " + _id + " name : " + name + " pwd : " + pwd
					+ " age : " + age;
			Log.i("sqlite_demo", msg);

		}
		db.close();
	}
}
