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
import org.junit.Test;

import com.libing.bean.Dept1;
import com.libing.dao.DeptDAO;

/**
 * <P>
 * Description:
 * </p>
 * @author "libing"
 * @version 1.0
 * @Date 2016年1月5日下午11:46:20
 */
public class TestResultMap {

    @Test
    public void testFindAll1() throws IOException {
        String conf = "SqlMapConfig.xml";
        Reader reader = Resources.getResourceAsReader(conf);
        SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
        SqlSessionFactory sf = sfb.build(reader);
        SqlSession session = sf.openSession();
        DeptDAO dao = session.getMapper(DeptDAO.class);
        List<Dept1> list = dao.findAll1();
        for (Dept1 dept1 : list) {
            System.out.println("部门号：" + dept1.getNo() + "，部门名称："
                    + dept1.getDname() + "，地址：" + dept1.getLoc());
        }
        session.close();
    }

}

