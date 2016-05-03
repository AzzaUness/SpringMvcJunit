package com.test.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.test.entity.po.NamePO;

public interface NameDao  extends JpaRepository<NamePO, Long>, JpaSpecificationExecutor<NamePO>{

}
