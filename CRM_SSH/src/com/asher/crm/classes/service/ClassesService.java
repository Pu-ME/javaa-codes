package com.asher.crm.classes.service;

import java.util.List;

import com.asher.crm.classes.domain.CrmClasses;

public interface ClassesService {
	/**
	 * 查询所有
	 * @return
	 */
	public List<CrmClasses> findAll();
	/**
	 * 通过ID查询
	 * @param classesId
	 * @return
	 */
	public CrmClasses findById(String classesId);
	/**
	 * 更新上传
	 * @param model
	 */
	public void updateUpload(CrmClasses model);
	/**
	 * 添加或修改
	 * @param model
	 */
	public void addOrEdit(CrmClasses model);
}
