/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.myproject.test_api;

import com.myproject.test_api.process.getDetailUser;
import static spark.Spark.get;
import static spark.Spark.port;
import com.myproject.test_api.process.getUser;
import static spark.Spark.post;

/**
 *
 * @author finex
 */
public class Test_api {

    public static void main(String[] args) {
        runJob();
    }
    
    public static void runJob() {
        port(8082);
        serverList();
    }
    
    public static void serverList() {
        get("/get/user/:id", (req, res) -> getUser.getUserProgram(req.params(":id")));
        get("/get/user", (req, res) -> getDetailUser.getDetail());
        post("/insert/user",(req, res) -> "");
    }
    
}
