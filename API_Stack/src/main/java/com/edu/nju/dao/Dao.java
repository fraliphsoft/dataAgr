package com.edu.nju.dao;

import com.edu.nju.model.Example;
import com.edu.nju.model.Method;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class Dao {

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }


    public void test() {
        Session session = getSession();
        session.beginTransaction();
        Method method = getSession().load(Method.class, 1);
        session.close();
        System.out.println(method.getName());
    }

    //通过库名(fs/mongodb/lodash)获得所有类列表
    public List<String> getClassNameList(String libName) {
        Session session = getSession();
        session.beginTransaction();

        String hql = "SELECT DISTINCT m.method_class FROM Method m where m.lib_name LIKE '%" + libName + "%'";

        Query query = session.createQuery(hql);
        List<String> res = query.list();
        session.close();
        return res;
    }

    //通过库名(fs/mongodb/lodash)和类名获得该类所有方法列表
    public List<Method> getMethodList(String libName, String className) {
        Session session = getSession();
        session.beginTransaction();

        String hql = "FROM Method m where m.lib_name LIKE '%" + libName + "%' AND m.method_class ='" + className + "'";

        Query query = session.createQuery(hql);

        List<Method> res = query.list();
        session.close();
        return res;
    }

    //通过库名(fs/mongodb/lodash)获得所有方法列表
    public List<Method> getMethodList(String libName) {
        Session session = getSession();
        session.beginTransaction();

        String hql = "FROM Method m where m.lib_name LIKE '%" + libName + "%'";

        Query query = session.createQuery(hql);

        List<Method> res = query.list();
        session.close();
        return res;
    }

    //通过methodID 获得Method
    public Method getMethod(int methodID) {
        Session session = getSession();
        session.beginTransaction();

        Method method = session.find(Method.class, methodID);
        session.close();
        return method;
    }

    //通过方法ID获得Example列表
    public List<Example> getExample(int methodID) {
        Session session = getSession();
        session.beginTransaction();

        String hql = "FROM Example e where e.mid = " + methodID + "ORDER BY e.score DESC";

        Query query = session.createQuery(hql);

        List<Example> res = query.list();
        session.close();
        return res;
    }

}
