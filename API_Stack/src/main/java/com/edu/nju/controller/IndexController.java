package com.edu.nju.controller;


import com.edu.nju.model.Method;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import com.edu.nju.dao.Dao;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
public class IndexController {
    @Autowired
    private Dao dao;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getxxx(@RequestParam(name = "mid") long mid, HttpServletRequest request) {
        request.getSession().setAttribute("mid", mid);
        return "examples";
    }

    @RequestMapping(value = "/fs", method = RequestMethod.POST)
    public String getFsMethods() {

        List<Method> methodList = dao.getMethodList("fs");
        List<tempMethod> tempMethodList = new ArrayList<>();
        for (Method method : methodList) {
            long mid = method.getMid();
            String cname = method.getMethod_class();
            String mname = method.getName();
            String description = method.getDesc();
            tempMethodList.add(new tempMethod(mid, cname, mname, description));
        }
        Gson gson = new Gson();
        return gson.toJson(tempMethodList);
    }

    @RequestMapping(value = "/mongodb", method = RequestMethod.POST)
    public String getMongoDBMethods() {
        List<Method> methodList = dao.getMethodList("mongodb nodejs driver");
        List<tempMethod> tempMethodList = new ArrayList<>();
        for (Method method : methodList) {
            long mid = method.getMid();
            String cname = method.getMethod_class();
            String mname = method.getName();
            String description = method.getDesc();
            tempMethodList.add(new tempMethod(mid, cname, mname, description));
        }
        Gson gson = new Gson();
        return gson.toJson(tempMethodList);
    }

    @RequestMapping(value = "/lodash", method = RequestMethod.POST)
    public String getLodashDBMethods() {
        List<Method> methodList = dao.getMethodList("lodash");
        List<tempMethod> tempMethodList = new ArrayList<>();
        for (Method method : methodList) {
            long mid = method.getMid();
            String cname = method.getMethod_class();
            String mname = method.getName();
            String description = method.getDesc();
            tempMethodList.add(new tempMethod(mid, cname, mname, description));
        }
        Gson gson = new Gson();
        return gson.toJson(tempMethodList);
    }


}

class tempMethod {
    private long mid;
    private String cname;
    private String mname;
    private String description;

    public tempMethod(long mid, String cname, String mname, String description) {
        this.mid = mid;
        this.cname = cname;
        this.mname = mname;
        this.description = description;
    }
}
