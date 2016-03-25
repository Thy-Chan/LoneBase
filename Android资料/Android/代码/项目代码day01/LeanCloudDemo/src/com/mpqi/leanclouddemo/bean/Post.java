package com.mpqi.leanclouddemo.bean;

import android.os.Parcel;

import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVObject;

@AVClassName("Post")
// ע�⣬���� AvObject("Post")
public class Post extends AVObject {
	private final String pubUser = "pubUser";
	private final String content = "content";
	private final String pubUserCertificate = "pubUserCertificate";

	public Post() {
		super();
	}

	public Post(Parcel in) {
		super(in);
	}

	// �˴�Ϊ���ǵ�Ĭ��ʵ�֣���Ȼ��Ҳ��������ʵ��
	public static final Creator CREATOR = AVObjectCreator.instance;

	public String getPubUser() {
		return getString(pubUser);
	}

	public void setPubUser(String pubUser) {
		put(this.pubUser, pubUser);
	}

	public String getContent() {
		return getString(content);
	}

	public void setContent(String content) {
		put(this.content, content);
	}

	public int getPubUserCertificate() {
		return getInt(pubUserCertificate);
	}

	public void setPubUserCertificate(int pubUserCertificate) {
		put(this.pubUserCertificate, pubUserCertificate);
	}

}
