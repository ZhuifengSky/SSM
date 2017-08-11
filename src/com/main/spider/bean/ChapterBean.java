package com.main.spider.bean;

public class ChapterBean {

	private int novelId;     //小说ID
	private String chapterUrl; //章节所在目录
	private String chapterPath; //章节所在目录
	private String chapterTitle; //章节标题
	private String description; //简单描述
	private String contentUrl;
	private String contentPath;
	public int getNovelId() {
		return novelId;
	}
	public void setNovelId(int novelId) {
		this.novelId = novelId;
	}
	public String getChapterTitle() {
		return chapterTitle;
	}
	public void setChapterTitle(String chapterTitle) {
		this.chapterTitle = chapterTitle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getContentUrl() {
		return contentUrl;
	}
	public void setContentUrl(String contentUrl) {
		this.contentUrl = contentUrl;
	}
	public String getContentPath() {
		return contentPath;
	}
	public void setContentPath(String contentPath) {
		this.contentPath = contentPath;
	}
	public String getChapterUrl() {
		return chapterUrl;
	}
	public void setChapterUrl(String chapterUrl) {
		this.chapterUrl = chapterUrl;
	}
	public String getChapterPath() {
		return chapterPath;
	}
	public void setChapterPath(String chapterPath) {
		this.chapterPath = chapterPath;
	}
	
	
	
	
}
