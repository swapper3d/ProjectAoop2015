/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aoop;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.text.NumberFormat;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.NumberFormatter;

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
        newSound = buildNewSoundFrame(); 
        //newSound.setPreferredSize(new Dimension(200,100));
        
        /* Adding components to frame */
        add(toolBar,BorderLayout.NORTH);
        add(main, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
        
        /* Adding filters to menu */
        toolBar.addFilter(new GainFilter());
        pack();
        toolBar.repaint();
        setVisible(true);
        
        
        pack();
    }
    
    private JFrame buildNewSoundFrame()
    {
        JFrame frame = new JFrame();
        JButton create = new JButton("Create sound");
        NumberFormat format = NumberFormat.getNumberInstance();
        JFormattedTextField dur = new JFormattedTextField(format);
        JFormattedTextField freq = new JFormattedTextField(format);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        frame.setTitle("New Sound");
        
        create.addActionListener(this.c.getNewToneListener( freq, 
                                                            dur
                                                           ));
        
        c.gridx = 0;
        c.gridy = 0;
        frame.add(new JLabel("frequency"),c);
        c.gridx = 1;
        c.ipadx = 80;
        frame.add(freq,c);
        c.gridx = 0;
        c.gridy = 1;
        c.ipadx = 0;
        frame.add(new JLabel("duration"),c);
        c.gridx = 1;
        c.ipadx = 80;
        frame.add(dur,c);
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 2;
        frame.add(create,c);
        frame.pack();
        return frame;
    }
    
    public void showSlider(/*JComponent component*/)
    {
        popup.show(toolBar, 0, 50);
    }

    public void showNewSound()
    {
        newSound.setVisible(true);
    }
    
   
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
 /**
     * adds filter. needs build() to have been done
     * @param f filter to be added
     */
    /*public void addFilter(Filter f)
    {
        //toolBar.addFilter(f);
        //pack();
    }*/
 /*public void showBrowser()
    {
        
    }*/
   /* public void setSliderFilter(Filter f)
    {
        
    }
    */