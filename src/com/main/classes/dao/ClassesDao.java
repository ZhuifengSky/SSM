package com.main.classes.dao;

import java.util.List;

import com.main.classes.model.Classes;

/**
 * �༶Dao
 * @author 
 *
 */
public interface ClassesDao {

	/**
	 * �༶��ѯ
	 * @param classes
	 * @return
	 */
	public List<Classes> findList(Classes classes);
}
