package com.main.spider.model;

import com.main.common.bean.BaseEntity;
import com.main.spider.bean.ContentBean;

public class Chapter extends BaseEntity<Chapter>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer novelId;     //С˵ID
	private String title; //�½ڱ���
	private String description; //������
	private String content;     //�½�����
	private ContentBean contentBean;
	private String flag;  //��ʶȡ������һ�»�����һ��
	private Integer nextChapterId;  //��һ��ID
	private Integer lastChapterId;  //��һ��ID
	
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
