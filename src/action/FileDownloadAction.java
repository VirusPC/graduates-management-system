package action;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import entity.StudentPC;

public class FileDownloadAction extends SuperAction {
	public String inputPath;
	public String filename;
	
	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getInputPath() {
		return inputPath;
	}

	public void setInputPath(String inputPath) {
		this.inputPath = inputPath;
	}
	
	public String execute() throws Exception{
		return SUCCESS;
	}
	
	public InputStream getInputStream() throws IOException{
		String result;
		
		String userPath = (String)request.getAttribute("userPath");
		if(userPath==null){
			session.setAttribute("result", "œ¬‘ÿ ß∞‹");
			return null;
		}
		
		String filepath = application.getRealPath(inputPath)+userPath+"/"+filename;
		System.out.println(filepath);
		File file = new File(filepath);
		System.out.println(file);
		return FileUtils.openInputStream(file);
		//return ServletActionContext.getServletContext().getResourceAsStream(inputPath);
	}
	
	public String getDownloadFileName() throws UnsupportedEncodingException{
		String downloadFileName="";
		downloadFileName=URLEncoder.encode(filename,"utf-8");
		return downloadFileName;
	}
}
