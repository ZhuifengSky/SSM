package com.main.classes.model;

import com.main.common.bean.BaseEntity;

/**
 * �༶
 * @author 
 *
 */
public class Classes extends BaseEntity<Classes>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String remark;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	
	
}
