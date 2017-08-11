package com.main.spider.dao;

import java.util.List;

import com.main.spider.model.Chapter;

public interface IChapterDao {
	
	/**
	 * ���������½�
	 * @param chapters
	 * @return
	 */
	public int insertBatch(List<Chapter> chapters);
	
	
	/**
	 * ��ѯ�½��б�
	 * @param chapter
	 * @return
	 */
	public List<Chapter> findList(Chapter chapter);
	
	/**
	 * �½ڲ鿴
	 * @param chapterId
	 * @return
	 */
	public Chapter getChapterDetail(int chapterId);
	
	
	/**
	 * ��ȡ������ID
	 * @param chapter
	 * @return
	 */
	public Integer getLastNextChapter(Chapter chapter);
}
