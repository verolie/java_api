/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myproject.test_api.process;

import com.google.gson.Gson;
import com.myproject.test_api.function.dbConnection;
import com.myproject.test_api.model.user_model;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;

/**
 *
 * @author finex
 */
public class getDetailUser {
    
    public static String getDetail(){
        Map<Integer, user_model> data = new HashMap<>();
        Gson gson = new Gson();
        
        
        //logger
        Logger logger = Logger.getLogger(getUser.class.getName());
        
        //db connection
        dbConnection dbConn = new dbConnection();
        
        try {
            Connection conn = dbConn.connect();
            
            String query = "select * from public.\"user\"";
            
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            int i = 1;
            while ( rs.next() ) {
                
                logger.info(rs);
                user_model userData = new user_model(rs.getInt("id_user"), rs.getString("name"), rs.getString("gender"), rs.getString("type"));
                data.put(i, userData);
                i++;
            }
            
            String response = gson.toJson(data);
            return response;
        } catch (SQLException e) {
            logger.error("Error: " + e.getMessage());
        }

        return "";
    }
}
