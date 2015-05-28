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
    public Menu(final Model m, final Controller c)
    {
        this.m = m;
        this.c = c;
        menu = new JMenu("File");
        newSound = new JMenu("New Sound");
        settings = new JMenuItem("Settings");
        exit = new JMenuItem("Exit");
        newTone = new JMenuItem("New Tone");
        browse = new JMenuItem("Browse disk..");
        save = new JMenuItem("Save as..");
        
        newTone.addActionListener(c.getNewToneListener()); 
        browse.addActionListener(c.getBrowseDiskListener());
        save.addActionListener(c.getSaveFileListener());
        newSound.add(browse);
        
        newSound.add(newTone);
        add(menu);
        
        menu.add(newSound);
        menu.add(save);
        menu.add(exit);
        
        exit.addActionListener(c.menuExitListener());
    }
    
    private final JMenu menu;
    
    private final JMenuItem newSound;
    private final JMenuItem exit;
    private final JMenuItem settings;
    
    private final JMenuItem newTone;
    private final JMenuItem browse;
    private final JMenuItem save;
    
    private final Model m;
    private final Controller c;
    
}
