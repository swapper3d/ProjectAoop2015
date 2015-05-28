/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aoop;


import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

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
        //soundMenu = new JMenu();
        newTone.addActionListener(c.getNewSoundListener()); 
        browse.addActionListener(c.getBrowseDiskListener());
        save.addActionListener(c.getSaveFileListener());
        newSound.add(browse);
        newSound.add(save);
        newSound.add(newTone);
        add(menu);
        
        menu.add(newSound);
        menu.add(settings);
        menu.add(exit);
        
        
        //newSound.addActionListener(c.newSound());
        settings.addActionListener(c.settings());
        exit.addActionListener(c.menuExit());
    }
    
    private JMenu menu;
    //private JMenu soundMenu;
    
    private JMenuItem newSound;
    private JMenuItem exit;
    private JMenuItem settings;
    
    private JMenuItem newTone;
    private JMenuItem browse;
    private JMenuItem save;
    
    private Model m;
    private Controller c;
    
}
