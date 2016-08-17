/*
 * Copyright (c) 2016 Sohu TV. All rights reserved.
 */
package com.libing.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Ignore;
import org.junit.Test;

import com.libing.bean.Dept;
import com.libing.dao.DeptDAO;

/**
 * <P>
 * Description:
 * </p>
 * @author "libing"
 * @version 1.0
 * @Date 2016年1月5日下午11:05:32
 */
public class TestDeptDAO {

    @Ignore
    @Test
    public void testFindAll() throws IOException {
        String conf = "SqlMapConfig.xml";
        Reader reader = Resources.getResourceAsReader(conf);
        SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
        SqlSessionFactory sf = sfb.build(reader);
        SqlSession session = sf.openSession();
        DeptDAO dao = session.getMapper(DeptDAO.class);
        // 调用 findAll 方法
        List<Dept> list = dao.findAll();
        for (Dept dept : list) {
            System.out.println("部门号：" + dept.getDeptno() + "，部门名称："
                    + dept.getDname() + "，地址：" + dept.getLoc());
        }
        session.close();
    }

    @Ignore
    @Test
    public void testInsert() throws IOException {
        String conf = "SqlMapConfig.xml";
        Reader reader = Resources.getResourceAsReader(conf);
        SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
        SqlSessionFactory sf = sfb.build(reader);
        SqlSession session = sf.openSession();
        DeptDAO dao = session.getMapper(DeptDAO.class);
        // 调用 addDept 方法
        Dept dept = new Dept();
        dept.setDname("游戏");
        dept.setLoc("河南");
        dao.addDept(dept);
        session.commit();
        session.close();
    }

    @Ignore
    @Test
    public void testDelete() throws IOException {
        String conf = "SqlMapConfig.xml";
        Reader reader = Resources.getResourceAsReader(conf);
        SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
        SqlSessionFactory sf = sfb.build(reader);
        SqlSession session = sf.openSession();
        DeptDAO dao = session.getMapper(DeptDAO.class);
        // 调用 deleteById 方法
        dao.deleteById(1L);
        session.commit();
        session.close();
    }

    @Ignore
    @Test
    public void testUpdateDept() throws IOException {
        String conf = "SqlMapConfig.xml";
        Reader reader = Resources.getResourceAsReader(conf);
        SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
        SqlSessionFactory sf = sfb.build(reader);
        SqlSession session = sf.openSession();
        DeptDAO dao = session.getMapper(DeptDAO.class);
        // 调用 updateDept 方法
        Dept dept = new Dept();
        dept.setDeptno(3L);
        dept.setDname("develop");
        dept.setLoc("厦门");
        dao.updateDept(dept);
        session.commit();
        session.close();
    }

//    @Ignore
    @Test
    public void testFindById() throws IOException {
        String conf = "SqlMapConfig.xml";
        Reader reader = Resources.getResourceAsReader(conf);
        SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
        SqlSessionFactory sf = sfb.build(reader);
        SqlSession session = sf.openSession();
        DeptDAO dao = session.getMapper(DeptDAO.class);
        // 调用 findAll 方法
        Dept dept = dao.findById(1L);
        System.out.println("部门号：" + dept.getDeptno() + "，部门名称："
                + dept.getDname() + "，地址：" + dept.getLoc());
        session.close();
    }

}

