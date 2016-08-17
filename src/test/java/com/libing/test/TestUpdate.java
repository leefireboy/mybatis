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
 * Description:TODO
 * </p>
 * @author "libing"
 * @version 1.0
 * @Date 2016年1月4日下午7:15:41
 */
public class TestUpdate {

    @Test
    public void testUpdate() throws IOException {
        String conf = "SqlMapConfig.xml";
        Reader reader = Resources.getResourceAsReader(conf);
        // 创建 SessionFactory 对象
        SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
        SqlSessionFactory sf = sfb.build(reader);
        // 创建 Session
        SqlSession session = sf.openSession();
        // 调用 updateDept 操作
        Dept dept = new Dept();
        dept.setDeptno(3L);
        dept.setDname("开发部");
        dept.setLoc("xiamen");
        session.update("updateDept", dept);
        session.commit();
        // 关闭
        session.close();
    }

}

