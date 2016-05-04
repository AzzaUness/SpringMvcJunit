package com.test.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.test.entity.po.NamePO;
@Repository
public interface NameDao  extends JpaRepository<NamePO, Long>, JpaSpecificationExecutor<NamePO>{

}
