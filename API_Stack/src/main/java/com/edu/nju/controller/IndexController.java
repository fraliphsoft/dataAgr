package com.edu.nju.controller;


import com.edu.nju.model.Method;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import com.edu.nju.dao.Dao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private Dao dao;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String convertToExamples(@RequestParam(name = "mid") long mid, HttpServletRequest request) {
        request.getSession().setAttribute("mid", mid);
        return "examples";
    }

    @ResponseBody
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

    @ResponseBody
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

    @ResponseBody
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
