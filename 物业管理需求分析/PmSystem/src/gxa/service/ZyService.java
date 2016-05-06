package gxa.service;

import gxa.dao.EntityDao;
import gxa.db.Wgxx;
import gxa.db.Zy;
import gxa.util.ProcessSql;
import gxa.web.page.PageInfo;

import java.util.List;

public class ZyService  implements  WgxxforZy {
	EntityDao dao;
	public ZyService() {
		super();
		dao = new EntityDao();
	}
	public List getAllZy(PageInfo pageinfo){
		//.class��ʾ����
		return dao.getAll("select * from [zy]","select count(*) from [zy]",new Zy(),pageinfo);
	}
	public Zy getZyById(String id){
		return (Zy)dao.getOBJById("select * from [zy] where zy_id = " + id, new Zy());
	} 
	public String getNewById(){
		String oldId= ((Zy)dao.getOBJById("select top 1 zy_id from zy order by zy_id desc", new Zy())).getZy_id();
	   return ProcessSql.processPk(oldId);
	} 
	//���
	public List getAllZy() {
		// TODO Auto-generated method stub
		return dao.getAll("select * from zy", null,new Zy(),null);
	}
	public String deleteById(String id){
		String sql = "delete from zy where zy_id = " +id;
		String msg;
		int rs = dao.dml(sql);
		if(rs>0){
			msg="ɾ���ɹ�����ɾ����"+rs+"����¼";
		}else{
			msg="ɾ��ʧ��";	
		}
		return msg;
	}
	//�������
	public String add(Zy zy){
	    String msg = "";
		int rs = dao.dml(ProcessSql.processInsert(zy));
		if(rs>0){
			msg="��ӳɹ����������"+rs+"����¼";
		}else{
			msg="���ʧ��";	
		}
		return msg;
	}
	public String update(Zy zy){
		 String msg = "";
			int rs = dao.dml(ProcessSql.processUpdate(zy));
			if(rs>0){
				msg="�޸ĳɹ������޸�"+rs+"����¼";
			}else{
				msg="�޸�ʧ��";	
			}
			return msg;
	}

}
