/*
 * Copyright (c) 2016 Sohu TV. All rights reserved.
 */
package com.libing.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
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
 * @Date 2016年1月4日下午11:47:07
 */
public class TestPage {

    @Test
    public void testFind() throws IOException {
        String conf = "SqlMapConfig.xml";
        Reader reader = Resources.getResourceAsReader(conf);
        SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
        SqlSessionFactory sf = sfb.build(reader);
        SqlSession session = sf.openSession();

        // 设置分页对象
        int offset = 1;// 起点，从0开始
        int limit = 2;// 查询条数
        RowBounds rowBounds = new RowBounds(offset, limit);

        List<Dept> list = session.selectList("findAll", null, rowBounds);
        for (Dept dept : list) {
            System.out.println("部门号：" + dept.getDeptno() + "，部门名称："
                    + dept.getDname() + "，地址：" + dept.getLoc());
        }
        session.close();
    }

}

