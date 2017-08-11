package com.main.spider.model;

import com.main.common.bean.BaseEntity;
import com.main.spider.bean.ContentBean;

public class Chapter extends BaseEntity<Chapter>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer novelId;     //小说ID
	private String title; //章节标题
	private String description; //简单描述
	private String content;     //章节正文
	private ContentBean contentBean;
	private String flag;  //标识取的是上一章还是下一章
	private Integer nextChapterId;  //下一章ID
	private Integer lastChapterId;  //上一章ID
	
	public Integer getNovelId() {
		return novelId;
	}
	public void setNovelId(Integer novelId) {
		this.novelId = novelId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ContentBean getContentBean() {
		return contentBean;
	}
	public void setContentBean(ContentBean contentBean) {
		this.contentBean = contentBean;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public Integer getNextChapterId() {
		return nextChapterId;
	}
	public void setNextChapterId(Integer nextChapterId) {
		this.nextChapterId = nextChapterId;
	}
	public Integer getLastChapterId() {
		return lastChapterId;
	}
	public void setLastChapterId(Integer lastChapterId) {
		this.lastChapterId = lastChapterId;
	}
	
	
	
	
}
