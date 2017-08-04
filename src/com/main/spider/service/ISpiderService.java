package com.main.spider.service;

import java.util.List;

import com.main.spider.bean.ContentListBean;
import com.main.spider.bean.SpiderBean;
import com.main.spider.model.Novel;


public interface ISpiderService {

	
	/**
	 * 获得目标对象
	 * @param spider
	 * @return
	 */
	public List<ContentListBean> getTargetContent(SpiderBean spider);
	
	/**
	 * 获得目标对象
	 * @param spider
	 * @return
	 */
	public List<ContentListBean> getTargetContentByJsoup(SpiderBean spider);
	
	/**
	 * 爬小说
	 * @param spider
	 * @return
	 */
	public List<Novel> spiderNovel(Novel spider);
}
