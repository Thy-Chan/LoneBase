package com.mpqi.homewrokday07.cfg;

import java.util.HashMap;
import java.util.List;

import com.mpqi.homewrokday07.R;

public class Users {
	private static HashMap users;

	public static HashMap getUsers() {
		if (users == null) {
			initUsers();
		}
		return users;
	}

	/**
	 * ��ʼ���û�����
	 */
	private static void initUsers() {
		users = new HashMap();

		User user = new User("ylc","Ҷ����", "yeliangchen",
				"��Ҷ������һ���ַ�ʽ��������������л첻��ȥ�����㣬�޿��κ�", R.drawable.bierde_75);
		users.put(user.getUsername(), user);
	}
	
	public boolean getUsersData(User user){
		
		return false;
	}
	
	public User addUser(){
		
		return null;
	}
}
