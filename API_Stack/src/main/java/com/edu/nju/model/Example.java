package com.edu.nju.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="so_example")
public class Example {

    @Id
    private int id;

    //方法id
    private int mid;

    //所属stackoverflow回答id
    private int postId;

    //原始代码(不用展示)
    private String code;

    //回答内容
    private String body;

    //回答分数
    private int score;

    //所属问题id
    private int parentId;

    //所有代码
    private String[] codeList;

    public Example() {
    }

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String[] getCodeList() {
        codeList = code.split("\\(20080808\\)(\r\n|\r|\n|\n\r)");
        for (int i=0; i<codeList.length; i++) {
        	codeList[i] = codeList[i].replaceAll("<code>", "").replaceAll("</code>", "");
        }
        return codeList;
    }

    public void setCodeList(String[] codeList) {
        this.codeList = codeList;
    }
}
