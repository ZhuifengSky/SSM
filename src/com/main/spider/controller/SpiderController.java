package com.main.spider.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.main.spider.bean.ContentListBean;
import com.main.spider.model.Spider;
import com.main.spider.service.ISpiderService;

@Controller
@RequestMapping("/spider")
public class SpiderController {

	@Autowired
	private ISpiderService spiderServiceImpl;
	/**
	 * 获取指定目标内容
	 * @param spider
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/getContent",produces = "application/json;charset=UTF-8",method=RequestMethod.POST)
	public String getTargetContent(Spider spider,HttpServletRequest request, HttpServletResponse response,Model model){
		spiderServiceImpl.getTargetContent(spider);
		return null;		
	}
	
	
	/**
	 * 获取指定目标内容
	 * @param spider
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/getContentBySoup",method=RequestMethod.POST)
	public String getContentBySoup(Spider spider,HttpServletRequest request, HttpServletResponse response,Model model){
		List<ContentListBean> beans = spiderServiceImpl.getTargetContentByJsoup(spider);
		model.addAttribute("beans", beans);
		return "/jsp/spider/contentList";		
	}
}
