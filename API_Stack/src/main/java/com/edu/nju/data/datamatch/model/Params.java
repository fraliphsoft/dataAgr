package com.edu.nju.data.datamatch.model;

public class Params {

    private long pid;
    private long mid;
    private String name;
    private String type;
    private String desc;
    private long optional;


    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }


    public long getMid() {
        return mid;
    }

    public void setMid(long mid) {
        this.mid = mid;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


    public long getOptional() {
        return optional;
    }

    public void setOptional(long optional) {
        this.optional = optional;
    }

}
