package com.main.spider.service;

import java.text.ParseException;
import java.util.List;

import com.main.common.bean.Page;
import com.main.spider.bean.NovelChapterBean;
import com.main.spider.model.Chapter;
import com.main.spider.model.Novel;


public interface INovelService {
	
	
	/**
	 * ����С˵�б�����
	 * @param novels
	 * @return
	 */
	public int saveNovels(NovelChapterBean novelBean)throws ParseException;
	/**
	 * ��ҳ��ѯС˵�б�
	 * @param page
	 * @param queryBean
	 * @return
	 */
	public Page<Novel> findPage(Page<Novel> page,Novel queryBean);
	
	
	/**
	 * �鿴С˵����
	 * @param novelId
	 * @return
	 */
	public Novel getNovel(int novelId);
	/**
	 * ��ѯС˵�½��б�
	 * @param novelId
	 * @return
	 */
	public List<Chapter> getNovelChapter(Chapter chapter);
	
	/**
	 * ��ȡ�½�����
	 * @param chapterId
	 * @return
	 */
	public Chapter getChapterContent(String chapterId);
	
	/**
	 * ��ȡ�½�������
	 * @param chapter
	 * @return
	 */
	public Chapter getLastNextChapter(Chapter chapter);
}
