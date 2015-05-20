/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aoop;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JPanel;

/**
 *
 * @author Daniel
 */
public class ToolBar extends JPanel{
    public ToolBar()
    {
        setLayout(new FlowLayout());
        

    }
    
    void addSound(SoundIcon s)
    {
        add(s);
    }
}
