/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aoop;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author Daniel
 */
public class View extends JFrame
{
    public View()
    {}
    
    public void addModel(Model m)
    {
        this.m = m;
    }
    
    public void addController(Controller c)
    {
        this.c = c;
    }
    
    public void build()
    {
        ToolBar toolBar = new ToolBar(m);
        toolBar.addMouseListener(c.getMenuPressed());
        Menu menu = new Menu(m, c);
        MainFrame main = new MainFrame(m);
        main.addMouseListener(c.getKeyPressed());
        setTitle("MUSIC");
        
        setJMenuBar(menu);
        setLayout(new BorderLayout());
        add(toolBar,BorderLayout.NORTH);
        add(main, BorderLayout.CENTER);
        
        toolBar.addSound( new SoundIcon( Color.BLACK, new Dimension(40,40) ) );
        toolBar.addSound( new SoundIcon( Color.RED, new Dimension(40,40) ) );
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        pack();
        toolBar.repaint();
        setVisible(true);
    }
    
    private Model m;
    private Controller c;
    public final int FRAME_WIDTH = 640;
    public final int FRAME_HEIGHT = 480;
}
