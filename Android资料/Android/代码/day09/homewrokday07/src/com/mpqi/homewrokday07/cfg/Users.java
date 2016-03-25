package com.mpqi.homewrokday07.cfg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mpqi.homewrokday07.R;

public class Users {
	private static HashMap<String, User> users;

	public static HashMap<String, User> getUsers() {
		if (users == null) {
			initUsers();
		}
		return users;
	}

	/**
	 * ��ʼ���û�����
	 */
	private static void initUsers() {
		users = new HashMap<String, User>();

		User user = new User("ylc", "Ҷ����", "yeliangchen",
				"��Ҷ������һ���ַ�ʽ��������������л첻��ȥ�����㣬�޿��κ�", R.drawable.bierde_75);
		users.put(user.getUsername(), user);
	}

	/**
	 * ��¼
	 * 
	 * @param username
	 *            �û���
	 * @param pwd
	 *            ����
	 * @return ���û�����Ӧ������Դ�е��û����� �����ʱ�� Ϊtrue ���¼�ɹ� ���� false ʧ��
	 */
	public static boolean login(String username, String pwd) {
		boolean flag = false;

		User user = getUsers().get(username);
		flag = user.getPwd().equals(pwd);
		return flag;
	}

	/**
	 * �����û�
	 * 
	 * @param user
	 * @return
	 */
	public static void addUser(User user) {
		getUsers().put(user.getUsername(), user);
	}

	/**
	 * ����û����Ƿ��Ѿ�����
	 * 
	 * @param username
	 * @return true ���� false ������
	 */
	public static boolean isUser(String username) {
		return getUsers().get(username) != null;
	}

	/**
	 * ��ȡ����ע���û��ļ���
	 * 
	 * @return �û����϶��� ����BaseAdapter
	 */
	public static List<User> getAllUsers() {
		return new ArrayList<User>(users.values());
	}

	/**
	 * ��ȡ����ע���û��ļ���
	 * 
	 * @return �û�Map���϶��� ����SimpleApater
	 */
	public static List<Map<String, Object>> getAllUsersMaps() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for (User user : users.values()) {
			Map map = new HashMap<String, Object>();
			map.put(User.USERNAME, user.getUsername());
			map.put(User.NAME, user.getName());
			map.put(User.PWD, user.getPwd());
			map.put(User.HEAD, user.getHead());
			list.add(map);
		}

		return list;
	}
	
	/**
	 * ͨ���û��� ��ȡ�û�
	 * @param username
	 * @return �û�����
	 */
	public static User getUserByUserName(String username){
		return getUsers().get(username);
	}
}
