package com.main.user.service;

import java.util.List;

import com.main.common.bean.Page;
import com.main.common.bean.PageInfo;
import com.main.user.bean.UserBean;
import com.main.user.model.User;

/**
 * 
 * <p>Title:   IUserService.java</p>
 * <p>Description:  用户Service接口 </p>
 * <p>Company:   www.edu24ol.com</p>
 * @author   pc-zw
 * @date     2015年8月20日下午5:43:41
 * @version  1.0
 */
public interface IUserService {

	/**
	 * 用户列表查询
	 * @param queryBean
	 * @return
	 */
	public List<User> findList(UserBean queryBean);
	
	/**
	 * 用户列表分页查询
	 * @param queryBean
	 * @return
	 */
	public PageInfo<User> findPage(User queryBean);
	
	/**
	 * 分页方式2
	 * @param page
	 * @param queryBean
	 * @return
	 */
	public Page<User> findPage(Page<User> page,User queryBean);
}
