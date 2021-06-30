/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Nv.dao;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author pc
 */
public interface Dao<T> {

    List<T> getAll() throws SQLException;

    void add(T t) throws SQLException;

    T find(int id) throws SQLException;

    void update(T t) throws SQLException;

    void delete(int id) throws SQLException;
}
