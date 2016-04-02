package com.daing.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;




import com.dating.dao.impl.UserDaoImpl;
import com.dating.entity.User;
import com.dating.servlet.UserServlet;
import com.jspsmart.upload.SmartUpload;
public class UploadUtil
{



	SmartUpload smartUpload = new SmartUpload();

	private String uploadPath;
	private Map uploadFiles;
	private String Msg;

	/**
	 * ��ʼ������
	 * 
	 * @param pageContext
	 * @return
	 */
	public boolean initParam(PageContext pageContext,HttpServletRequest request)
	{
		
		String fileSizeStr = "";
		String allowedFileTypeStr = "";
		
		try 
		{
			String path = request.getSession().getServletContext().getRealPath("/")+ "upload";
			System.out.println(path);
			//String path = "C:\\Program Files (x86)\\Apache Software Foundation\\Tomcat 6.0\\webapps\\swfupload\\upload";
			smartUpload.initialize(pageContext);
			this.uploadPath = path;
			fileSizeStr = "1024";
			allowedFileTypeStr = "jpg,gif,png,bmp,tif";
			int fileSizeLimit = Integer.parseInt(fileSizeStr);
			smartUpload.setMaxFileSize(fileSizeLimit*1024);
			smartUpload.setAllowedFilesList(allowedFileTypeStr);
			smartUpload.upload();
		} 
		catch(SecurityException e)
		{
			if(e.getMessage().contains("1010"))
			{
				this.setMsg("�ϴ��ļ�ʧ�ܣ������ϴ��ļ������ͣ�"+ allowedFileTypeStr + "��������Ϣ��" + e.getMessage());

			}
			else if(e.getMessage().contains("1105"))
			{
				this.setMsg("�ϴ��ļ�ʧ�ܣ��ļ���С���ܳ���"+ fileSizeStr +"M" + "��������Ϣ��" + e.getMessage());
			}
			else
			{
				this.setMsg(e.getMessage());
			}
			
			return false;
		}
		catch (Exception e)
		{
			this.setMsg("��ʼ���ϴ��������ʧ�ܣ�" + e.getMessage());
			e.printStackTrace();
			return false;

		}
		return true;
	}

	/**
	 * �ϴ��ļ����ϴ��ɹ������·�����ļ�������map��
	 * 
	 * @param type
	 *            �ϴ��ļ��ĵ����ͣ��û�ͷ��,��ҵlogo,ͼƬ
	 * @return true�� �ɹ���false��ʧ��
	 */
	public boolean uploadFile(String type)
	{

		Map uploadFiles = new HashMap();
		try
		{
			for (int i = 0; i < smartUpload.getFiles().getCount(); i++)
			{
				com.jspsmart.upload.File file = smartUpload.getFiles().getFile(i);
				String orderPath="";
				if(file.getFilePathName()!=null){
					if (file.getFilePathName().trim().equals(""))
					{
						continue;
					}
				}
				String dbPath ="";
				if(!"".equals(type))//�������ͣ�������������ΪĿ¼���д���
				{
					dbPath= File.separator + type + File.separator + this.getCurrentYear() + File.separator + this.getCurrentMonth() + File.separator;
					
				}else//û�д������ͣ���ȡ��ʱ�ļ�·��
				{
					dbPath=File.separator + "tmp"+ File.separator ;
				}
				orderPath = uploadPath + dbPath;
				File orderDir = new File(orderPath);
				if (!orderDir.exists())
				{
					if (!orderDir.mkdirs())
					{
						this.setMsg("�����ļ���[" + orderPath + "]ʧ��...");
						return false;
					}
				}
				String iRandom = Math.round(Math.random() * 900000) + 100000 + "";//�����
				String newFileName = iRandom + "." + file.getFileExt();
				file.saveAs(orderPath + newFileName);
				System.out.println(newFileName);
//				UserDaoImpl.updateHead(newFileName);
				uploadFiles.put(dbPath + newFileName, file.getFileName());
			}
			this.setUploadFiles(uploadFiles);

		} catch (Exception e)
		{
			this.setMsg("�ϴ�ʧ��:" + e.getMessage());
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public String getParameter(String str)
	{
		return smartUpload.getRequest().getParameter(str);

	}

	public Map getUploadFiles()
	{
		return uploadFiles;
	}

	private void setUploadFiles(Map uploadFiles)
	{
		this.uploadFiles = uploadFiles;
	}

	public String getCurrentYear()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		return sdf.format(new Date());
	}

	public String getCurrentMonth()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("MM");
		return sdf.format(new Date());

	}

	public String getMsg() {
		return Msg;
	}

	public void setMsg(String msg) {
		Msg = msg;
	}

}
