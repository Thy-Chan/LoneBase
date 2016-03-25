package gxa.service;

import gxa.dao.EntityDao;
import gxa.db.Employee;
import gxa.db.Integral;
import gxa.util.ProcessSql;
import gxa.web.page.PageInfo;

import java.util.List;
public class IntegralService {
	static EntityDao dao;

	public IntegralService() {
		super();
		dao = new EntityDao();
	}
	public static List getAllIntegral(PageInfo pageinfo){
		//.class��ʾ����
		return dao.getAll("select * from Integral", "select count(*) from Integral ",new Integral(),pageinfo);
	}

	public Integral getIntegralById(String id){
		return (Integral)dao.getOBJById("select * from Integral where i_id = " + id, new Integral());
	} 


	public static String deleteById(String id){
		String sql = "delete from Integral where i_id = " + id;
		String msg;
		int rs = dao.dml(sql);
		if(rs >= 0){
			msg = "ɾ���ɹ�����ɾ����"+rs+"����¼";
		}else{
			msg = "ɾ��ʧ��";
		}
		return  msg;
	}
	//�������
		public String add(Integral integral){
		    String msg = "";
			int rs = dao.dml(ProcessSql.processInsert(integral));
			if(rs>=0){
				msg="��ӳɹ����������"+rs+"����¼";
			}else{
				msg="���ʧ��";	
			}
			return msg;
		}
		public String update(Integral integral){
			 String msg = "";
				int rs = dao.dml(ProcessSql.processUpdate(integral));
				if(rs>0){
					msg="�޸ĳɹ������޸ļ���"+rs+"����¼";
				}else{
					msg="�޸�ʧ��";	
				}
				return msg;
		}
}
