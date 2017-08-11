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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.main.common.bean.BaseController;
import com.main.common.bean.Page;
import com.main.spider.bean.NovelChapterBean;
import com.main.spider.model.Chapter;
import com.main.spider.model.Novel;
import com.main.spider.service.INovelService;

@Controller
@RequestMapping("/novel")
public class NovelController extends BaseController{

	@Autowired
	private INovelService novelServiceImpl;
	
	private Logger log;
	
	
	/**
	 * ��С˵�б�����
	 * @param novel
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/spiderNovelShow")
	public String spiderNovelShow(NovelChapterBean novel,Model model){
		return "novel/spiderNovel";		
	}
	/**
	 * ��С˵�б�����
	 * @param novel
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/spiderNovel",method=RequestMethod.POST)
	public String spiderNovel(NovelChapterBean novel,Model model,RedirectAttributes redirectAttributes){
		int result = 0;
		try {
			result = novelServiceImpl.saveNovels(novel);
		} catch (ParseException e) {
			log.error("date format error!");
			e.printStackTrace();
		}
		addMessage(redirectAttributes, "�ɹ�ץȡ��"+result+"��С˵!");
		return "redirect:/novel/getPageNovel";		
	}
	
	/**
	 * ��ҳ��ѯС˵�б�
	 * @param queryBean
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/getPageNovel")
	public String getPageNovel(Novel queryBean,HttpServletRequest request, HttpServletResponse response,Model model){
		Page<Novel> page = novelServiceImpl.findPage(new Page<Novel>(request, response), queryBean);
		model.addAttribute("page", page);
		model.addAttribute("queryBean", queryBean);
		return "novel/novelList";	
	}
	
	/**
	 * ��ȡС˵�½��б�
	 * @param novelId
	 * @param model
	 * @return
	 */
	@RequestMapping("/getNovelChapter")
	public String getNovelChapter(Chapter chapter,Model model){
		Novel novel = novelServiceImpl.getNovel(chapter.getNovelId());
		List<Chapter> chapters = novelServiceImpl.getNovelChapter(chapter);
		model.addAttribute("chapters", chapters);
		model.addAttribute("novel", novel);
		return "novel/chapterList";		
	}
	
	/**
	 * �鿴�½�����
	 * @param chapterId
	 * @param model
	 * @return
	 */
	@RequestMapping("/getChapterContent")
	public String getChapterContent(String chapterId,Model model){
		Chapter chapter = novelServiceImpl.getChapterContent(chapterId);
		chapter = novelServiceImpl.getLastNextChapter(chapter);
		Novel novel = novelServiceImpl.getNovel(chapter.getNovelId());
		model.addAttribute("chapter", chapter);
		model.addAttribute("novel", novel);
		return "novel/chapterContent";	
	}
}
