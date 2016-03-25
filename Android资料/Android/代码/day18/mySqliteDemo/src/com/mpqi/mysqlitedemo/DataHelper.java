package com.mpqi.mysqlitedemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DataHelper extends SQLiteOpenHelper {

	private final static String dbname = "datahelper.db";// ���ݿ������
	private static int dbversion = 6;// ���ݿ�İ汾��

	/**
	 * 
	 * @param context
	 *            �Ự
	 * @param name
	 *            ���ݿ������
	 * @param factory
	 *            �α�Ĺ���
	 * @param version
	 *            �汾��
	 */
	public DataHelper(Context context) {
		super(context, dbname, null, dbversion);

	}

	@Override
	// ���ݿ��ʼ�� ������ݿ��Ѿ����ڣ���ô�˷�����ִ��
	public void onCreate(SQLiteDatabase db) {
		String createStr = "create table answer (_id integer primary key autoincrement ,timu_title text ,timu1  varchar(64), daan1   varchar(64));";
		db.execSQL(createStr);
	}

	@Override
	// ���ݿ����
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		String createStr = "create table user (_id integer primary key autoincrement ,username text ,pwd  varchar(64), age   varchar(64));";
		db.execSQL(createStr);
	}

}
