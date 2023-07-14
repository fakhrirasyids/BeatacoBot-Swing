/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fakhrirasyids.beataco.data.database;

import static com.fakhrirasyids.beataco.data.database.DBInjector.connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author Fakhri
 */
public class UserTableHandler {

    private ResultSet rs;
    private Statement stm;

    public Object[][] getAllUsers() {
        Object[][] dataTable = null;
        try {
            stm = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stm.executeQuery("select * from users where role='member'");
            ResultSetMetaData meta = rs.getMetaData();
            int col = meta.getColumnCount();
            int baris = 0;
            while (rs.next()) {
                baris = rs.getRow();
            }
            dataTable = new Object[baris][col];
            int x = 0;
            rs.beforeFirst();
            while (rs.next()) {
                dataTable[x][0] = rs.getInt("user_id");
                dataTable[x][1] = rs.getString("username");
                x++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dataTable;
    }

    public long[] getAllUsersChatId() {
        long[] dataTable = null;
        try {
            stm = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stm.executeQuery("select * from users where role='member'");
            ResultSetMetaData meta = rs.getMetaData();
            int col = meta.getColumnCount();
            int baris = 0;
            while (rs.next()) {
                baris = rs.getRow();
            }
            dataTable = new long[baris];
            int x = 0;
            rs.beforeFirst();
            while (rs.next()) {
                dataTable[x] = rs.getLong("user_id");
                x++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dataTable;
    }

    public boolean checkUserId(long userId) {
        try {
            stm = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stm.executeQuery("select * from users where user_id=" + userId + "");
            ResultSetMetaData meta = rs.getMetaData();
            int col = meta.getColumnCount();
            int baris = 0;
            while (rs.next()) {
                baris = rs.getRow();
            }
            if (baris > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean loginAdmin(String username, String password) {
        try {
            stm = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stm.executeQuery("select * from users where username='" + username + "' and password='" + password + "'");
            ResultSetMetaData meta = rs.getMetaData();
            int col = meta.getColumnCount();
            int baris = 0;
            while (rs.next()) {
                baris = rs.getRow();
            }
            if (baris > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addUser(long userId, String username) {
        try {
            stm.executeUpdate("INSERT into users(user_id,username,role) VALUES(" + userId + ",'" + username + "','member')");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteUser(long userId) {
        try {
            stm.executeUpdate("delete from users where user_id=" + userId + "");
            return true;
        } catch (SQLException e) {
            showMessageDialog(null, e);
        }
        return false;
    }
}
