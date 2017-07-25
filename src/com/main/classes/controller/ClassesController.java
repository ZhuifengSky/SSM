package com.main.classes.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.main.classes.model.Classes;
import com.main.classes.service.IClassesService;
import com.main.common.bean.Page;

/**
 * 班级控制类
 * @author pc-zw
 *
 */
@Controller
@RequestMapping("/classes")
public class ClassesController {

	@Autowired
	private IClassesService classesService;
	
	/**
	 * 第二种分页方式
	 * @param request
	 * @param response
	 * @param queryBean
	 * @param map
	 * @return
	 */
	@RequestMapping("/findPage.do")
	public String findPage(HttpServletRequest request, HttpServletResponse response,Classes queryBean,ModelMap map){
		Page<Classes> page = classesService.findPage(new Page<Classes>(request, response),queryBean);
		map.put("page", page);
		map.put("queryBean", queryBean);
		return "jsp/listPageClass";
	}

}
