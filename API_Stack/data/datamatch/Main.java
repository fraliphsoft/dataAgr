import model.Methods;
import applicationIntegration.model.SoExample;
import applicationIntegration.model.StackOverflowPost;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        List<Methods> allMethods = getAllMethod();
        Set<SoExample> examples = new HashSet<>();

        int count = 0;
        for (Methods m : allMethods) {
            Set<StackOverflowPost> allMatchedPosts = Matcher.getMatchExamplesOfMethodSignature(m);
            for (StackOverflowPost post : allMatchedPosts) {
                SoExample example = new SoExample();
                example.setMid(m.getMid());
                example.setPostId(post.getPostId());
                example.setBody(post.getBody());
                example.setScore(post.getScore());
                example.setParentId(post.getParentId());
                // 相关Code
                example.setCode(getCodeInBody(m, post.getBody()));

                examples.add(example);
            }
            count += allMatchedPosts.size();
            System.out.println("---" + m.getMid() + ": " + allMatchedPosts.size() + "---");
        }
        System.out.println("examples size: " + count);
//        storeAllMatchedResult(examples);
    }

    /**
     * @return 所有需要匹配的方法
     */
    private static List<Methods> getAllMethod() {
        List<Methods> allMethods = null;
        Connection conn = JDBC_Driver.getConnection();
        try {
            String sql = "SELECT * FROM methods";

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            allMethods = new LinkedList<>();
            while (rs.next()) {
                Methods temp = new Methods();
                temp.setMid(rs.getLong(1));
                temp.setClassBelong(rs.getString(2));
                temp.setName(rs.getString(3));
                temp.setSignature(rs.getString(4));
                temp.setDesc(rs.getString(5));
                temp.setReturnType(rs.getString(6));
                temp.setReturnDesc(rs.getString(7));
                temp.setLibName(rs.getString(8));

                allMethods.add(temp);
            }

            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allMethods;
    }

    /**
     * 保存所有匹配结果
     */
    private static void storeAllMatchedResult(Set<SoExample> examples) {
        Connection conn = JDBC_Driver.getConnection();
        try {
            // 设置手动提交
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement("INSERT INTO so_example(mid, postId, `code`, body, score, parentId) VALUES (?, ?, ?, ?, ?, ?)");

            for (SoExample example : examples) {
                ps.setLong(1, example.getMid());
                ps.setLong(2, example.getPostId());
                ps.setString(3, example.getCode());
                ps.setString(4, example.getBody());
                ps.setLong(5, example.getScore());
                ps.setLong(6, example.getParentId());
                ps.addBatch();
            }
            // 执行批量处理
            ps.executeBatch();
            conn.commit();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获得单个post中属性body的内容code
     */
    private static String getCodeInBody(Methods m, String body) {
        Pattern pattern = Pattern.compile("<code>[\\s\\S]*?</code>");
        java.util.regex.Matcher match = pattern.matcher(body);

        StringBuilder sb = new StringBuilder();
        while (match.find()) {
            String tempCode = match.group();
            if (tempCode.contains(m.getName())) sb.append(tempCode).append("(20080808)\n");
        }

        return sb.toString();
    }
}
