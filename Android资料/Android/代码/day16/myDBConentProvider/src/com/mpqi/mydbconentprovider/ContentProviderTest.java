package com.mpqi.mydbconentprovider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;

/**
 * ע������: ��AndroidManifest.xml��ע��ContentProviderʱ������
 * android:exported="true"��ʾ��������Ӧ�÷���. ���� mineXXX���Ӧ�òſ��Է��ʸô���ContentProvider
 */
public class ContentProviderTest extends ContentProvider {
	private DBOpenHelper dbOpenHelper;// ���ݿ�����Ĺ�����
	private UriMatcher URI_MATCHER;
	private static final int PERSONS = 0;
	private static final int PERSON = 1;

	@Override
	public boolean onCreate() {
		initinitUriMatcher();// ��ʼ��URI
		dbOpenHelper = new DBOpenHelper(getContext());
		return true;
	}

	private void initinitUriMatcher() {
		URI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);
		// ��ʾ�������е�person,����PERSONSΪ���ض�Uri�ı�ʶ��
		URI_MATCHER.addURI("cn.mpqi.testcontentprovider", "person", PERSONS);
		// ��ʾ����ĳһ��person,����PERSONΪ���ض�Uri�ı�ʶ��
		URI_MATCHER.addURI("cn.mpqi.testcontentprovider", "person/#", PERSON);
	}

	@Override
	public Cursor query(Uri uri, String[] columns, String whereClause,
			String[] whereArgs, String sortOrder) {
		SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
		Cursor cursor = null;
		switch (URI_MATCHER.match(uri)) {
		// ��ѯ��
		case PERSONS:
			cursor = db.query("person", columns, whereClause, whereArgs, null,
					null, sortOrder);
			break;
		// ����id��ѯĳ������
		case PERSON:
			long id = ContentUris.parseId(uri);
			String where = "_id=" + id;
			if (whereClause != null && whereClause.trim().length() != 0) {
				where += " and " + whereClause;
			}
			cursor = db.query("person", columns, where, whereArgs, null, null,
					sortOrder);

			break;
		default:
			throw new IllegalArgumentException("unknown uri" + uri.toString());
		}
		return cursor;
	}

	/**
	 * ���ص�ǰUri����������ݵ�MIME����. 
	 * �����Uri��Ӧ�����ݿ��ܰ���������¼,��ô����
	 * �ַ���Ӧ����"vnd.android.cursor.dir/"��ͷ 
	 * �����Uri��Ӧ������ֻ����һ����¼,��ô����
	 * �ַ���Ӧ����"vnd.android.cursor.item/"��ͷ
	 */
	@Override
	public String getType(Uri uri) {
		switch (URI_MATCHER.match(uri)) {
		case PERSONS:
			return "vnd.android.cursor.dir/persons";

		case PERSON:
			return "vnd.android.cursor.item/person";
		default:
			throw new IllegalArgumentException("unknown uri" + uri.toString());
		}
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
		switch (URI_MATCHER.match(uri)) {
		case PERSONS:
			long rowid = db.insert("person", "name,phone,salary", values);
			return ContentUris.withAppendedId(uri, rowid);
		default:
			throw new IllegalArgumentException("unkonw uri :" + uri.toString());
		}
	}

	/**
	 * ɾ������: ɾ�����������ֿ���:ɾ��һ�ű����ɾ��ĳ������ ��ɾ��ĳ������ʱԭ�������ڲ�ѯĳ������,����.
	 */
	@Override
	public int delete(Uri uri, String whereClause, String[] whereArgs) {
		SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
		int deletNum = 0;
		switch (URI_MATCHER.match(uri)) {
		// ɾ����
		case PERSONS:
			deletNum = db.delete("person", whereClause, whereArgs);
			break;
		// ����idɾ��ĳ������
		case PERSON:
			long id = ContentUris.parseId(uri);
			String where = "_id=" + id;
			if (whereClause != null && whereClause.trim().length() != 0) {
				where += " and " + whereClause;
			}
			deletNum = db.delete("person", where, whereArgs);
			break;
		default:
			throw new IllegalArgumentException("unknown uri" + uri.toString());
		}
		return deletNum;
	}

	/**
	 * where name like ? and type = ? String[]{"С%","2"} ���²���:
	 * ���²��������ֿ���:����һ�ű���߸���ĳ������ �ڸ���ĳ������ʱԭ�������ڲ�ѯĳ������,����.
	 */
	@Override
	public int update(Uri uri, ContentValues values, String whereClause,
			String[] whereArgs) {
		SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
		int updateNume = 0;
		switch (URI_MATCHER.match(uri)) {
		// ���±�
		case PERSONS:
			updateNume = db.update("person", values, whereClause, whereArgs);
			break;
		// ����id����ĳ������
		case PERSON:
			Log.i("contentprovider", uri.toString());
			long id = ContentUris.parseId(uri);
			String where = "_id=" + id;
			if (whereClause != null && whereClause.trim().length() != 0) {
				where += " and " + whereClause;
			}
			updateNume = db.update("person", values, where, whereArgs);
			break;
		default:
			throw new IllegalArgumentException("unknown uri" + uri.toString());
		}
		return updateNume;
	}

}
