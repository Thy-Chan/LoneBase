package gxa.service;

import gxa.dao.EntityDao;
import gxa.db.Cloting;
import gxa.util.ProcessSql;
import gxa.web.page.PageInfo;

import java.util.List;

public class ClotingService {
	EntityDao dao;
	SuppliersforCloting suppliersforCloting;
	

	
	public ClotingService() {
		super();
		suppliersforCloting=new Supplierservice();
		dao = new EntityDao();
	
	}
	public List getAllCloting(PageInfo pageinfo){
		//.class��ʾ����
		return dao.getAll("select * from cloting", "select count(*) from cloting",new Cloting(),pageinfo);
	}
	public Cloting getClotingById(String id){
		return (Cloting)dao.getOBJById("select * from Cloting where f_id = " + id, new Cloting());
	} 
	public String getNewById(){
		String oldId= ((Cloting)dao.getOBJById("select top 1 f_id from cloting order by f_id desc", new Cloting())).getF_id();
	   return ProcessSql.processPk(oldId);
	} 
	//ɾ��
	public String deleteById(String id){
		String sql="delete from cloting where f_id="+id;
		String msg;
		int rs=dao.dml(sql);
		if(rs>=0){
			msg="ɾ���ɹ�����ɾ��"+rs+"����¼";
			
		}else{
			msg="ɾ��ʧ��!";
		}
		return msg;
	}
	
	//���
	
	public String add(Cloting cloting){
	    String msg = "";
		int rs = dao.dml(ProcessSql.processInsert(cloting));
		if(rs>=0){
			msg="��ӳɹ����������"+rs+"����¼";
		}else{
			msg="���ʧ��";	
		}
		return msg;
	}
	public String update(Cloting cloting){
		 String msg = "";
			int rs = dao.dml(ProcessSql.processUpdate(cloting));
			if(rs>0){
				msg="�޸ĳɹ������޸ļ���"+rs+"����¼";
			}else{
				msg="�޸�ʧ��";	
			}
			return msg;
	}
	public List getsuppliers(){
		
		return suppliersforCloting.getAllsupplier();
		
	}
}


