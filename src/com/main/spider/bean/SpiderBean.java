package com.main.spider.bean;

public class SpiderBean {

	private String targetUrl;   //Ŀ��URl
	private String targetPath;  //Ŀ��·�� html docment·��
	private String secondTargetPath;  //����Ŀ��·�� html docment·��
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
	public String getSecondTargetPath() {
		return secondTargetPath;
	}
	public void setSecondTargetPath(String secondTargetPath) {
		this.secondTargetPath = secondTargetPath;
	}
	
	
}
