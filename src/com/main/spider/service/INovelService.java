package com.main.spider.service;

import java.text.ParseException;
import java.util.List;

import com.main.common.bean.Page;
import com.main.spider.bean.NovelChapterBean;
import com.main.spider.model.Chapter;
import com.main.spider.model.Novel;


public interface INovelService {
	
	
	/**
	 * 爬虫小说列表并保存
	 * @param novels
	 * @return
	 */
	public int saveNovels(NovelChapterBean novelBean)throws ParseException;
	/**
	 * 分页查询小说列表
	 * @param page
	 * @param queryBean
	 * @return
	 */
	public Page<Novel> findPage(Page<Novel> page,Novel queryBean);
	
	
	/**
	 * 查看小说详情
	 * @param novelId
	 * @return
	 */
	public Novel getNovel(int novelId);
	/**
	 * 查询小说章节列表
	 * @param novelId
	 * @return
	 */
	public List<Chapter> getNovelChapter(Chapter chapter);
	
	/**
	 * 获取章节内容
	 * @param chapterId
	 * @return
	 */
	public Chapter getChapterContent(String chapterId);
	
	/**
	 * 获取章节上下章
	 * @param chapter
	 * @return
	 */
	public Chapter getLastNextChapter(Chapter chapter);
}
