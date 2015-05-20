/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aoop;


import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author Daniel
 */
public class Menu extends JMenuBar
{
    public Menu()
    {
        menu = new JMenu("File");
        newSound = new JMenuItem("New Sound");
        exit = new JMenuItem("Exit");
        add(menu);
        
        menu.add(newSound);
        menu.add(exit);
        exit.addActionListener(e ->    System.exit(0));
    }
    
    private JMenu menu;
    private JMenuItem newSound;
    private JMenuItem exit;
    
}
