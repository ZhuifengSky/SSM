package com.main.spider.controller;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.main.common.bean.Page;
import com.main.spider.bean.ContentListBean;
import com.main.spider.bean.NovelBean;
import com.main.spider.bean.SpiderBean;
import com.main.spider.model.Novel;
import com.main.spider.service.ISpiderService;

@Controller
@RequestMapping("/spider")
public class SpiderController {

	@Autowired
	private ISpiderService spiderServiceImpl;
	
	private Logger log;
	/**
	 * 获取指定目标内容
	 * @param spider
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/getContent",produces = "application/json;charset=UTF-8",method=RequestMethod.POST)
	public String getTargetContent(SpiderBean spider,HttpServletRequest request, HttpServletResponse response,Model model){
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
	public String getContentBySoup(SpiderBean spider,HttpServletRequest request, HttpServletResponse response,Model model){
		List<ContentListBean> beans = spiderServiceImpl.getTargetContentByJsoup(spider);
		model.addAttribute("beans", beans);
		return "spider/contentList";		
	}
	
	
	
	/**
	 * 爬小说列表并保存
	 * @param novel
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/spiderNovel",method=RequestMethod.POST)
	public String spiderNovel(NovelBean novel,Model model){
		int result = 0;
		try {
			result = spiderServiceImpl.saveNovels(novel);
		} catch (ParseException e) {
			log.error("date format error!");
			e.printStackTrace();
		}
		model.addAttribute("result", result);
		return "success";		
	}
	
	/**
	 * 分页查询小说列表
	 * @param queryBean
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/getPageNovel")
	public String getPageNovel(Novel queryBean,HttpServletRequest request, HttpServletResponse response,Model model){
		Page<Novel> page = spiderServiceImpl.findPage(new Page<Novel>(request, response), queryBean);
		model.addAttribute("page", page);
		model.addAttribute("queryBean", queryBean);
		return "spider/novelList";	
	}
}
