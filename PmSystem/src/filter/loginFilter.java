package filter;

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
		System.out.println(context);
	
		System.out.println(request.getSession().getAttribute("name"));
		HttpSession session=request.getSession();
		String str=(String) session.getAttribute("name");
		System.out.println(str);
		String option=request.getParameter("option");
		if(option!=null&&option.equals("login")||checkUrl(url)||str!=null){
			chain.doFilter(request, response);
		}else{
			((HttpServletResponse) resp).sendRedirect("login.html");
		}
	}
   public boolean checkUrl(String url){
	   //�����д�ŵ��ǲ���Ҫ����ֱ�ӷ��е�url
	   //һ���ύ��url�ܹ����������ҵ���˵��ֱ�ӷ���
	   String urls[] ={
			   "login",
			   "/js",
			   "/css",	
			   "/style",
			   "img",
			   "font",
			   "htm",
			  "/index"
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
