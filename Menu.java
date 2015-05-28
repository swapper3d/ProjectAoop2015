
package aoop;


import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author Daniel and Erik
 */
public class Menu extends JMenuBar
{
    /**
     * Constructor. Sets up the menu
     * @param m Model of MVC
     * @param c Controller of MVC
     */
    public Menu(final Model m, final Controller c)
    {
        this.m = m;
        this.c = c;
        menu = new JMenu("File");
        newSound = new JMenu("New Sound");
        exit = new JMenuItem("Exit");
        newTone = new JMenuItem("New Tone");
        browse = new JMenuItem("Browse disk..");
        noise = new JMenuItem("White Noise");
        save = new JMenuItem("Save as..");
        
        newTone.addActionListener(c.getNewToneListener()); 
        browse.addActionListener(c.getBrowseDiskListener());
        save.addActionListener(c.getSaveFileListener());
        noise.addActionListener(c.getNewNoiseListener());
        newSound.add(browse);
        newSound.add(newTone);
        newSound.add(noise);
        add(menu);
        
        menu.add(newSound);
        menu.add(save);
        menu.add(exit);
        
        exit.addActionListener(c.menuExitListener());
    }
    
    private final JMenu menu;
    
    private final JMenuItem newSound;
    private final JMenuItem exit;
    private final JMenuItem noise;
    
    private final JMenuItem newTone;
    private final JMenuItem browse;
    private final JMenuItem save;
    
    private final Model m;
    private final Controller c;
    
}
