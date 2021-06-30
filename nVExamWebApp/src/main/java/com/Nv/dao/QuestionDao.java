/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Nv.dao;

import com.Nv.entity.Question;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author pc
 */
public class QuestionDao implements Dao<Question> {

    private final DataSource dataSource;

    public QuestionDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Question> getAll() throws SQLException {
        Connection conn = null;
        Statement sttm = null;
        ResultSet rs = null;
        List<Question> questionList = new ArrayList<>();
        String query = "SELECT * FROM question";
        try {
            conn = dataSource.getConnection();

            sttm = conn.createStatement();

            rs = sttm.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt(1);
                String ques = rs.getString(2);
                String correctAns = rs.getString(3);
                String a = rs.getString(4);
                String b = rs.getString(5);
                String c = rs.getString(6);
                String d = rs.getString(7);
                String e = rs.getString(8);
                String f = rs.getString(9);
                int cat_id = rs.getInt(10);
                int status = rs.getInt(11);

                questionList.add(new com.Nv.entity.Question(id, ques, correctAns, a, b, c, d, e, f, cat_id, status));
            }
            return questionList;

        } finally {
            close(conn, sttm, rs);
        }
    }

    @Override
    public void add(Question theQuestion) throws SQLException {
        Connection conn = null;
        PreparedStatement pSttm = null;
        String query = "INSERT INTO question "
                + "(ques_des, opt_1, opt_2, opt_3, opt_4, opt_5, opt_6, correct_ans, cat_id, status) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            conn = dataSource.getConnection();

            pSttm = conn.prepareStatement(query);

            pSttm.setString(1, theQuestion.getQuesDes());
            pSttm.setString(2, theQuestion.getOpt1());
            pSttm.setString(3, theQuestion.getOpt2());
            pSttm.setString(4, theQuestion.getOpt3());
            pSttm.setString(5, theQuestion.getOpt4());
            pSttm.setString(6, theQuestion.getOpt5());
            pSttm.setString(7, theQuestion.getOpt6());
            pSttm.setString(8, theQuestion.getCorrectAns());
            pSttm.setInt(9, theQuestion.getCatID());
            pSttm.setInt(10, theQuestion.getStatus());

            pSttm.execute();
        } finally {
            close(conn, pSttm, null);
        }
    }

    @Override
    public Question find(int id) throws SQLException {
        Connection conn = null;
        Statement sttm = null;
        ResultSet rs = null;
        String query = "SELECT * FROM question WHERE ques_id = " + id;

        try {
            conn = dataSource.getConnection();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(query);
            while (rs.next()) {
                int quesId = rs.getInt("ques_id");
                String quesDes = rs.getString("ques_des");
                String correctAns = rs.getString("correct_ans");
                String opt1 = rs.getString("opt_1");
                String opt2 = rs.getString("opt_2");
                String opt3 = rs.getString("opt_3");
                String opt4 = rs.getString("opt_4");
                String opt5 = rs.getString("opt_5");
                String opt6 = rs.getString("opt_6");
                int catId = rs.getInt("cat_id");
                int status = rs.getInt("status");
                return new Question(quesId, quesDes, correctAns, opt1, opt2, opt3, opt4, opt5, opt6, catId, status);
            }
            return null;
        } finally {
            close(conn, sttm, rs);
        }

    }

    @Override
    public void update(Question theQuestion) throws SQLException {
        Connection conn = null;
        PreparedStatement pSttm = null;
        String query = "UPDATE question SET "
                + "ques_des=?, "
                + "opt_1=?, "
                + "opt_2=?, "
                + "opt_3=?, "
                + "opt_4=?, "
                + "opt_5=?, "
                + "opt_6=?, "
                + "correct_ans=?, "
                + "cat_id=?,"
                + "status=? "
                + "WHERE ques_id = ?";
        try {
            conn = dataSource.getConnection();
            pSttm = conn.prepareStatement(query);

            pSttm.setString(1, theQuestion.getQuesDes());
            pSttm.setString(2, theQuestion.getOpt1());
            pSttm.setString(3, theQuestion.getOpt2());
            pSttm.setString(4, theQuestion.getOpt3());
            pSttm.setString(5, theQuestion.getOpt4());
            pSttm.setString(6, theQuestion.getOpt5());
            pSttm.setString(7, theQuestion.getOpt6());
            pSttm.setString(8, theQuestion.getCorrectAns());
            pSttm.setInt(9, theQuestion.getCatID());
            pSttm.setInt(10, theQuestion.getStatus());
            pSttm.setInt(11, theQuestion.getId());

            pSttm.execute();
        } finally {
            close(conn, pSttm, null);
        }
    }

    @Override
    public void delete(int id) throws SQLException{
        Connection conn = null;
        PreparedStatement pSttm = null;
        String query = "DELETE FROM question WHERE ques_id = ?";
        
        try{
            conn = dataSource.getConnection();
            pSttm = conn.prepareStatement(query);
            
            pSttm.setInt(1, id);
            
            pSttm.execute();
        }finally{
            close(conn, pSttm, null);
        }
    }

    private void close(Connection conn, Statement sttm, ResultSet myRs) {
        try {
            if (conn != null) {
                conn.close();
            }
            if (sttm != null) {
                sttm.close();
            }
            if (myRs != null) {
                myRs.close();
            }
        } catch (SQLException e) {
        }
    }

}
