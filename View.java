/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aoop;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

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
    
    /**
     * adds filter. needs build() to have been done
     * @param f filter to be added
     */
    /*public void addFilter(Filter f)
    {
        //toolBar.addFilter(f);
        //pack();
    }*/
    
    public void build()
    {
        /* Initializing components */
        toolBar = new ToolBar(m, c);
        popup = new JPopupMenu();
        apply = new JButton();
        Menu menu = new Menu(m, c);
        MainFrame main = new MainFrame(m);
        JButton play = new JButton();
        JPanel southPanel = new JPanel();
        southPanel.add(play);
        /* Configuring frames */
        setJMenuBar(menu);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        setTitle("Sound Filtering");
        
        /* setting up scale popup */
        apply.setText("apply");
        play.addActionListener(c.getPlayListener());
        play.setText("PLAY");
        scaleSlider = new JSlider();
        scaleSlider.setBorder( new CompoundBorder(new TitledBorder("Scale"),
                               new EmptyBorder(10, 10, 10, 10) )
                             );
        apply.addActionListener(c.getApplyFilter(scaleSlider));
        popup.add(scaleSlider);
        popup.add(apply);
        
        /*Building new Sound frame */
        newSound = new JFrame();
        newSound.setLayout(new FlowLayout());
        newSound.setTitle("New Sound");
        newSound.add(new JTextField("value"));
        newSound.add(new JButton("Create sound"));
        newSound.pack();
        //newSound.setPreferredSize(new Dimension(200,100));
        
        /* Adding components to frame */
        add(toolBar,BorderLayout.NORTH);
        add(main, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
        
        /* Adding filters to menu */
        toolBar.addScaleableFilter(new GainFilter());
        pack();
        toolBar.repaint();
        setVisible(true);
        
        
        pack();
    }
    
    
    public void showSlider(/*JComponent component*/)
    {
        popup.show(toolBar, 0, 50);
    }
    public void setSliderFilter(Filter f)
    {
        
    }
    public void showNewSound()
    {
        newSound.setVisible(true);
    }
    
    /*public void showBrowser()
    {
        
    }*/
    private Model m;
    private Controller c;
    private JFrame newSound;
    private ToolBar toolBar;
    private JPopupMenu popup;
    private JSlider scaleSlider;
    private JButton apply;
    
    public final int FRAME_WIDTH = 640;
    public final int FRAME_HEIGHT = 480;
}
