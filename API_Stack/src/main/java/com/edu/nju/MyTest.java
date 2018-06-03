package com.edu.nju;

import com.edu.nju.dao.Dao;
import com.edu.nju.model.Example;
import com.edu.nju.model.Method;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@ContextConfiguration("/spring-servlet.xml")
@RunWith(SpringJUnit4ClassRunner.class)

public class MyTest {


    @Autowired
    private Dao dao;

    @Test
    public void test1() {
        List<Example> list = dao.getExample(82);
        System.out.println(list.size());
    }


}