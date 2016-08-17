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

/**
 * <P>
 * Description:
 * </p>
 * @author "libing"
 * @version 1.0
 * @Date 2016年1月4日下午11:30:17
 */
public class TestFind {

    @Ignore
    @Test
    public void testFind() throws IOException {
        String conf = "SqlMapConfig.xml";
        Reader reader = Resources.getResourceAsReader(conf);
        SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
        SqlSessionFactory sf = sfb.build(reader);
        SqlSession session = sf.openSession();
        Dept dept = session.selectOne("findById", 1L);
        System.out.println("部门号：" + dept.getDeptno() + "，部门名称："
                + dept.getDname() + "，地址：" + dept.getLoc());
        session.close();
    }

//    @Ignore
    @Test
    public void testFindAll() throws IOException {
        String conf = "SqlMapConfig.xml";
        Reader reader = Resources.getResourceAsReader(conf);
        SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
        SqlSessionFactory sf = sfb.build(reader);
        SqlSession session = sf.openSession();
        List<Dept> list = session.selectList("findAll");
        for (Dept dept : list) {
            System.out.println("部门号：" + dept.getDeptno() + "，部门名称："
                    + dept.getDname() + "，地址：" + dept.getLoc());
        }
        session.close();
    }

}

