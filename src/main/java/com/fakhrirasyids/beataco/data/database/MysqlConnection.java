/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fakhrirasyids.beataco.data.database;

/**
 *
 * @author Fakhri
 */
import java.sql.*;

public class MysqlConnection {

    String url, usr, pwd, dbn;

    public MysqlConnection(String dbn) {
        this.url = "jdbc:mysql://127.0.0.1:3306/" + dbn;
        this.usr = "root";
        this.pwd = "";
    }

    public Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(this.url, this.usr,
                    this.pwd);
        } catch (SQLException e) {
            System.out.println("Error #2 : " + e.getMessage());
            System.exit(0);
        }
        return con;
    }


}
