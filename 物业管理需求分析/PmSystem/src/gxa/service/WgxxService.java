package gxa.service;

import gxa.dao.EntityDao;
import gxa.db.Wgxx;
import gxa.util.ProcessSql;
import gxa.web.page.PageInfo;

import java.util.List;

public class WgxxService implements YzforWgxx, GzryforWgxx  {
	EntityDao dao;
	WgxxforZy wgxxforzy;

	public WgxxService() {
		super();
		dao = new EntityDao();
		wgxxforzy = new ZyService();
	}
	public List getAllWgxx(PageInfo pageinfo){
		//.class��ʾ����
		return dao.getAll("select * from [wgxx]","select count(*) from [wgxx]",new Wgxx(),pageinfo);
	}
	public Wgxx getWgxxById(String id){
		return (Wgxx)dao.getOBJById("select * from [wgxx] where w_id = " + id, new Wgxx());
	} 
	public String getNewById(){
		String oldId= ((Wgxx)dao.getOBJById("select top 1 w_id from wgxx order by w_id desc", new Wgxx())).getW_id();
	   return ProcessSql.processPk(oldId);
	} 
	
	//����ɾ��
	public String deleteById(String id){
		String sql = "delete from wgxx where w_id = " +id;
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
	public String add(Wgxx wgxx){
	    String msg = "";
		int rs = dao.dml(ProcessSql.processInsert(wgxx));
		if(rs>0){
			msg="��ӳɹ����������"+rs+"����¼";
		}else{
			msg="���ʧ��";	
		}
		return msg;
	}
	
	public String update(Wgxx wgxx){
		 String msg = "";
			int rs = dao.dml(ProcessSql.processUpdate(wgxx));
			if(rs>0){
				msg="�޸ĳɹ������޸ļ���"+rs+"����¼";
			}else{
				msg="�޸�ʧ��";	
			}
			return msg;
	}
	
	
	public List getAllWgxx() {
		// TODO Auto-generated method stub
		return dao.getAll("select * from wgxx", null,new Wgxx(),null);
	}
	
	public List getzy(){		
		return wgxxforzy.getAllZy();		
	}

}
