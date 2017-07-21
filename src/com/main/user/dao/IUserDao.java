package com.main.user.dao;

import java.util.List;

import com.main.user.bean.UserBean;
import com.main.user.model.User;


/**
 * 
 * <p>Title:   IUserMapper</p>
 * <p>Description: UserMapper接口 </p>
 * <p>Company:   www.edu24ol.com</p>
 * @author   pc-zw
 * @date     2015年8月6日下午5:17:32
 * @version  1.0
 */
public interface IUserDao {


	/**
	 * 用户列表查询
	 * @param queryBean
	 * @return
	 */
	public List<User> searchUser(UserBean queryBean);
	
	/**
	 * 查询用户
	 * @param queryBean
	 * @return
	 */
	public List<User> findList(User queryBean);
}
