/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myproject.test_api.process;

import com.google.gson.Gson;
import com.myproject.test_api.function.dbConnection;
import com.myproject.test_api.model.user_model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author finex
 */
public class insertUser {
    public static String runInsertUser(){
        Gson gson = new Gson();
        
        //logger
        Logger logger = Logger.getLogger(getUser.class.getName());
        
        //db connection
        dbConnection dbConn = new dbConnection();
        
         try {
            Connection conn = dbConn.connect();
            logger.info("Connection success");
        
            insertDatabase(conn);
            
                 
            user_model userData = null;
            
//            while ( rs.next() ) {
//            logger.info(rs);
//             userData = new user_model(rs.getInt("id_user"), rs.getString("name"), rs.getString("gender"), rs.getString("type"));
//            
//            }

            String userDataJson = gson.toJson(userData);
            
            conn.close();
            return userDataJson;            
        } catch (SQLException e) {
            logger.error("Error: " + e.getMessage());
        }
        return "";
    }
    
    public static void insertDatabase(Connection conn){
        try { 
            String query = "INSERT INTO user (name, gender, type) VALUES (?, ?, ?)";
            PreparedStatement rs = conn.prepareStatement(query);
            
            rs.setString(1, "Suratman");
            rs.setString(2, "laki-laki");
            rs.setString(3, "front end");
            
            
            int rowsAffected = rs.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Data inserted successfully.");
                } else {
                    System.out.println("Data insertion failed.");
                }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(insertUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

