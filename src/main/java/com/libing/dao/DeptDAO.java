/*
 * Copyright (c) 2016 Sohu TV. All rights reserved.
 */
package com.libing.dao;

import java.util.HashMap;
import java.util.List;

import com.libing.bean.Dept;
import com.libing.bean.Dept1;

/**
 * <P>
 * Description:
 * </p>
 * @author "libing"
 * @version 1.0
 * @Date 2016年1月4日下午5:55:32
 */
public interface DeptDAO {

    public void addDept(Dept dept);

    public void updateDept(Dept dept);

    public void deleteById(Long deptno);

    public Dept findById(Long deptno);

    public List<Dept> findAll();

    public HashMap<String, Object> findDept();

    public List<Dept1> findAll1();

}

