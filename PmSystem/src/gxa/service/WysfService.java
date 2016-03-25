package gxa.service;

import gxa.dao.EntityDao;
import gxa.db.Wysf;
import gxa.db.Yz;
import gxa.util.ProcessSql;
import gxa.web.page.PageInfo;

import java.util.List;

public class WysfService {
	EntityDao dao;
	WysfforYz wysfforyz;
	public WysfService() {
		super();
		wysfforyz = new YzService();
		dao = new EntityDao();
	}
	public List getAllYz(PageInfo pageinfo){
		//.class��ʾ����
		return dao.getAll("select * from [wysf]","select count(*) from [wysf]",new Wysf(),pageinfo);
	}
	public Wysf getWysfById(String id){
		return (Wysf)dao.getOBJById("select * from [wysf] where sh_id = " + id, new Wysf());
	}
	public String getNewById(){
		String oldId= ((Wysf)dao.getOBJById("select top 1 sh_id from wysf order by sh_id desc", new Wysf())).getSh_id();
	   return ProcessSql.processPk(oldId);
	} 
	//����ɾ��
	public String deleteById(String id){
		String sql = "delete from wysf where sh_id = " +id;
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
	public String add(Wysf wysf){
	    String msg = "";
		int rs = dao.dml(ProcessSql.processInsert(wysf));
		if(rs>0){
			msg="��ӳɹ����������"+rs+"����¼";
		}else{
			msg="���ʧ��";	
		}
		return msg;
	}
	public String update(Wysf wysf){
		 String msg = "";
			int rs = dao.dml(ProcessSql.processUpdate(wysf));
			if(rs>0){
				msg="�޸ĳɹ������޸ļ���"+rs+"����¼";
			}else{
				msg="�޸�ʧ��";	
			}
			return msg;
	}
	public List getwysf(){		
		return wysfforyz.getAllYz();		
	}

}