package gxa.service;

import gxa.dao.EntityDao;
import gxa.db.Gzry;
import gxa.db.Wgxx;
import gxa.util.ProcessSql;
import gxa.web.page.PageInfo;

import java.util.List;

public class GzryService {
	EntityDao dao;
	GzryforWgxx gzryforwgxx;
	public GzryService() {
		super();
		dao = new EntityDao();
		gzryforwgxx = new WgxxService();
	}
	public List getAllGzry(PageInfo pageinfo){
		//.class��ʾ����
		return dao.getAll("select * from [gzry]","select count(*) from [gzry]",new Gzry(),pageinfo);
	}
	public Gzry getGzryById(String id){
		return (Gzry)dao.getOBJById("select * from [gzry] where gz_bianhao = " + id, new Gzry());
	}
	public String getNewById(){
		String oldId= ((Gzry)dao.getOBJById("select top 1 gz_bianhao from gzry order by gz_bianhao desc", new Gzry())).getGz_bianhao();
	   return ProcessSql.processPk(oldId);
	} 
	//����ɾ��
	public String deleteById(String id){
		String sql = "delete from gzry where gz_bianhao = " +id;
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
	public String add(Gzry gzry){
	    String msg = "";
		int rs = dao.dml(ProcessSql.processInsert(gzry));
		if(rs>0){
			msg="��ӳɹ����������"+rs+"����¼";
		}else{
			msg="���ʧ��";	
		}
		return msg;
	}
	public String update(Gzry gzry){
		 String msg = "";
			int rs = dao.dml(ProcessSql.processUpdate(gzry));
			if(rs>0){
				msg="�޸ĳɹ������޸ļ���"+rs+"����¼";
			}else{
				msg="�޸�ʧ��";	
			}
			return msg;
	}
	public List getwgxx(){		
		return gzryforwgxx.getAllWgxx();		
	}
}