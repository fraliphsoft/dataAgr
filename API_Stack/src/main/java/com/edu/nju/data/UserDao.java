package com.edu.nju.data;

import com.edu.nju.model.Method;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao{

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

}
