package com.edu.nju.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="methods")
public class Method {
    private int mid;

    @Column(name = "class")
    private String method_class;

    //方法名
    private String name;

    //方法签名
    private String signature;

    //方法描述
    private String desc;

    //返回类型
    private String return_type;

    //返回描述
    private String return_desc;

    private String lib_name;

    public String toString() {
        return "[" + mid + "," + method_class + "," + signature + "," + return_type + "," + "," +lib_name;
    }

    @Id
    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "class")
    public String getMethod_class() {
        return method_class;
    }

    @Column(name = "class")
    public void setMethod_class(String method_class) {
        this.method_class = method_class;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getReturn_type() {
        return return_type;
    }

    public void setReturn_type(String return_type) {
        this.return_type = return_type;
    }

    public String getReturn_desc() {
        return return_desc;
    }

    public void setReturn_desc(String return_desc) {
        this.return_desc = return_desc;
    }

    public String getLib_name() {
        return lib_name;
    }

    public void setLib_name(String lib_name) {
        this.lib_name = lib_name;
    }
}
