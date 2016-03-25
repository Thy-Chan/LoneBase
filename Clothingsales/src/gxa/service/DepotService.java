package gxa.service;

import gxa.dao.EntityDao;
import gxa.db.Customer;
import gxa.db.Depot;
import gxa.util.ProcessSql;
import gxa.web.page.PageInfo;

import java.util.List;
public class DepotService implements DepotforEmployee {
	static EntityDao dao;

	public DepotService() {
		super();
		dao = new EntityDao();
	}
	public List getAllDepot(PageInfo pageinfo){
		//.class��ʾ����
		return dao.getAll("select * from depot", "select count(*) from depot ",new Depot(),pageinfo);
	}
	public Depot getDepotById(String id){
		return (Depot)dao.getOBJById("select * from depot where d_id = " + id, new Depot());
	} 

	public List getAllDepot(){
		//.class��ʾ����
		return dao.getAll("select * from depot", null,new Depot(),null);
	}

	
	public static String deleteById(String id){
		String sql = "delete from depot where d_id = " + id;
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
	public String add(Depot depot){
	    String msg = "";
		int rs = dao.dml(ProcessSql.processInsert(depot));
		if(rs>=0){
			msg="��ӳɹ����������"+rs+"����¼";
		}else{
			msg="���ʧ��";	
		}
		return msg;
	}
	public String update(Depot depot){
		 String msg = "";
			int rs = dao.dml(ProcessSql.processUpdate(depot));
			if(rs>0){
				msg="�޸ĳɹ������޸ļ���"+rs+"����¼";
			}else{
				msg="�޸�ʧ��";	
			}
			return msg;
	}
}

