package gxa.service;

import gxa.dao.EntityDao;
import gxa.db.Integral;
import gxa.db.Suppliers;
import gxa.util.ProcessSql;
import gxa.web.page.PageInfo;

import java.util.List;

public class Supplierservice implements SuppliersforCloting {
	EntityDao dao;
   
	public Supplierservice() {
		super();
		dao = new EntityDao();
	}
	public List getAllsupplier(PageInfo pageinfo){
		//.class��ʾ����
		return dao.getAll("select * from suppliers", "select count(*) from suppliers",new Suppliers(),pageinfo);
	}
	public Suppliers getSupplierById(String id){
		return (Suppliers)dao.getOBJById("select * from suppliers where s_id = " + id, new Suppliers());
	} 

	public List getAllsupplier(){
		//.class��ʾ����
		return dao.getAll("select * from suppliers", null,new Suppliers(),null);
	}
	public String deleteById(String id){
		String sql="delete from suppliers where s_id ="+id;
		String msg;
		int rs=dao.dml(sql);
		if(rs>=0){
			msg="ɾ���ɹ�����ɾ��"+rs+"����¼";
			
		}else{
			msg="ɾ��ʧ��!";
		}
		return msg;
	}
	//�������
		public String add(Suppliers supplier){
		    String msg = "";
			int rs = dao.dml(ProcessSql.processInsert(supplier));
			System.out.println(ProcessSql.processInsert(supplier));
			
			if(rs>=0){
				msg="��ӳɹ����������"+rs+"����¼";
			}else{
				msg="���ʧ��";	
			}
			return msg;
		}
}
