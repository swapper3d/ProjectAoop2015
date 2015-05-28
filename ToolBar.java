
package aoop;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
/**
 * Toolbar menu
 * @author Daniel and Erik
 */
public class ToolBar extends JPanel{
    
    /**
     * Constructor
     * @param m model of mvc
     * @param c controller of mvc
     */
    public ToolBar(Model m, Controller c)
    {
        this.m = m;
        this.c = c;
        setLayout(new FlowLayout());
        //sounds = new LinkedList<>();
        this.setPreferredSize(new Dimension(50,50));
    }
    
    /**
     * Adds a filter to the menu
     * @param f filter to add
     * @param l Actionlistener to handle buttonpress
     */
    public void addFilter(Filter f, ActionListener l)
    {
        JButton newButton = new JButton();
        newButton.setText(f.getName());
        newButton.setPreferredSize(new Dimension(60,40));
        newButton.addActionListener(l);
        add(newButton);
    }
    
    /**
     * Adds a acalable filter to the menu
     * @param f scalable filter to add
     */
    public void addFilter(ScalableFilter f)
    {
        this.addFilter(f, c.getScalableFilterMenuListener(f));
    }
     
    
    private final Model m;
    private final Controller c;
}
