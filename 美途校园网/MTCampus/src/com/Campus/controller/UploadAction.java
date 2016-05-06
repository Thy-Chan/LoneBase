package com.Campus.controller;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport {
	// username����������װ�û���
	
	// myFile����������װ�����ϴ����ļ�
	private List<File> myFile;
	
	// myFileContentType����������װ�����ϴ��ļ�������
	private List<String> myFileContentType;
	
	// myFileFileName����������װ�����ϴ��ļ����ļ���
	private List<String> myFileFileName;

	private String savePath;
	
	private List<String> fileNames = new ArrayList<String>();
	
	
	public List<String> getFileNames() {
		return fileNames;
	}

	public void setFileNames(List<String> fileNames) {
		this.fileNames = fileNames;
	}

	//����ϴ��ļ�����Ŀ¼
	public String getSavePath() {
		return savePath;
	}
	
	//�����ϴ��ļ�����Ŀ¼
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	
	//���myFileֵ
	public List<File> getMyFile() {
		return myFile;
	}

	//����myFileֵ
	public void setMyFile(List<File> myFile) {
		this.myFile = myFile;
	}

	//���myFileContentTypeֵ
	public List<String> getMyFileContentType() {
		return myFileContentType;
	}

	//����myFileContentTypeֵ
	public void setMyFileContentType(List<String> myFileContentType) {
		this.myFileContentType = myFileContentType;
	}

	//���myFileFileNameֵ
	public List<String> getMyFileFileName() {
		return myFileFileName;
	}

	//����myFileFileNameֵ
	public void setMyFileFileName(List<String> myFileFileName) {
		this.myFileFileName = myFileFileName;
	}

	public String exec() throws Exception {
		System.out.println("ttt");
		//ȡ�������ϴ����ļ�����
		try {
			List<File> files = getMyFile();
			//ѭ��ÿ���ϴ����ļ�
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");//�������ڸ�ʽ
			//System.out.println(df.format(new Date()));// 
			for (int i = 0; i < files.size(); i++) {
				
				//����file[i]����һ���ļ�������
				InputStream is = new FileInputStream(files.get(i));
				
				// �����ϴ��ļ�Ŀ¼
				String uploadPath = ServletActionContext.getServletContext()
						.getRealPath(getSavePath());
				
				
				
				// ����Ŀ���ļ�
				String oldFileName = getMyFileFileName().get(i);
				String newFileName = df.format(new Date())+oldFileName.substring(oldFileName.lastIndexOf("."));
				//System.out.println(newFileName);
				getMyFileFileName().set(i,newFileName);
				File toFile = new File(uploadPath,newFileName);
				
				fileNames.add(newFileName);
				ServletActionContext.getRequest().setAttribute("fileNames", fileNames);
				
				// �����
				OutputStream os = new FileOutputStream(toFile);

				//���û���
				byte[] buffer = new byte[1024];

				int length = 0;

				//��ȡfile[i]�ļ������toFile�ļ���
				while ((length = is.read(buffer)) > 0) {
					os.write(buffer, 0, length);
				}
				
				//�ر�������
				is.close();
				
				//�ر������
				os.close();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.addActionError("�ļ��ϴ�ʧ��");
			return this.ERROR;
		}
		//���һ��strutst��ʾ��Ϣ
		this.addActionMessage("�ϴ��ɹ�");
		String url = (String) ActionContext.getContext().getValueStack().findValue("url");
		//ServletActionContext.getRequest().setAttribute("myFileFileName", myFileFileName);
		//JSONArray filenames = JSONArray.fromObject(myFileFileName);
        
        
		ServletActionContext.getResponse().getWriter().print(myFileFileName.get(0));
		//ServletActionContext.getResponse().getWriter().flush();
		//ServletActionContext.getResponse().getWriter().close();
		return this.NONE;
	}
}
