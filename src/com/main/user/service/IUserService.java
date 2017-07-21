package com.main.user.service;

import java.util.List;

import com.main.common.bean.Page;
import com.main.common.bean.PageInfo;
import com.main.user.bean.UserBean;
import com.main.user.model.User;

/**
 * 
 * <p>Title:   IUserService.java</p>
 * <p>Description:  �û�Service�ӿ� </p>
 * <p>Company:   www.edu24ol.com</p>
 * @author   pc-zw
 * @date     2015��8��20������5:43:41
 * @version  1.0
 */
public interface IUserService {

	/**
	 * �û��б��ѯ
	 * @param queryBean
	 * @return
	 */
	public List<User> findList(UserBean queryBean);
	
	/**
	 * �û��б��ҳ��ѯ
	 * @param queryBean
	 * @return
	 */
	public PageInfo<User> findPage(User queryBean);
	
	/**
	 * ��ҳ��ʽ2
	 * @param page
	 * @param queryBean
	 * @return
	 */
	public Page<User> findPage(Page<User> page,User queryBean);
}
