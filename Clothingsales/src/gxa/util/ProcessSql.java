package gxa.util;

import java.lang.reflect.Field;

import sun.reflect.LangReflectAccess;

import com.sun.org.apache.bcel.internal.classfile.JavaClass;

public class ProcessSql {
	public static String processInsert(Object obj) {
		String sql = "insert into";

		// ͨ��������ȡ����
		String tablename = obj.getClass().getName().substring(7);
		sql = sql + " [" + tablename + "](";
		// ͨ�������ֵ�ͳ�Ա��������ȡ���ֶ������ֶ�ֵ
		Field[] fds = obj.getClass().getDeclaredFields();
		String fdlist = "";
		String vallist = "";
		for (int i = 0; i < fds.length; i++) {
			Field fd = fds[i];// ͨ�������ֶζ������飬��һ��ȡ�ֶ�
			// System.out.println(fd.getName());
			try {
				fd.setAccessible(true);// Ĭ��Ϊprivate���ֶΣ�����Ϊ�������
				Object fdval = fd.get(obj);// ��ȡ�ֶε�ֵ
				if (fdval == null || fdval.equals("")) {// �������ѭ��Ϊ��ֵ�����ֶβ�����
					continue;
				}
				fdlist = ProcessSql.processComma(fdlist,
						String.valueOf(fd.getName()), i);
				// ����ֶ�����
				String typename = fd.getType().getName();// ����ֶε���������
				System.out.println(fd.getName() + "  " + typename);
				if (typename.equals("java.lang.Integer")
						|| typename.equals("java.lang.Float")
						|| typename.equals("java.lang.Double")) {
					vallist = ProcessSql.processComma(vallist,
							String.valueOf(fd.get(obj)), i);
				} else {
					vallist = ProcessSql.processComma(vallist,
							String.valueOf("'" + fd.get(obj) + "'"), i);
				}
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		sql = sql + fdlist + ") values(" + vallist + ")";
		// System.out.println(sql);
		return sql;
	}

	public static String processUpdate(Object obj) {
		String sql = "update";

		// ͨ��������ȡ����
		String tablename = obj.getClass().getName().substring(7);
		sql = sql + " [" + tablename + "]";
		// ͨ�������ֵ�ͳ�Ա��������ȡ���ֶ������ֶ�ֵ
		Field[] fds = obj.getClass().getDeclaredFields();
		fds[0].setAccessible(true);
		String wherestr = "";
		try {
			wherestr = " where " + fds[0].getName() + " = " + fds[0].get(obj);
		} catch (IllegalArgumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String updatelist = " set ";
		for (int i = 1; i < fds.length; i++) {
			Field fd = fds[i];// ͨ�������ֶζ������飬��һ��ȡ�ֶ�
			// System.out.println(fd.getName());
			try {
				fd.setAccessible(true);// Ĭ��Ϊprivate���ֶΣ�����Ϊ�������
				Object fdval = fd.get(obj);// ��ȡ�ֶε�ֵ
				// if(fdval==null||fdval.equals("")){//�������ѭ��Ϊ��ֵ�����ֶβ�����
				// continue;
				// }
				// ����ֶ�����
				String typename = fd.getType().getName();// ����ֶε���������
				// System.out.println(fd.getName()+"  "+typename);
				if (typename.equals("java.lang.Integer")
						|| typename.equals("java.lang.Float")
						|| typename.equals("java.lang.Double")) {
					updatelist = ProcessSql.processComma(updatelist,
							fd.getName(), String.valueOf(fd.get(obj)), i);
				} else {
					updatelist = ProcessSql.processComma(updatelist,
							fd.getName(),
							String.valueOf("'" + fd.get(obj) + "'"), i);
				}
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		sql = sql + updatelist + wherestr;
		System.out.println(sql);
		return sql;
	}

	public static String processComma(String strlist, String name, String val,
			int i) {
		if (i == 1) {
			strlist += name + "=" + val;
		} else {
			strlist += "," + name + "=" + val;
		}
		return strlist;
	}

	public static String processComma(String strlist, String str, int i) {
		if (i == 0) {
			strlist += str;
		} else {
			strlist += "," + str;
		}
		return strlist;
	}

	public static String processPk(String oldPk) {
		String str = "";
		for (int i = 0; i < oldPk.length(); i++) {
			char c = oldPk.charAt(i);
			if (c != '0') {
				str = oldPk.substring(i);

				break; // �˳�ѭ��
			}

		}
		
		int a=Integer.parseInt(str)+1;
	     
		 str=String.valueOf(a);
	     int len=oldPk.length()-str.length();
		for(int i=0;i<len;i++){
			str="0"+str;
			
		}
		
		
    return str;
    
	}
	
	public static void main(String[] args) {
		
		System.out.println(processPk("0010101020"));
	}
}
