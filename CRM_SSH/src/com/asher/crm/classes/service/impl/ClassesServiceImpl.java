package com.asher.crm.classes.service.impl;

import java.util.List;

import com.asher.crm.classes.dao.ClassesDao;
import com.asher.crm.classes.domain.CrmClasses;
import com.asher.crm.classes.service.ClassesService;

public class ClassesServiceImpl implements ClassesService {
	private ClassesDao classesDao;
	public void setClassesDao(ClassesDao classesDao) {
		this.classesDao = classesDao;
	}
	public List<CrmClasses> findAll() {
		return this.classesDao.findAll();
	}
	public CrmClasses findById(String classesId) {
		return this.classesDao.findById(classesId);
	}
	public void updateUpload(CrmClasses classes) {
		CrmClasses findClasses = this.classesDao.findById(classes.getClassId());
		findClasses.setUploadPath(classes.getUploadPath());
		findClasses.setUploadFilename(classes.getUploadFilename());
		findClasses.setUploadTime(classes.getUploadTime());
	}
	public void addOrEdit(CrmClasses model) {
		this.classesDao.saveOrUpdate(model);
	}

}
