package com.main.user.model;

import com.main.common.bean.BaseEntity;

/**
 * 
 * <p>Title:   User</p>
 * <p>Description:  用户 </p>
 * <p>Company:   www.edu24ol.com</p>
 * @author   pc-zw
 * @date     2015年8月6日下午2:52:03
 * @version  1.0
 */
public class User extends BaseEntity<User>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userName;
	private String sex;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	
	
}
