package gxa.dao;

import gxa.page.PageInfo;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * 
 * ʵ�ֻ���DAO�ӿڵ�DAO������,���е�DAO��Ҫ�̳и���
 * @author vikings
 * @version 1.0
 */

public class BaseDaoImp extends HibernateDaoSupport {
	/**
	 * ��ҳ��ѯ
	 * @param session
	 * @param sqlString
	 * @param pageInfo
	 * @return list
	 */
	public List getPage(String sqlString, final PageInfo pageInfo) {
		Session session = getSession();
		Query query ;
		if(pageInfo.getMaxResults().equals("0")){
			query = session.createQuery(sqlString);
		}else{
			if (pageInfo != null) {		
				query = session.createQuery("select count(*) " + sqlString);//��ѯ�ܼ�¼��sql
				Number count = (Number) query.uniqueResult();
				pageInfo.setItemCount(String.valueOf(count.intValue()));//�����ܼ�¼��
			}	
			query = session.createQuery(sqlString);
			if (pageInfo != null) {
				int firstResult=Integer.parseInt(pageInfo.getFirstResult());
				int maxResults=Integer.parseInt(pageInfo.getMaxResults());
				query.setFirstResult(firstResult);//�ڼ�����¼��ʼ
				if (maxResults != -1) {			
					query.setMaxResults(maxResults);//ÿҳ����¼��
				}
			}
		}
		return query.list();
	}
}
