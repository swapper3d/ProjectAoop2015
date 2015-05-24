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
public class Key {
    static int index= 0;
    public Key()
    {
         p = new Point((KEY_SIZE.width)*index +100, 50);
         index++;
    }
    
    public void draw(Graphics2D g2d, Dimension size)
    {
       
        g2d.fillRect(p.x, p.y, KEY_SIZE.width, KEY_SIZE.height);
    }
    
    public boolean contains(Point p)
    {
        return (p.x>this.p.x && p.x<this.p.x+KEY_SIZE.width) && 
               (p.y>this.p.y && p.y<this.p.y+KEY_SIZE.height) ;
    }
    
    public void play()
    {
        if(s!= null)
            s.play();
    }
    
    public void setSound(Sound s)
    {
        this.s = s;
    }
    private Point p;
    private Sound s;
    private final Dimension KEY_SIZE = new Dimension(40,100);
}
