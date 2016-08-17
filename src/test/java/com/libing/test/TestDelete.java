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
 * Description:TODO
 * </p>
 * @author "libing"
 * @version 1.0
 * @Date 2016年1月4日下午11:17:41
 */
public class TestDelete {

    @Test
    public void testDelete() throws IOException {
        String ronf = "SqlMapConfig.xml";
        Reader reader = Resources.getResourceAsReader(ronf);
        SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
        // 创建 SqlSessionFactory 对象
        SqlSessionFactory sf = sfb.build(reader);
        // 创建 Session
        SqlSession session = sf.openSession();
        // 调用 deleteById 操作
        session.delete("deleteById", 1L);
        session.commit();
        // 提交
        session.close();
    }

}

