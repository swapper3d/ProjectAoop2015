/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aoop;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Iterator;
import java.util.LinkedList;
import javax.swing.JComponent;
/**
 *
 * @author Daniel
 */
public class ToolBar extends JComponent{
    
    public ToolBar(Model m)
    {
        this.m = m;
        //setLayout(new FlowLayout());
        //sounds = new LinkedList<>();
        this.setPreferredSize(new Dimension(40,40));
    }
    
    void addSound(SoundIcon s)
    {
        s.setPos(new Point(m.getTypeLength()*42,0));
        m.addType(s);
        repaint();
    }
    
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Iterator<SoundIcon> it = m.getTypes();
        Graphics2D g2 = (Graphics2D) g;
        while(it.hasNext())
        {
            it.next().draw(g2);
        }
    }
   private final Model m;
}
