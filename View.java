/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aoop;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Daniel
 */
public class View extends JFrame
{
    public View(Model m, Controller c)
    {
        model = m;
        controller = c;
    }
    
    public void addModel(Model m)
    {
        model = m;
    }
    
    public void addController(Controller c)
    {
        controller = c;
    }
    
    public void build()
    {
        ToolBar toolBar = new ToolBar();
        Menu menu = new Menu();
        JPanel main = new JPanel();
        main.setBorder(BorderFactory.createEtchedBorder());
        setTitle("MUSIC");
        
        setJMenuBar(menu);
        setLayout(new BorderLayout());
        add(toolBar,BorderLayout.NORTH);
        add(main, BorderLayout.CENTER);
        
        //adding standard sounds
        toolBar.add(new SoundIcon());
        toolBar.add(new SoundIcon());
        toolBar.add(new SoundIcon());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        pack();
        setVisible(true);
    }
    
    private Model model;
    private Controller controller;
    public final int FRAME_WIDTH = 640;
    public final int FRAME_HEIGHT = 480;
}
