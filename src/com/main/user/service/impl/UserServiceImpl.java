package com.main.user.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.main.common.bean.PageInfo;
import com.main.common.bean.PaginationContext;
import com.main.user.bean.UserBean;
import com.main.user.dao.IUserDao;
import com.main.user.model.User;
import com.main.user.service.IUserService;

/**
 * 
 * <p>Title:   UserServiceImpl.java</p>
 * <p>Description:  用户service实现 </p>
 * <p>Company:   www.edu24ol.com</p>
 * @author   pc-zw
 * @date     2015年8月20日下午6:55:45
 * @version  1.0
 */
@Service
public class UserServiceImpl implements IUserService{
	
	@Resource
	private IUserDao userDaoImpl;

	@Override
	public List<User> findList(UserBean queryBean) {
		return userDaoImpl.searchUser(queryBean);		
	}

	@Override
	public PageInfo<User> findPage(PageInfo<User> page,User queryBean) {
		queryBean.setPage(page);
		PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
        List<User> list = userDaoImpl.findList(queryBean);
        return new PageInfo<User>(list);
	}

}
