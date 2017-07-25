package com.main.classes.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.classes.dao.ClassesDao;
import com.main.classes.model.Classes;
import com.main.classes.service.IClassesService;
import com.main.common.bean.Page;

@Service
public class ClassesServiceImpl implements IClassesService{

	@Autowired
	private ClassesDao classesDao;
	
	@Override
	public Page<Classes> findPage(Page<Classes> page, Classes classes) {
		classes.setPage(page);
		List<Classes> list = classesDao.findList(classes);
		page.setList(list);
		return page;
	}

}
