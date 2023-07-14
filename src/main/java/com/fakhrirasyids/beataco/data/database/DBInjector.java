/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fakhrirasyids.beataco.data.database;

import java.sql.Connection;

/**
 *
 * @author Fakhri
 */
public class DBInjector {

    public static volatile Connection connection;

    public void openDatabase() {
        try {
            MysqlConnection con = new MysqlConnection("chatbot");
            connection = con.getConnection();
            System.out.println("Successfully connected with database");
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
    }
}
