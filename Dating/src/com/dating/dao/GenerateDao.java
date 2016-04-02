package com.dating.dao;

import java.util.List;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;

import com.dating.entity.User;

public interface GenerateDao<T> {
//	���ݴ���Ĳ�ͬ��T�����ж�Ӧ�ı����ɾ�Ĳ�
	public void save(T entity);
	public void update(T entity);
	public void delete(T entity);
	public T findById(Object id);
	public List<T> findAll();	
}
