
package com.mycompany.coracaopet;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class jbutton6 extends JButton {
    private BufferedImage image;

    public jbutton6(String imagePath) {
        try {
            image = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
    } {
    
    
   }
}
