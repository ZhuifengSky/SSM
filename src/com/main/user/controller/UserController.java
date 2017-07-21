package com.main.user.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.main.common.bean.PageInfo;
import com.main.user.bean.UserBean;
import com.main.user.model.User;
import com.main.user.service.IUserService;

/**
 * 
 * <p>Title:   HelloWorldController</p>
 * <p>Description: HelloWorld控制类  </p>
 * <p>Company:   www.edu24ol.com</p>
 * @author   pc-zw
 * @date     2015年8月6日下午2:49:06
 * @version  1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource
	private IUserService userServiceImpl;
	
	@RequestMapping("/searchUser.do")
	public String searchUser(UserBean queryBean,ModelMap map){
		List<User> users= userServiceImpl.findList(queryBean);
		map.put("users", users);
		map.put("pageBean", queryBean);
		map.put("queryBean", queryBean);
		return "jsp/listUser";
	}

	@RequestMapping("/findPage.do")
	public String findPage(HttpServletRequest request, HttpServletResponse response,User queryBean,ModelMap map){
		PageInfo<User> page = userServiceImpl.findPage(new PageInfo<User>(request, response),queryBean);
		map.put("page", page);
		map.put("queryBean", queryBean);
		return "jsp/listPageUser";
	}



	

}
