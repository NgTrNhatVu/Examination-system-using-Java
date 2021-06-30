/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Nv.dao;

import com.Nv.entity.Category;
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
public class CategoryDao implements Dao<Category> {

    private final DataSource dataSource;

    public CategoryDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Category> getAll() throws SQLException {
        Connection conn = null;
        Statement sttm = null;
        ResultSet rs = null;
        List<Category> catList = new ArrayList<>();
        String query = "SELECT * FROM category";

        try {
            conn = dataSource.getConnection();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(query);

            while (rs.next()) {
                int catID = rs.getInt(1);
                String catTitle = rs.getString(2);
                String catImg = rs.getString(3);

                catList.add(new Category(catID, catTitle, catImg));
            }
            return catList;
        } finally {
            close(conn, sttm, rs);
        }
    }

    @Override
    public void add(Category newCategory) throws SQLException {
        Connection conn = null;
        PreparedStatement pSttm = null;
        String query = "INSERT INTO category (cat_title, cat_img) "
                + "VALUES (?, ?)";
        try {
            conn = dataSource.getConnection();
            pSttm = conn.prepareStatement(query);
            pSttm.setString(1, newCategory.getTitle());
            pSttm.setString(2, newCategory.getImg());

            pSttm.execute();
        } finally {
            close(conn, pSttm, null);
        }
    }

    @Override
    public Category find(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Category t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
