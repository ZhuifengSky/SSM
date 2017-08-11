package com.main.spider.dao;

import java.util.List;

import com.main.spider.model.Chapter;

public interface IChapterDao {
	
	/**
	 * 批量保存章节
	 * @param chapters
	 * @return
	 */
	public int insertBatch(List<Chapter> chapters);
	
	
	/**
	 * 查询章节列表
	 * @param chapter
	 * @return
	 */
	public List<Chapter> findList(Chapter chapter);
	
	/**
	 * 章节查看
	 * @param chapterId
	 * @return
	 */
	public Chapter getChapterDetail(int chapterId);
	
	
	/**
	 * 获取上下章ID
	 * @param chapter
	 * @return
	 */
	public Integer getLastNextChapter(Chapter chapter);
}
