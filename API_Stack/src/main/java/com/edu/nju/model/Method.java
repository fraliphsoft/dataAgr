package com.edu.nju.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "methods")
public class Method {
    private int mid;

    private String name;

    public Method() {
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
}
