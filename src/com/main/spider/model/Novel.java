package com.main.spider.model;


import java.util.List;

import com.main.common.bean.BaseEntity;
import com.main.spider.bean.ChapterBean;

public class Novel extends BaseEntity<Novel> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title;   //标题
	private String type;    //所属类别
	private String status;  //状态
	private String author;  //作者
	private String coverImage; //封面
	private String description; //简单描述
	private ChapterBean chapterBean; //章节对象
	private List<Chapter> chapters;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCoverImage() {
		return coverImage;
	}
	public void setCoverImage(String coverImage) {
		this.coverImage = coverImage;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public ChapterBean getChapterBean() {
		return chapterBean;
	}
	public void setChapterBean(ChapterBean chapterBean) {
		this.chapterBean = chapterBean;
	}
	public List<Chapter> getChapters() {
		return chapters;
	}
	public void setChapters(List<Chapter> chapters) {
		this.chapters = chapters;
	}
	
	
	
	
	
}
