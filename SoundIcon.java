/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aoop;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;

/**
 *
 * @author Daniel
 */
public class SoundIcon /* extends JButton*/ implements ToolBarNode{
    public SoundIcon()
    {
        /*this.setBorder(BorderFactory.createEtchedBorder());
        this.setBackground(Color.red);
        this.setPreferredSize(new Dimension(60,60));
        this.setToolTipText("Use this sound");
        this.addActionListener(e-> System.exit(0) );*/
    }
    
    public SoundIcon(Color c, Dimension d)
    {
        this.c = c;
        this.d = d;
    }
    
    public Point getPoint()
    {
        return p.getLocation();
    }
    
    public void setPos(Point p)
    {
        this.p = p;
    }
    public Color getColor()
    {
        return c;
    }
    
    
    public boolean contains(Point p)
    {
        return (p.x>this.p.x && p.x<this.p.x+d.width) && 
               (p.y>this.p.y && p.y<this.p.y+d.height) ;
    }
    public void draw(Graphics2D g2d)
    {
        g2d.setColor(c);
        g2d.fillRect(p.x, p.y, d.width, d.height);
    }
    
    private Color c;
    private Dimension d;
    private Point p;
    private Sound s;
}
