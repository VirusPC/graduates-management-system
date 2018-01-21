package action;

import java.io.File;

import org.apache.commons.io.FileUtils;

import entity.StudentPC;

public class FileUploadAction extends SuperAction {	
	private File upload;
	private String uploadContentType;
	private String uploadFileName;
	private String maximumSize;
	public String getMaximumSize() {
		return maximumSize;
	}
	public void setMaximumSize(String maximumSize) {
		this.maximumSize = maximumSize;
	}
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	
	public String execute() throws Exception{
		String result;
		request.setAttribute("period", request.getParameter("period"));
		if(upload==null){
			session.setAttribute("result", "上传失败");
			return SUCCESS;
		}
		String userPath = (String)request.getAttribute("userPath");
		if(userPath==null){
			session.setAttribute("result", "上传失败");
			return SUCCESS;
		}
		String path = application.getRealPath("/resource"+userPath);
		File file = new File(path);
		if(!file.exists()){
			file.mkdir();
		}
		FileUtils.copyFile(upload, new File(file, uploadFileName));
		session.setAttribute("result", "上传成功");
		return SUCCESS;
	}
}
