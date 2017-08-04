package com.main.common.bean;

public class BaseSpiderEntity extends BaseEntity<BaseSpiderEntity> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String targetUrl;   //目标URl
	private String encodingType; //编码类型
	private String targetPath;  //目标路径 html docment路径
	
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
	
	
}
