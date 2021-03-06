package com.asher.crm.post.domain;

import java.util.HashSet;
import java.util.Set;

import com.asher.crm.department.domain.CrmDepartment;
import com.asher.crm.staff.domain.CrmStaff;

/**
 * CrmPost实体类
 * @author Asher
 *
 */
public class CrmPost {
/*	CREATE TABLE `crm_post` (
			  `postId` varchar(255) NOT NULL PRIMARY KEY,
			  `postName` varchar(100) DEFAULT NULL,
			  `depId` varchar(255) DEFAULT NULL,
			  CONSTRAINT FOREIGN KEY (`depId`) REFERENCES `crm_department` (`depId`)
			);*/
	private String postId;
	private String postName;
	
	private CrmDepartment department;
	private Set<CrmStaff> staffSet = new HashSet<CrmStaff>();
	public String getPostId() {
		return postId;
	}
	public void setPostId(String postId) {
		this.postId = postId;
	}
	public String getPostName() {
		return postName;
	}
	public void setPostName(String postName) {
		this.postName = postName;
	}
	public CrmDepartment getDepartment() {
		return department;
	}
	public void setDepartment(CrmDepartment department) {
		this.department = department;
	}
	public Set<CrmStaff> getStaffSet() {
		return staffSet;
	}
	public void setStaffSet(Set<CrmStaff> staffSet) {
		this.staffSet = staffSet;
	}

	
}
