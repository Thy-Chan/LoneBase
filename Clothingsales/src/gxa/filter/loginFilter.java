package gxa.filter;

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

public class loginFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		//filter�Ĺ��˷������������Ϊ/*�����е�url����ִ��֮ǰ��ִ�����filter���˷���
		//�����鵽session��������ݣ������
		String url = request.getRequestURL().toString();
		String context = request.getContextPath();
		System.out.println(url);
		
		String option = request.getParameter("option");
	
		//System.out.println(request.getSession().getAttribute("name"));
		HttpSession session=request.getSession();
		String str=(String) session.getAttribute("name");
		if(option!=null&&option.equals("login")||checkUrl(url)||str!=null){
			chain.doFilter(request, response);
		}else{
			response.sendRedirect("login.html");
		}
	}
   public boolean checkUrl(String url){
	   //�����д�ŵ��ǲ���Ҫ����ֱ�ӷ��е�url
	   //һ���ύ��url�ܹ����������ҵ���˵��ֱ�ӷ���
	   String urls[] ={
			   "login",
			   "/js",
			   "/css",
			   "images",
			   "font",
			   "resources",
			   "topindex.html",
			   "rindex.html",
			   "Lindex.html"
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
		// TODO Auto-generated method stub

	}

}
