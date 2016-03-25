package gxa.servlet;

import java.awt.Font;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
//��servlet����ɻ�ͼ���ܣ�ͼ����Ҫ�����ݣ�����Ӧ��ҵ��ģ��servlet�ṩ
public class ChartS extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ChartS() {
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
		PrintWriter out = response.getWriter();
		
	    String url = (String)request.getAttribute("url");//��ȡԭ��ת·��
		String type= (String)request.getAttribute("type");
		//��״ͼ
		//dcdΪ��״ͼ�����ݼ�
		String chartname = (String)request.getAttribute("chartname");
		String itemname = (String)request.getAttribute("itemname");
		String itemval = (String)request.getAttribute("itemval");
		String imgname =(String)request.getAttribute("imgname");
		JFreeChart chart=null;
		if(type.equals("bar")){
			
		
		DefaultCategoryDataset dcd = (DefaultCategoryDataset)request.getAttribute("dcd");
ChartFactory.createBarChart3D(chartname, itemname, itemval, dcd, PlotOrientation.VERTICAL, true, true, true);
		 chart = ChartFactory.createBarChart3D(chartname, itemname, itemval,
				dcd, PlotOrientation.VERTICAL, true, true, true);
		//CategoryPlot categoryplot = chart.getCategoryPlot();		 //��� plot��CategoryPlot����
		chart.getTitle().setFont(new Font("����", 0, 12));
		CategoryPlot categoryplot = (CategoryPlot) chart.getPlot();   
		NumberAxis numberaxis = (NumberAxis) categoryplot.getRangeAxis();     
		CategoryAxis domainAxis = categoryplot.getDomainAxis();     
		TextTitle textTitle = chart.getTitle();   


		textTitle.setFont(new Font("����", Font.PLAIN, 20));      

		domainAxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 11));     

		domainAxis.setLabelFont(new Font("����", Font.PLAIN, 12));     

		numberaxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 12));     

		numberaxis.setLabelFont(new Font("����", Font.PLAIN, 12));     

		chart.getLegend().setItemFont(new Font("����", Font.PLAIN, 12));  

		BarRenderer3D   renderer   =   new   BarRenderer3D();     

		//����ÿ��������������ƽ������֮�����     
		renderer.setItemMargin(0.1);     
		//��ʾÿ��������ֵ�����޸ĸ���ֵ����������     
		//renderer.setItemLabelGenerator(new   StandardCategoryItemLabelGenerator());     
		//renderer.setItemLabelsVisible(true);   

		categoryplot.setRenderer(renderer);
		}else if(type.equals("pie")){
//                //��ͼ�����ݼ�
				DefaultPieDataset dpd = (DefaultPieDataset)
					request.getAttribute("dpd");
//					new DefaultPieDataset();
//				    dpd.setValue("1��", 10);
//				    dpd.setValue("2��", 3);
//				    dpd.setValue("3��", 4);
//				    dpd.setValue("4��", 3);
					
					//(DefaultPieDataset)ServletActionContext.getRequest().getSession().getAttribute("dpd");
		
		
		
				// ʹ�ù����ഴ����ͼ
				 chart = ChartFactory.createPieChart3D(
						 chartname,
						dpd, 
						true,
						true,
						false);
				
						PiePlot pieplot = (PiePlot)chart.getPlot();
						pieplot.setLabelFont(new Font("SansSerif", 0, 12));
						chart.getTitle().setFont(new Font("SansSerif", 0, 12));
						chart.getLegend().setItemFont(new Font("SansSerif", 0, 12));


		}
	    String realPath = request.getRealPath("/upload");
	    imgname = imgname+".png";
		OutputStream os = new FileOutputStream(realPath+"\\"+imgname);
		ChartUtilities.writeChartAsPNG(os, chart, 600, 460);
		request.setAttribute("imgname", imgname);
		os.close();
		
		
		request.getRequestDispatcher("showchart.jsp").forward(request, response);
		
		
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
