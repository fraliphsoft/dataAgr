package com.edu.nju.data.datamatch;

import com.edu.nju.data.datamatch.model.StackOverflowPost;
import com.edu.nju.data.datamatch.model.Methods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


/**
 * 提供匹配功能的工具类
 */
public class Matcher {

    static List<StackOverflowPost> allPosts = new LinkedList<>();

    static {
        Connection conn = JDBC_Driver.getConnection();
        try {
            String sql = "SELECT * FROM stack_answer";

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();


            while (rs.next()) {
                StackOverflowPost post = new StackOverflowPost();
                post.setId(rs.getLong(1));
                post.setLibName(rs.getString(2));
                post.setPostId(rs.getInt(3));
                post.setPostTypeId(rs.getInt(4));
                post.setAcceptedAnswerId(rs.getInt(5));
                post.setParentId(rs.getInt(6));
                post.setCreationDate(rs.getTimestamp(7));
                post.setDeletionDate(rs.getTimestamp(8));
                post.setScore(rs.getLong(9));
                post.setViewCount(rs.getLong(10));
                post.setBody(rs.getString(11));
                post.setOwnerUserId(rs.getLong(12));
                post.setOwnerDisplayName(rs.getString(13));
                post.setLastEditorUserId(rs.getLong(14));
                post.setLastEditorDisplayName(rs.getString(15));
                post.setLastEditDate(rs.getTimestamp(16));
                post.setLastActivityDate(rs.getTimestamp(17));
                post.setTitle(rs.getString(18));
                post.setTags(rs.getString(19));
                post.setAnswerCount(rs.getLong(20));
                post.setCommentCount(rs.getLong(21));
                post.setFavoriteCount(rs.getLong(22));
                post.setClosedDate(rs.getTimestamp(23));
                post.setCommunityOwnedDate(rs.getTimestamp(24));
                allPosts.add(post);
            }

            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param methods 要匹配的方法
     * @return stack overflow上此方法相关的使用代码前五名
     */
    public static Set<StackOverflowPost> getMatchExamplesOfMethodSignature(Methods methods) {
        String methodLibName = methods.getLibName();

        Set<StackOverflowPost> allMatchedPosts = new HashSet<>();
        // .methodName
        String toFind = "\\." + methods.getName();
        findMatchedPosts(allMatchedPosts, toFind, methodLibName);
        return allMatchedPosts;
    }

    /**
     * @param posts  保存当前匹配到的结果的posts的集合引用
     * @param toFind 匹配的字符串
     */
    private static void findMatchedPosts(Set<StackOverflowPost> posts, String toFind, String methodLibName) {
        for (StackOverflowPost post : allPosts) {
            String[] findParts = post.getBody().split(toFind);
            for (int i = 1; i < findParts.length; i++) {
                if (!findParts[i].equals("") && !Character.isLetter(findParts[i].charAt(0))
                        && methodLibName.contains(post.getLibName().toLowerCase())) {
                    posts.add(post);
                }
            }
        }
    }
}
