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

/**
 * <P>
 * Description:
 * </p>
 * @author "libing"
 * @version 1.0
 * @Date 2016年1月4日下午5:32:45
 */
public class TestSqlSession {

    @Test
    public void testSqlSession() throws IOException {
        String conf = "SqlMapConfig.xml";
        Reader reader = Resources.getResourceAsReader(conf);
        // 创建 SessionFactory 对象
        SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
        SqlSessionFactory sf = sfb.build(reader);
        // 创建 Session
        SqlSession session = sf.openSession();
        System.out.println(session);
        // 关闭 Session
        session.close();
    }

}

