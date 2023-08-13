/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myproject.test_api.model;

/**
 *
 * @author finex
 */
public class user_model {
    private int id;
    private String name;
    private String gender;
    private String type;
    
    
    //constructor
    public user_model(int id , String name, String gender, String type){
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.type = type;
    }
    
    //getter
    public int getId() { return id; }
    public String getName() { return name; }
    public String getGender() { return gender; }
    public String getType() { return type; }
    
    
    //setter
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setGender(String gender) { this.gender = gender; }
    public void setType(String type) { this.type = type; }
}
