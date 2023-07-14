/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.fakhrirasyids.beataco.view.login;

import com.fakhrirasyids.beataco.data.database.DBInjector;
import com.fakhrirasyids.beataco.data.database.UserTableHandler;
import com.fakhrirasyids.beataco.view.admin.AdminScreen;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowEvent;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JPanel;

/**
 *
 * @author Fakhri
 */
public class LoginScreen extends javax.swing.JFrame {

    private static final String IMG_PATH = "src/main/resources/beataco_logo_circled.png";
    private Color bgColor = new Color(25, 25, 112);

    private UserTableHandler userTableHandler = new UserTableHandler();

    /**
     * Creates new form LoginFrame
     */
    public LoginScreen() {
        new DBInjector().openDatabase();
        initComponents();
        initLayout();
    }

    private void initLayout() {
        this.getContentPane().setBackground(bgColor);
        Font newButtonFont = new Font(btnClose.getFont().getName(), Font.BOLD, btnClose.getFont().getSize());
        btnClose.setFont(newButtonFont);
        btnClose.setOpaque(false);
        btnClose.setContentAreaFilled(false);
        btnClose.setBorderPainted(false);

        btnMinimize.setFont(newButtonFont);
        btnMinimize.setOpaque(false);
        btnMinimize.setContentAreaFilled(false);
        btnMinimize.setBorderPainted(false);

        btnSignIn.setOpaque(false);
        btnSignIn.setContentAreaFilled(false);
        btnSignIn.setBorderPainted(false);

        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));
            }
        });

        try {
            Image img = ImageIO.read(LoginScreen.class.getClassLoader().getResourceAsStream("beataco_logo_circled.png"));
            ImageIcon imageIcon = new ImageIcon(img);
            Image image = imageIcon.getImage(); // transform it
            Image newimg = image.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
            imageIcon = new ImageIcon(newimg);  // transform it back
            imgLogo.setIcon(imageIcon);

            edUsername.setHint("Username");
            edPassword.setHint("Password");
        } catch (IOException ex) {
            Logger.getLogger(LoginScreen.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private boolean isFormValid() {
        if (edUsername.getText().isEmpty()) {
            showMessageDialog(null, "Username Field can't be Empty!");
            return false;
        } else if (edPassword.getText().isEmpty()) {
            showMessageDialog(null, "Password Field can't be Empty!");
            return false;
        } else {
            return true;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnClose = new com.fakhrirasyids.beataco.view.components.asset.RoundedButton();
        imgLogo = new javax.swing.JLabel();
        edUsername = new com.fakhrirasyids.beataco.view.components.asset.TextField();
        edPassword = new com.fakhrirasyids.beataco.view.components.asset.TextPasswordField();
        btnSignIn = new com.fakhrirasyids.beataco.view.components.asset.RoundedButton();
        btnMinimize = new com.fakhrirasyids.beataco.view.components.asset.RoundedButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        btnClose.setForeground(new java.awt.Color(255, 255, 255));
        btnClose.setText("X");
        btnClose.setBorderColor(new java.awt.Color(25, 25, 112));
        btnClose.setColor(new java.awt.Color(25, 25, 112));
        btnClose.setColorClick(new java.awt.Color(25, 22, 100));
        btnClose.setColorOver(new java.awt.Color(25, 22, 135));
        btnClose.setFocusPainted(false);
        btnClose.setOpaque(true);
        btnClose.setRadius(40);
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        imgLogo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        edUsername.setForeground(new java.awt.Color(204, 204, 204));

        edPassword.setForeground(new java.awt.Color(204, 204, 204));

        btnSignIn.setBackground(new java.awt.Color(255, 255, 255));
        btnSignIn.setForeground(new java.awt.Color(25, 25, 112));
        btnSignIn.setText("Sign In");
        btnSignIn.setBorderColor(new java.awt.Color(25, 25, 112));
        btnSignIn.setColor(new java.awt.Color(255, 255, 255));
        btnSignIn.setColorClick(new java.awt.Color(153, 153, 153));
        btnSignIn.setColorOver(new java.awt.Color(204, 204, 204));
        btnSignIn.setFocusPainted(false);
        btnSignIn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSignIn.setOpaque(true);
        btnSignIn.setRadius(40);
        btnSignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignInActionPerformed(evt);
            }
        });

        btnMinimize.setForeground(new java.awt.Color(255, 255, 255));
        btnMinimize.setText("—");
        btnMinimize.setBorderColor(new java.awt.Color(25, 25, 112));
        btnMinimize.setColor(new java.awt.Color(25, 25, 112));
        btnMinimize.setColorClick(new java.awt.Color(25, 22, 100));
        btnMinimize.setColorOver(new java.awt.Color(25, 22, 135));
        btnMinimize.setFocusPainted(false);
        btnMinimize.setOpaque(true);
        btnMinimize.setRadius(40);
        btnMinimize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinimizeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(imgLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(btnMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(edPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(btnSignIn, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(imgLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(edUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSignIn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnSignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignInActionPerformed
        if (isFormValid()) {
            btnSignIn.setEnabled(false);
            String username = edUsername.getText();
            String password = edPassword.getText();
            if (userTableHandler.loginAdmin(username, password)) {
                this.dispose();
                JFrame adminScreen = new AdminScreen();
                adminScreen.setVisible(true);
                btnSignIn.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(null, "Wrong administrator account!", "Beataco", JOptionPane.ERROR_MESSAGE);
                btnSignIn.setEnabled(true);
            }
        }
    }//GEN-LAST:event_btnSignInActionPerformed

    private void btnMinimizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinimizeActionPerformed
        this.setState(LoginScreen.ICONIFIED);
    }//GEN-LAST:event_btnMinimizeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.fakhrirasyids.beataco.view.components.asset.RoundedButton btnClose;
    private com.fakhrirasyids.beataco.view.components.asset.RoundedButton btnMinimize;
    private com.fakhrirasyids.beataco.view.components.asset.RoundedButton btnSignIn;
    private com.fakhrirasyids.beataco.view.components.asset.TextPasswordField edPassword;
    private com.fakhrirasyids.beataco.view.components.asset.TextField edUsername;
    private javax.swing.JLabel imgLogo;
    // End of variables declaration//GEN-END:variables
}
