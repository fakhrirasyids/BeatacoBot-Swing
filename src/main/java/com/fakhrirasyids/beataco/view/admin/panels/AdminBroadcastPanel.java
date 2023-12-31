/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.fakhrirasyids.beataco.view.admin.panels;

import com.fakhrirasyids.beataco.data.bot.BeatacoBot;
import com.fakhrirasyids.beataco.data.database.UserTableHandler;
import static javax.swing.JOptionPane.showMessageDialog;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 *
 * @author Fakhri
 */
public class AdminBroadcastPanel extends javax.swing.JPanel {

    private UserTableHandler userTableHandler = new UserTableHandler();

    /**
     * Creates new form AdminBroadcastPanel
     */
    public AdminBroadcastPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        edMessage = new javax.swing.JTextField();
        btnBroadcast = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Message");

        edMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edMessageActionPerformed(evt);
            }
        });

        btnBroadcast.setText("Broadcast Message");
        btnBroadcast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBroadcastActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(173, 173, 173)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnBroadcast, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(edMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(150, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(edMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBroadcast)
                .addContainerGap(198, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void edMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edMessageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edMessageActionPerformed

    private void btnBroadcastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBroadcastActionPerformed
        if (edMessage.getText().isEmpty()) {
            showMessageDialog(null, "Message Field can't be Empty!");
        } else {
            long[] listChatId = userTableHandler.getAllUsersChatId();

            for (int i = 0; i < listChatId.length; i++) {
                SendMessage response = new SendMessage();
                String responseMsg = edMessage.getText();

                response.setChatId(listChatId[i]);
                response.setText(responseMsg);
                new BeatacoBot().sendMessageExecutor(response);
            }

            edMessage.setText("");
        }
    }//GEN-LAST:event_btnBroadcastActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBroadcast;
    private javax.swing.JTextField edMessage;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
