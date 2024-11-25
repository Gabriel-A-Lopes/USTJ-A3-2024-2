package com.mycompany.coracaopet;

import javax.swing.*;
import java.awt.*;

public class RoundPanel extends JPanel {
    public RoundPanel() {
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
        
        g2.setColor(new Color(36, 117, 184));
        g2.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 30, 30);
        
        int thickness = 2;
        g2.setStroke(new BasicStroke(thickness));
        g2.drawRoundRect(thickness / 2, thickness / 2, getWidth() - thickness, getHeight() - thickness, 30, 30);
    }
}