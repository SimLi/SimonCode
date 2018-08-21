package com.devfuns.test01;

import com.devfuns.mapper.DeptMapper;
import com.devfuns.model.Dept;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {

    SqlSessionFactory sqlSessionFactory;
    SqlSession sqlSession;

    @Test
    public void test01() {
        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
        List<Dept> list = deptMapper.selectDept();
        System.out.println(list);
    }

    @Test
    public void testSelectEmployeeByDeptNo() {
        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
        List<Dept> list = deptMapper.selectEmployeeByDeptNo(null);
        System.out.println(list);
    }

    @Test
    public void testInster() {
        Dept dept = new Dept();
        dept.setDeptCode("AAA");
        dept.setDeptName("Test001");
        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
        deptMapper.insterDept(dept);
        System.out.println(dept);
        // Dept{deptNo=5, deptName='Test001', deptCode='AAA', employeeList=null}
    }

    @Test
    public void testinsterBySelectKey() {
        Dept dept = new Dept();
        dept.setDeptCode("AAA111");
        dept.setDeptName("Test001");
        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
        deptMapper.insterBySelectKey(dept);
        sqlSession.commit();
        System.out.println(dept);
        // Dept{deptNo=5, deptName='Test001', deptCode='AAA', employeeList=null}
    }


    @Before
    public void testBefore(){
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // DefaultSqlSessionFactory
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 根据配置文件中的环境，使用不同的数据源连接
//        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream,"proc");
        sqlSession = sqlSessionFactory.openSession();
    }

    @After
    public void testAfter() {
        sqlSession.close();
    }
}
