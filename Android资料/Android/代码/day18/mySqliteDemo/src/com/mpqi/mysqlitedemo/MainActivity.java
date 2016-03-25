package com.mpqi.mysqlitedemo;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {
	private DataHelper helper ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		helper = new DataHelper(this);
//		insert();
//		insertEXECSQL();
//		update();
		delete();
	}
	
	private void insert(){
//		SQLiteDatabase db = helper.getWritableDatabase();//��ȡ�ɶ�д���ݿ�
//		ContentValues values = new ContentValues();
//		values.put("timu_title", "1	 __dull he may be, he is certainly a very successful top executive.	Although	whatever 	As	However 				D	however�������ò�״��Ӿ�,��˼������(��ô��),�Ӿ���Ҫ��װ,��However+adj/adv+��+ν. However dull he may be=Dull as he may be. although��as�����ò�״��Ӿ�,ָ�����ܡ�, whatever�����������ʴӾ�,��˼��: ����ʲô. ����: ��������ô�����˸е���ζ.������һλ�ǳ��ɹ��Ķ���������Ա.	��ѡ	0");
//		values.put("timu1","Although");
//		values.put("daan1","A");
//		db.insert("answer", null, values);
		
		SQLiteDatabase db = helper.getWritableDatabase();//
		ContentValues values = new ContentValues();
		values.put("username", "С��");
		db.insert("user", "username", values);
		db.close();
	}
	
	private void insertEXECSQL(){
		SQLiteDatabase db = helper.getWritableDatabase();//
		ContentValues values = new ContentValues();
		String insert1 = "insert into user(username , age) values ('С��',13)";
		db.execSQL(insert1);
		
		String insert2 = "insert into user values (null,'С��','abccc',13)";//_id  null
		db.execSQL(insert2);
		db.close();
	}
	
	
  private void update(){
	  SQLiteDatabase db = helper.getWritableDatabase();//
		ContentValues values = new ContentValues();
		values.put("username", "С��");
		db.update("user", values, "_id = ?", new String []{"3"});
		
		String update = "update user set username = 'С��'  where _id = ?";
		db.execSQL(update, new String []{"2"});
		db.close();
  }
  
  private void delete(){
	  SQLiteDatabase db = helper.getWritableDatabase();//
	  db.delete("user", "_id = ?", new String[]{"-1"});
  }
}
