package com.dating.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dating.entity.User;


public class LoginFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		//filter�Ĺ��˷������������Ϊ/*�����е�url����ִ��֮ǰ��ִ�����filter���˷���
		//�����鵽session��������ݣ������
		String url = request.getRequestURL().toString();
		String context = request.getContextPath();
	
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");
		if(checkUrl(url)||user!=null){
			chain.doFilter(request, response);
		}else{
			((HttpServletResponse) resp).sendRedirect(context+"/login.html");
		}
	}
   public boolean checkUrl(String url){
	   //�����д�ŵ��ǲ���Ҫ����ֱ�ӷ��е�url
	   //һ���ύ��url�ܹ����������ҵ���˵��ֱ�ӷ���
	   String urls[] ={
			   "index.jsp",
			   "login.html",
			   "reg.html",
			   "/images",
			   "My97DatePicker",
			   "upload",
			   "LoginServlet",
			   "/js",
	   };
	   for(int i=0;i<urls.length;i++){
		   int index = url.indexOf((urls[i]));
		   if( index >= 0){
			   return true;
		   }
	   }
	   return false;
   }
	
	public void init(FilterConfig arg0) throws ServletException {
		

	}
	/*
	 * 
	 * 
	 * */
	
	

}
