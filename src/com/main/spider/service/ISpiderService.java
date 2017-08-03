package com.main.spider.service;

import java.util.List;

import com.main.spider.bean.ContentListBean;
import com.main.spider.model.Spider;


public interface ISpiderService {

	
	/**
	 * ���Ŀ�����
	 * @param spider
	 * @return
	 */
	public List<ContentListBean> getTargetContent(Spider spider);
	
	/**
	 * ���Ŀ�����
	 * @param spider
	 * @return
	 */
	public List<ContentListBean> getTargetContentByJsoup(Spider spider);
}
