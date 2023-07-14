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
public class CommandTableHandler {

    private ResultSet rs;
    private Statement stm;

    public Object[][] getAllCommands() {
        Object[][] dataTable = null;
        try {
            stm = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stm.executeQuery("select * from command");
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
                dataTable[x][0] = rs.getInt("id");
                dataTable[x][1] = rs.getString("command");
                dataTable[x][2] = rs.getString("response");
                dataTable[x][3] = rs.getString("deskripsi");
                x++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dataTable;
    }

    public boolean addCommand(String command, String response, String desc) {
        try {
            stm.executeUpdate("INSERT into command(command,response,deskripsi) VALUES('" + command + "','" + response + "','" + desc + "')");
            return true;
        } catch (SQLException e) {
            showMessageDialog(null, e);
        }
        return false;
    }

    public boolean updateCommand(String command, String response, String desc, int id) {
        try {
            stm.executeUpdate("update command set command='" + command + "',response='" + response + "',deskripsi='" + desc + "' where id=" + id + "");
            return true;
        } catch (SQLException e) {
            showMessageDialog(null, e);
        }
        return false;
    }

    public boolean deleteCommand(int id) {
        try {
            stm.executeUpdate("delete from command where id=" + id + "");
            return true;
        } catch (SQLException e) {
            showMessageDialog(null, e);
        }
        return false;
    }
}
