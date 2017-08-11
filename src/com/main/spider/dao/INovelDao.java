package com.main.spider.dao;

import java.util.List;

import com.main.spider.model.Novel;

public interface INovelDao {

	
	/**
	 * ��������С˵
	 * @param novels
	 * @return
	 */
	public int insertBatch(List<Novel> novels);
	
	/**
	 * ��������С˵
	 * @param novels
	 * @return
	 */
	public int insert(Novel novel);
	
	
	/**
	 * ��ѯС˵�б�
	 * @param novel
	 * @return
	 */
	public List<Novel> findList(Novel novel);

	/**
	 * �鿴����С˵
	 * @param novelId
	 * @return
	 */
	public Novel getNovel(int novelId);
}
