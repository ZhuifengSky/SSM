package com.main.spider.model;

public class Spider {

	private String targetUrl;   //Ŀ��URl
	private String targetPath;  //Ŀ��·�� html docment·��
	private String encodingType; //��������
	public String getTargetUrl() {
		return targetUrl;
	}
	public void setTargetUrl(String targetUrl) {
		this.targetUrl = targetUrl;
	}
	public String getTargetPath() {
		return targetPath;
	}
	public void setTargetPath(String targetPath) {
		this.targetPath = targetPath;
	}
	public String getEncodingType() {
		return encodingType;
	}
	public void setEncodingType(String encodingType) {
		this.encodingType = encodingType;
	}
	
	
}
