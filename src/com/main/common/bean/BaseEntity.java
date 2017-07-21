package com.main.common.bean;

import java.io.Serializable;
import java.util.Date;

import com.main.user.model.User;

public class BaseEntity<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * ʵ���ţ�Ψһ��ʶ��
	 */
	protected String id;
	/**
	 * ��ǰʵ���ҳ����
	 */
	/**
	 * ��ǰ�û�
	 */
	protected User currentUser;
	protected PageInfo<T> page;
	protected String remarks; // ��ע
	protected User createBy; // ������
	protected Date createDate; // ��������
	protected User updateBy; // ������
	protected Date updateDate; // ��������
	protected String delFlag; // ɾ����ǣ�0��������1��ɾ����2����ˣ�
	protected String ip;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public User getCurrentUser() {
		return currentUser;
	}
	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}
	public PageInfo<T> getPage() {
		return page;
	}
	public void setPage(PageInfo<T> page) {
		this.page = page;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public User getCreateBy() {
		return createBy;
	}
	public void setCreateBy(User createBy) {
		this.createBy = createBy;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public User getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(User updateBy) {
		this.updateBy = updateBy;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}

	
}
