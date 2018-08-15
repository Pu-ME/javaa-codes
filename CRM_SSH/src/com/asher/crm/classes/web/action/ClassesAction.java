package com.asher.crm.classes.web.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.asher.crm.classes.domain.CrmClasses;
import com.asher.crm.classes.service.ClassesService;
import com.asher.crm.coursetype.domain.CrmCourseType;
import com.asher.crm.coursetype.service.CourseTypeService;
import com.asher.crm.utils.MyStringUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

public class ClassesAction extends ActionSupport implements ModelDriven<CrmClasses>{
	private CrmClasses classes = new CrmClasses();
	public CrmClasses getModel() {
		return classes;
	}
	
	private ClassesService classesService;
	public void setClassesService(ClassesService classesService) {
		this.classesService = classesService;
	}
	private CourseTypeService courseTypeService;
	public void setCourseTypeService(CourseTypeService courseTypeService) {
		this.courseTypeService = courseTypeService;
	}
	
	public String findAll(){
		List<CrmClasses> allClasses = this.classesService.findAll();
		ActionContext.getContext().put("allClasses", allClasses);
		return "findAll";
	}
	
	public String uploadUI(){
		CrmClasses findClasses = this.classesService.findById(classes.getClassId());
		ActionContext.getContext().getValueStack().push(findClasses);
		return "uploadUI";
	}
	//上传
	private File schedule;//上传的内容
	private String scheduleFileName; //上传的文件名
	private String scheduleContentType;
	public void setSchedule(File schedule) {
		this.schedule = schedule;
	}
	public void setScheduleFileName(String scheduleFileName) {
		this.scheduleFileName = scheduleFileName;
	}
	public void setScheduleContentType(String scheduleContentType) {
		this.scheduleContentType = scheduleContentType;
	}
	@InputConfig(resultName="uploadInput")
	public String upload() throws IOException{
		//上传位置  (web-inf/upload)
		String parentDir = ServletActionContext.getServletContext().getRealPath("/WEB-INF/upload");
		//文件名是随机数，没有扩展名
		String fileName = MyStringUtils.getUUID();
		//保存
		FileUtils.copyFile(schedule, new File(parentDir,fileName));
		//更新
		this.getModel().setUploadTime(new Date());
		this.getModel().setUploadPath("/WEB-INF/upload/"+fileName);
		this.getModel().setUploadFilename(scheduleFileName);
		this.classesService.updateUpload(this.getModel());
		return "upload";
	}
	//下载
	/**
	 * 下载
	 * @return
	 * @throws FileNotFoundException 
	 * 
	 */
	private InputStream inputStream;
	public InputStream getInputStream() {
		return inputStream;
	}
	private String downloadFileName;
	public String download() {
		CrmClasses findClass = this.classesService.findById(this.getModel().getClassId());
		InputStream  is = ServletActionContext.getServletContext().getResourceAsStream(findClass.getUploadPath());

     	if(is == null){
			this.addFieldError("uploadFilename", "课表已经不存在，请重新上传");
			return "input";
		}
		this.inputStream = is;
		this.downloadFileName = findClass.getUploadFilename();
		
		return "download";
	}

	public String getDownloadFileName() throws UnsupportedEncodingException {
		if(downloadFileName != null){
			return new String(downloadFileName.getBytes(),"ISO-8859-1");
		}
		return downloadFileName;
	}
	/**
	 * 添加编辑操作前
	 * @return
	 */
	public String addOrEditUI(){
		if(this.getModel().getClassId() != null){
			CrmClasses findClass = this.classesService.findById(this.getModel().getClassId());
			ActionContext.getContext().getValueStack().push(findClass);
		}
		List<CrmCourseType> allCourseTypes = this.courseTypeService.findAll();
		ActionContext.getContext().put("allCourseTypes", allCourseTypes);
		return "addOrEditUI";
	}
	/**
	 * 添加或修改
	 * @return
	 */
	public String addOrEdit(){
		this.classesService.addOrEdit(this.getModel());
		return "addOrEdit";
	}
	/**
	 * 查看班级
	 * @return
	 */
	public String showClass(){
		CrmClasses findClass = this.classesService.findById(this.getModel().getClassId());
		ActionContext.getContext().getValueStack().push(findClass);
		return "showClass";
	}
}
