package com.main.spider.bean;

import com.main.common.bean.BaseSpiderEntity;

public class NovelChapterBean extends BaseSpiderEntity{

	private String title;   //����
	private String type;    //�������
	private String status;  //״̬
	private String author;  //����
	private String coverImage; //����
	private String description; //������
	private String detailUrl;  //����ҳurl
	private String chapterPath;  //�½�path
	private String chapterTitle; //�½ڱ���
	private String chapterDesc; //������
	private String contentUrl;
	private String contentPath;
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
	public String getDetailUrl() {
		return detailUrl;
	}
	public void setDetailUrl(String detailUrl) {
		this.detailUrl = detailUrl;
	}
	public String getChapterTitle() {
		return chapterTitle;
	}
	public void setChapterTitle(String chapterTitle) {
		this.chapterTitle = chapterTitle;
	}
	public String getChapterDesc() {
		return chapterDesc;
	}
	public void setChapterDesc(String chapterDesc) {
		this.chapterDesc = chapterDesc;
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
	public String getChapterPath() {
		return chapterPath;
	}
	public void setChapterPath(String chapterPath) {
		this.chapterPath = chapterPath;
	}
	
	
}
