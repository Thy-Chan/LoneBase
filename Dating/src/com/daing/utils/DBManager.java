package com.daing.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
	public static Connection getConn() {
		Connection conn = null;
		try {
			// 1��������������
			Class.forName("com.mysql.jdbc.Driver");
			// 2�����ӵ����ݿ⣨������Ӷ���
			// ͨ�����ӹ�����(DriverManager)���һ��������������Ӷ�������Ĳ�����ʾ�������ӵ�����Դbookdemo
			conn = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/Dating?"
							+ "useUnicode=true&characterEncoding=utf8", "root", "root");
		} catch (ClassNotFoundException e) {
			// �Զ�ջ�ķ�ʽ��������Ϣ��ӡ����
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn; // �����Ӷ��󷵻�
	}

	public static void closeConn(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
}
