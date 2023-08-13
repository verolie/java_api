/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myproject.test_api.process;

import com.google.gson.Gson;

import com.myproject.test_api.model.user_model;
import com.myproject.test_api.function.dbConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.log4j.Logger;

/**
 *
 * @author finex
 */
public class getUser {
    public static String getUserProgram(String userId){
        Statement stmt;
        Gson gson = new Gson();
        
        //logger
        Logger logger = Logger.getLogger(getUser.class.getName());
        
        //db connection
        dbConnection dbConn = new dbConnection();
        
        try {
            Connection conn = dbConn.connect();
            logger.info("Connection success");
            
            //query
            String query = "select * from public.\"user\" where id_user =" + userId;

            stmt = conn.createStatement();
           
            ResultSet rs = stmt.executeQuery(query);
                 
            user_model userData = null;
            
            while ( rs.next() ) {
            logger.info(rs);
             userData = new user_model(rs.getInt("id_user"), rs.getString("name"), rs.getString("gender"), rs.getString("type"));
            
            }

            String userDataJson = gson.toJson(userData);
            
            conn.close();
            return userDataJson;            
        } catch (SQLException e) {
            logger.error("Error: " + e.getMessage());
        }
     
        return "";
    }
}
