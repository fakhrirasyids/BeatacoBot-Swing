/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fakhrirasyids.beataco.view.components.asset;

import com.google.protobuf.compiler.PluginProtos;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Fakhri
 */
 class ImageLogo extends JPanel{

    private BufferedImage image;

    public ImageLogo() {
       try {                
          image = ImageIO.read(new File("beataco_logo_circled.png"));
       } catch (IOException ex) {
          System.out.println(ex.toString());
       }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this); // see javadoc for more info on the parameters            
    }

}