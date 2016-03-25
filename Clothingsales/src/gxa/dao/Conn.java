package gxa.dao;


import gxa.web.page.PageInfo;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Conn {
 
	private final String DriverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private final String URL = "jdbc:sqlserver://localhost:1433;databaseName=Clothingsales";
	private final String UNAME = "sa";
	private final String UPWD = "123";
	
	private Connection connection;
	private PreparedStatement prep;
	//���췽������ʼ�����ݿ����ӣ�ִֻ��һ��
	public Conn() {
	   try {
		Class.forName(DriverName);//1.��������
		connection = DriverManager.getConnection(URL,UNAME,UPWD);//2.��������
	   } catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
	}
	//��ѯ����,����1Ϊ�����SQL��䣬����2Ϊ���صĶ��󼯺��У����������,(Ϊ�������)
    public List getAll(String sql,String sql2,Object objExample,PageInfo pageinfo){
       if(sql2!=null){
    	int count =  getRecordsCount(sql2);//������ܼ�¼��
        pageinfo.setItemCount(String.valueOf(count));//���ܼ�¼�����浽pageinfo����
       }
    	List list = new ArrayList();//�յĶ��󼯺�
    	try {
			Statement st = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//3.��дSQL���
			//����ȡ��������¼
			ResultSet rs=null;
			if(pageinfo!=null){
			st.setMaxRows(Integer.parseInt(pageinfo.getFirstResult())+
					Integer.parseInt(pageinfo.getMaxResults()));
			 rs = st.executeQuery(sql);//4.ִ��SQL
			//System.out.println(pageinfo.getFirstResult());
			
			rs.absolute(Integer.parseInt(pageinfo.getFirstResult()));
			}else{
				 rs = st.executeQuery(sql);
			}
			
            //rs.setFetchSize(Integer.parseInt(pageinfo.getMaxResults()));
            //����ͨ�����ת��Ϊ��̬��������
			ResultSetDynaClass rsds = new ResultSetDynaClass(rs);

			//תΪ��ʽ�����
			Iterator rows = rsds.iterator();
			
			while(rows.hasNext()){
				//�������ʹ���һ���������µĶ���
				Object obj = objExample.getClass().newInstance();
				//����̬���ݽ������һ�У�ת��Ϊһ����̬����
				DynaBean row = (DynaBean)rows.next();
				//����̬���������ȫ����Ӧ�Ĵ���ָ������
				BeanUtils.copyProperties(obj, row); 
				list.add(obj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    	return list;
    }
    //���ĳ�ű���ܼ�¼��
    public int getRecordsCount(String sql){
    	 int count = 0;
    	try {
			prep = connection.prepareStatement(sql);
			ResultSet rs = prep.executeQuery();
			if(rs.next()){
			 count = rs.getInt(1);//���ڸ�ͳ�Ƽ�¼���Ĳ�ѯֻ�᷵��һ������
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return count;
    }
    
    //��ѯ����
    public Object getOBJById(String sql,Object objExample){
    
        
        	try {
    			Statement st = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//3.��дSQL���
    			//����ȡ��������¼
    			ResultSet rs=null;
    			
    			 rs = st.executeQuery(sql);//4.ִ��SQL
    			
    				 rs = st.executeQuery(sql);
    			ResultSetDynaClass rsds = new ResultSetDynaClass(rs);

    			//תΪ��ʽ�����
    			Iterator rows = rsds.iterator();
    			
    			while(rows.hasNext()){
    				//�������ʹ���һ���������µĶ���
    				Object obj = objExample.getClass().newInstance();
    				//����̬���ݽ������һ�У�ת��Ϊһ����̬����
    				DynaBean row = (DynaBean)rows.next();
    				//����̬���������ȫ����Ӧ�Ĵ���ָ������
    				BeanUtils.copyProperties(obj, row); 
    		        return obj;
    			}
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} catch (InstantiationException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} catch (IllegalAccessException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} catch (InvocationTargetException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} 
        	return null;
    	
    }
    public int excuteDML(String sql){
    	int rs=0;
    	try {
			prep = connection.prepareStatement(sql);
			rs=prep.executeUpdate();
		   
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//3.��дSQL���
 
    	return rs;
    }


	
}
