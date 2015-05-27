/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aoop;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Iterator;
import javax.swing.JComponent;

/**
 *
 * @author Daniel
 */
public class MainFrame extends JComponent{
    
    public MainFrame(Model m/*, Controller c*/)
    {
        this.m = m;
        //this.c = c;
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        paintBackground(g2d);
    }
    
    
    private void paintBackground(Graphics2D g2d)
    {
        g2d.drawRect(0, 1, this.getWidth()-1, this.getHeight()-2);
        /*for(int i = 0, y;i<4;i++)
        {
            y = this.getHeight()/4*i+1;
            g2.drawLine(0, y , this.getWidth()-1, y);
        }*/
    }
    private final Model m;
    //private final Controller c;
}
