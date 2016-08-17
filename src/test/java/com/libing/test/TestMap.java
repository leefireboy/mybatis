/*
 * Copyright (c) 2016 Sohu TV. All rights reserved.
 */
package com.libing.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Ignore;
import org.junit.Test;

/**
 * <P>
 * Description:
 * </p>
 * @author "libing"
 * @version 1.0
 * @Date 2016年1月4日下午11:59:33
 */
public class TestMap {

    @Ignore
    @Test
    public void testFindDept() throws IOException {
        String conf = "SqlMapConfig.xml";
        Reader reader = Resources.getResourceAsReader(conf);
        SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
        SqlSessionFactory sf = sfb.build(reader);
        SqlSession session = sf.openSession();
        Map<String, Object> map = session.selectOne("findDept", 1L);
        System.out.println("部门号：" + map.get("deptno") + "，部门名称："
                + map.get("dname") + "，地址：" + map.get("loc"));
        session.close();
    }

//    @Ignore
    @Test
    public void testFindDepts() throws IOException {
        String conf = "SqlMapConfig.xml";
        Reader reader = Resources.getResourceAsReader(conf);
        SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
        SqlSessionFactory sf = sfb.build(reader);
        SqlSession session = sf.openSession();
        List<Map<String, Object>> list = session.selectList("findDepts");
        for (Map<String, Object> map : list) {
            System.out.println("部门号：" + map.get("deptno") + "，部门名称："
                    + map.get("dname") + "，地址：" + map.get("loc"));
        }
        session.close();
    }
}

