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
	 * ����С˵�Լ��½����Ĳ�����
	 * @param novels
	 * @return
	 */
	public int saveNovels(NovelBean novelBean)throws ParseException;
	/**
	 * ��ҳ��ѯС˵�б�
	 * @param page
	 * @param queryBean
	 * @return
	 */
	public Page<Novel> findPage(Page<Novel> page,Novel queryBean);
}
