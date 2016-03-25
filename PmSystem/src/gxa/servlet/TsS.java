package gxa.servlet;

/*
 * ҵ��servlet ���ڼ���ҵ����Ϣ
 * ������
 * */
import gxa.db.Ts;
import gxa.db.Zy;
import gxa.service.TsService;
import gxa.web.page.PageInfo;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.net.httpserver.HttpContext;
import com.sun.org.apache.commons.beanutils.BeanUtils;

public class TsS extends HttpServlet {

	TsService tsService;
	PageInfo pageinfo;

	public TsS() {
		super();
		pageinfo = new PageInfo();
		tsService = new TsService();
	}

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		// ��ȡ��ҳ��ǩ�ύ�������Ϣ,����ÿҳ��¼������ǰҳ�Ŀ�ʼ���
		String firstResult = request.getParameter("offset");
		String maxResults = request.getParameter("pageSize");
		String option = request.getParameter("option");
		// ����õĿ�ʼ��ű���
		if (firstResult != null) {
			pageinfo.setFirstResult(firstResult);
		}
		if (maxResults != null) {
			pageinfo.setMaxResults(maxResults);
		} else {
			pageinfo.setMaxResults(PageInfo.DEFAULT_PAGE_SIZE);
		}
		if (option.equals("getByPage")) {
			List tss = tsService.getAllTs(pageinfo);
			request.setAttribute("pageinfo", pageinfo);
			request.setAttribute("tss", tss);
			
			
			
			request.getRequestDispatcher("ts/show.jsp").forward(request,
					response);
		} else if (option.equals("deleteById")) {
			String id = request.getParameter("id");
			String msg = tsService.deleteById(id);
			request.setAttribute("msg", msg);
			request.setAttribute("url", "TsS?option=getByPage");
			request.getRequestDispatcher("msg.jsp").forward(request, response);

		} else if (option.equals("add")) {
			Integer fid=0;
			 fid= tsService.getNewById();
	           request.setAttribute("fid",fid );
			request.getRequestDispatcher("ts/add.jsp").forward(request,
					response);

		} else if (option.equals("processAdd")) {
			Map map = new HashMap(request.getParameterMap());// ��ȡ���ύ��ȫ������
			Ts ts = new Ts();
			try {
				BeanUtils.populate(ts, map);
				String msg = tsService.add(ts);
				request.setAttribute("msg", msg);
				request.setAttribute("url", "index/liuyan.html");
				request.getRequestDispatcher("msg.jsp").forward(request,
						response);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		else if(option.equals("UpdateById")){
		    String id=request.getParameter("id");
		    Ts ts=tsService.getTsById(id);
		    if(ts==null){
		    	request.setAttribute("msg", "���ݲ�������");
				request.setAttribute("url","TsS?option=getByPage" );
				 request.getRequestDispatcher("msg.jsp").forward(request,response);
				 
		    }else{
		    request.setAttribute("ts",ts); 
		    request.getRequestDispatcher("ts/update.jsp").forward(request,response);
		    }
		    }
    else if(option.equals("processUpdate")){
    	Map map = new  HashMap(request.getParameterMap());
    	
    	Ts ts = new Ts();
		try {
			BeanUtils.populate(ts, map);
			String msg = tsService.update(ts);
			request.setAttribute("msg", msg);
			request.setAttribute("url","TsS?option=getByPage" );
			request.getRequestDispatcher("msg.jsp").forward(request, response);
		
		}catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        }
		out.flush();
		out.close();
	}

	public void init() throws ServletException {

	}

}
