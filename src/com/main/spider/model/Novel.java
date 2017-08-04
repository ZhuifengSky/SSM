package com.main.spider.model;

import com.main.common.bean.BaseSpiderEntity;
import com.main.user.model.User;

public class Novel extends BaseSpiderEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title;   //����
	private String type;    //�������
	private String status;  //״̬
	private String author;  //����
	private String coverImage; //����
	private String description; //������
	
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
	
	
}