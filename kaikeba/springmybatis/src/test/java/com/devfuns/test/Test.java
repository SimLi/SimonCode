package com.devfuns.test;

import com.devfuns.mapper.DeptMapper;
import com.devfuns.model.Dept;
import com.devfuns.service.impl.IDeptServiceDefaultImpl;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by sim on 2018/8/21.
 */
public class Test {

    ApplicationContext ctx;

    @Before
    public void testBefore() {
        ctx=new ClassPathXmlApplicationContext("spring-appliaction.xml");
    }

    @org.junit.Test
    public void test01() {
        IDeptServiceDefaultImpl deptServiceDefault = ctx.getBean(IDeptServiceDefaultImpl.class);
        System.out.println(deptServiceDefault.selectDept());
    }

    @org.junit.Test
    public void testSelectEmployeeByDeptNo() {
    }

    @org.junit.Test
    public void testInster() {

    }
}
