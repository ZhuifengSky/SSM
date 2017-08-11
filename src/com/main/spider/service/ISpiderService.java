package com.main.spider.service;

import java.text.ParseException;
import java.util.List;

import com.main.common.bean.Page;
import com.main.spider.bean.ContentListBean;
import com.main.spider.bean.NovelBean;
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
	 * 爬虫小说以及章节正文并保存
	 * @param novels
	 * @return
	 */
	public int saveNovels(NovelBean novelBean)throws ParseException;
	/**
	 * 分页查询小说列表
	 * @param page
	 * @param queryBean
	 * @return
	 */
	public Page<Novel> findPage(Page<Novel> page,Novel queryBean);
}
