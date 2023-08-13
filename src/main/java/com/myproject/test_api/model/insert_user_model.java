/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myproject.test_api.model;

/**
 *
 * @author finex
 */
public class insert_user_model {
    private int code;
    private String description;
    
    
    //constructor
    public insert_user_model(int code, String desc){
        this.code = code;
        this.description = desc;
    }
    
    //getter
    public int getCode() { return code; }
    public String getDesc() { return description; }

    
    
    //setter
    public void setId(int code) { this.code = code; }
    public void setName(String desc) { this.description = desc; }
}
