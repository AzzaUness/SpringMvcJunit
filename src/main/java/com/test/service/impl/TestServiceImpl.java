package com.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.test.dao.NameDao;
import com.test.entity.po.NamePO;
import com.test.service.TestService;

public class TestServiceImpl implements TestService{
	@Autowired
	private NameDao testDao;
	public String getName(Long id) {
		NamePO po = testDao.findOne(id);
		if (po==null){
			return null;
		}else{
			return po.getName();
		}
	}

	public Long saveName(String name) {
		NamePO po = new NamePO();
		po.setName(name);
		po = testDao.save(po);
		return po.getId();
	}

}
