/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aoop;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
/**
 *
 * @author Daniel
 */
public class ToolBar extends JPanel{
    
    public ToolBar(Model m, Controller c)
    {
        this.m = m;
        this.c = c;
        setLayout(new FlowLayout());
        //sounds = new LinkedList<>();
        this.setPreferredSize(new Dimension(50,50));
    }
    
    public void addFilter(Filter f)
    {
        
    }
    public void addFilter(ScalableFilter f)
    {
        JButton newButton = new JButton();
        newButton.setText(f.getName());
        newButton.setPreferredSize(new Dimension(60,40));
        newButton.addActionListener( c.getScalableFilterMenuListener(f) );
        //m.addFilter(f);
        this.add(newButton);
    }
     
   private final Model m;
   private final Controller c;
}
