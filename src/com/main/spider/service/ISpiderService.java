package com.main.spider.service;

import java.util.List;

import com.main.spider.bean.ContentListBean;
import com.main.spider.bean.SpiderBean;
import com.main.spider.model.Novel;


public interface ISpiderService {

	
	/**
	 * ���Ŀ�����
	 * @param spider
	 * @return
	 */
	public List<ContentListBean> getTargetContent(SpiderBean spider);
	
	/**
	 * ���Ŀ�����
	 * @param spider
	 * @return
	 */
	public List<ContentListBean> getTargetContentByJsoup(SpiderBean spider);
	
	/**
	 * ��С˵
	 * @param spider
	 * @return
	 */
	public List<Novel> spiderNovel(Novel spider);
}
