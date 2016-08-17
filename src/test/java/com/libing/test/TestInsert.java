/*
 * Copyright (c) 2016 Sohu TV. All rights reserved.
 */
package com.libing.test;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.libing.bean.Dept;

/**
 * <P>
 * Description:
 * </p>
 * @author "libing"
 * @version 1.0
 * @Date 2016年1月4日下午6:09:06
 */
public class TestInsert {

    @Test
    public void testInsert() throws IOException {
        String conf = "SqlMapConfig.xml";
        Reader reader = Resources.getResourceAsReader(conf);
        // 创建 SessionFactory 对象
        SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
        // 创建 SqlSessionFactory 对象
        SqlSessionFactory sf = sfb.build(reader);
        // 创建 Session
        SqlSession session = sf.openSession();
        // 调用 addDept 操作
        Dept dept = new Dept();
        dept.setDname("develop");
        dept.setLoc("tianjin");
        session.insert("addDept", dept);
        session.commit();
        // 关闭
        session.close();
    }

}

