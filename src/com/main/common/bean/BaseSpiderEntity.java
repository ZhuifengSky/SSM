package com.main.common.bean;

public class BaseSpiderEntity {
	
	private String baseUrl;   //Ŀ��URl
	private String targetUrl;   //Ŀ��URl
	private String encodingType; //��������
	private String targetPath;  //Ŀ��·�� html docment·��
	
	public String getTargetUrl() {
		return targetUrl;
	}
	public void setTargetUrl(String targetUrl) {
		this.targetUrl = targetUrl;
	}
	public String getEncodingType() {
		return encodingType;
	}
	public void setEncodingType(String encodingType) {
		this.encodingType = encodingType;
	}
	public String getTargetPath() {
		return targetPath;
	}
	public void setTargetPath(String targetPath) {
		this.targetPath = targetPath;
	}
	public String getBaseUrl() {
		return baseUrl;
	}
	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}
	
	
}
