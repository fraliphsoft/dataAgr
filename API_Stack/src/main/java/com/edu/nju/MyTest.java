package com.edu.nju;

import com.edu.nju.data.UserDao;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration("/spring-servlet.xml")
@RunWith(SpringJUnit4ClassRunner.class)

public class MyTest {


    @Autowired
    private UserDao userDao;

    @Test
    public void test1() {
        userDao.test();
    }



}