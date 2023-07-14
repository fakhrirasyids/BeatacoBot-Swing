/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fakhrirasyids.beataco.data.database;

import static com.fakhrirasyids.beataco.data.database.DBInjector.connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author Fakhri
 */
public class MessageTableHandler {

    private ResultSet rs;
    private Statement stm;

    public boolean addMessage(Long idUser, String message, String status) {

        try {
            String sql = "INSERT into message(id_user,message,status) VALUES (?,?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, idUser);
            pstmt.setString(2, message);
            pstmt.setString(3, status);
            pstmt.executeUpdate();
            pstmt.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MessageTableHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public Object[][] getAllUserLogMessages(long idUser) {
        Object[][] dataTable = null;
        try {
            stm = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stm.executeQuery("select * from message where id_user=" + idUser + " order by datetime desc");
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
                dataTable[x][0] = rs.getString("status");
                dataTable[x][1] = rs.getString("message");
                dataTable[x][2] = rs.getDate("datetime");
                x++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dataTable;
    }

    public Object[][] getAllLogMessages(long idUser) {
        Object[][] dataTable = null;
        try {
            stm = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stm.executeQuery("select * from message order by datetime desc");
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
                dataTable[x][0] = rs.getString("status");
                dataTable[x][1] = rs.getString("message");
                dataTable[x][2] = rs.getDate("datetime");
                x++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dataTable;
    }
}
