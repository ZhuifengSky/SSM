package com.main.classes.service;

import com.main.classes.model.Classes;
import com.main.common.bean.Page;


public interface IClassesService {

	/**
	 * �༶��ҳ��ѯ
	 * @param page
	 * @param classes
	 * @return
	 */
	public Page<Classes> findPage(Page<Classes> page,Classes classes);
}
