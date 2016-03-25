package com.mpqi.homewrokday07.cfg;

/**
 * �û�����
 * 
 * @author mpqi
 *
 */
public class User {

	private String username;// �û���
	private String name;// �ǳ�
	private String pwd;// ����
	private String word;// ǩ��
	private int head;// ͷ��

	public static String USERNAME = "username";
	public static String NAME = "name";
	public static String PWD = "password";
	public static String HEAD = "head";
	
	public User(String username, String name, String pwd, String word, int head) {
		super();
		this.username = username;
		this.pwd = pwd;
		this.word = word;
		this.head = head;
		this.name = name;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public int getHead() {
		return head;
	}

	public void setHead(int head) {
		this.head = head;
	}

}
