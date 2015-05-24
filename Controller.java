/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aoop;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;

/**
 *
 * @author Daniel
 */
public class Controller {
    
    public void addView(View v)
    {
        this.v = v;
    }
    public void addModel(Model m)
    {
        this.m = m;
    }
    
    public MouseListener getMenuDragged()
    {
        return new MouseAdapter()
        {
            public void mouseDragged(MouseEvent e) 
            {
                System.out.println(e); 
                
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
    }
    
    public MouseListener getMenuPressed()
    {
        return new MouseAdapter() 
        {
            public void mousePressed(MouseEvent e) 
            {
                Iterator<SoundIcon> it = m.getTypes();
                
                while(it.hasNext())
                {
                    SoundIcon tmp = it.next();
                    if( tmp.contains( e.getPoint() ) )
                    {
                        tmp.getPoint();//e.getPoint();
                        System.out.println("pressed in square");
                    }
                }
                System.out.println(e.getPoint()); 
            }
        };
    }
    
    public MouseListener getKeyPressed()
    {
        return new MouseAdapter()
        {
            public void mousePressed(MouseEvent e)
            {
                Iterator<Key> it = m.getKeys();
                while(it.hasNext())
                {
                    Key tmp = it.next();
                    if(tmp.contains(e.getPoint()))
                    {
                        tmp.play();
                        System.out.println("Play Sound");
                    }
                }
            }
        };
    }
    
    private Model m;
    private View v;
}
