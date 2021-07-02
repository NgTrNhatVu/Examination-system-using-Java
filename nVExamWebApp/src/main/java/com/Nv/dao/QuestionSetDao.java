/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Nv.dao;

import com.Nv.entity.QuestionSet;
import java.sql.Connection;
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
public class QuestionSetDao implements Dao<QuestionSet> {

    private final DataSource dataSource;

    public QuestionSetDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<QuestionSet> getAll() throws SQLException {
        List<QuestionSet> questionSets = new ArrayList<>();
        Connection conn = null;
        Statement sttm = null;
        ResultSet rs = null;
        String query = "SELECT * FROM ques_set";

        try {
            conn = dataSource.getConnection();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(query);

            while (rs.next()) {
                String title = rs.getString("ques_set_title");
                String des = rs.getString("ques_set_des");
                String date = rs.getString("date");
                String img = rs.getString("ques_set_img");
                int status = rs.getInt("status");

                questionSets.add(new QuestionSet(title, des, date, img, status, null));
            }
            return questionSets;
        } finally {
            close(conn, sttm, rs);
        }

    }

    @Override
    public void add(QuestionSet t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public QuestionSet find(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(QuestionSet t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void close(Connection conn, Statement sttm, ResultSet rs) {
        try {
            if (conn != null) {
                conn.close();
            }
            if (sttm != null) {
                sttm.close();
            }
            if (rs != null) {
                rs.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

}
