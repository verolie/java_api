/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myproject.test_api.function;

/**
 *
 * @author finex
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection {
    
    
    private final String url = "jdbc:postgresql://localhost:5432/test-api";
    private final String user = "postgres";
    private final String password = "admin";
    
    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
