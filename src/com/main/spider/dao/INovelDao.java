package com.main.spider.dao;

import java.util.List;

import com.main.spider.model.Novel;

public interface INovelDao {

	
	/**
	 * 批量保存小说
	 * @param novels
	 * @return
	 */
	public int insertBatch(List<Novel> novels);
	
	/**
	 * 单个保存小说
	 * @param novels
	 * @return
	 */
	public int insert(Novel novel);
	
	
	/**
	 * 查询小说列表
	 * @param novel
	 * @return
	 */
	public List<Novel> findList(Novel novel);

	/**
	 * 查看单个小说
	 * @param novelId
	 * @return
	 */
	public Novel getNovel(int novelId);
}
