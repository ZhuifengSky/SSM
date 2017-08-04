package com.main.spider.model;

public class Chapter {

	private int id;          //章节ID
	private int novelId;     //小说ID
	private String chapterTitle; //章节标题
	private String content;     //章节正文
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
