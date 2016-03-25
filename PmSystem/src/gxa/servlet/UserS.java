package gxa.servlet;
import gxa.dao.Conn;
import gxa.db.Users;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;


public class UserS extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	Conn conn = new Conn();
	public UserS() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	  doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();		
		String option = request.getParameter("option");
		if(option.equals("checkname")){
			checkname(out, request);
		}else if(option.equals("login")){
			login(out, request);
		}else if(option.equals("saveUser")){
		     request.getRequestDispatcher("index.jsp").forward(request,response);
		}else if(option.equals("freesession")){
			request.getSession().invalidate();
			response.sendRedirect("login.html");
		}		
		out.flush();
		out.close();
	}

	public void checkname(PrintWriter out,HttpServletRequest request){
		String name = request.getParameter("name");
		//System.out.println(name);
		Users user = (Users)conn.
		getOBJById("select * from [users] where name = '"+name+"'",
				new Users());
		if(user!=null){
		 out.println(1);
		}else{
			out.println(0);
		}
	}
	public void login(PrintWriter out,HttpServletRequest request){
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		
		Users user = (Users)conn.
		getOBJById("select * from [users] where name = '"+name+"'",
				new Users());
		if(user!=null){
			if(pwd.equals(user.getPwd())){
				out.println(0);//��½�ɹ�

			      HttpSession session=request.getSession();
			     session.setAttribute("name","admin");
			}else{
				out.println(-2);//�������
			}
		}else{
			out.println(-1);//��ʾ�û���������
		}
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
