/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aoop;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.text.NumberFormat;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JSlider;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
 * View of MVC pattern
 * @author Daniel and Erik
 */
public class View extends JFrame
{
    public View()
    {}
    
    /**
     * adds Model of MVC pattern
     * @param m model
     */
    public void addModel(Model m)
    {
        this.m = m;
    }
    
    /**
     * adds Controller of MVC pattern
     * @param c Controller
     */
    public void addController(Controller c)
    {
        this.c = c;
    }
    
   
    /**
     * Builds view
     */
    public void build()
    {
        /* Initializing components */
        toolBar = new ToolBar(m, c);
        popup = new JPopupMenu();
        apply = new JButton();
        wNPopup = new JPopupMenu();
        wNSlider = new JSlider();
        wNApply = new JButton("Create White Noise");
        Menu menu = new Menu(m, c);
        JPanel main = new JPanel();
        main.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED) );
        JButton play = new JButton();
        JPanel southPanel = new JPanel();
        southPanel.add(play);
        
        /* Configuring frames */
        setJMenuBar(menu);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        setTitle("Sound Filtering");
        
        /* setting up scalable filter popup */
        apply.setText("apply");
        play.addActionListener(c.getPlayListener());
        play.setText("PLAY");
        scaleSlider = new JSlider();
        scaleSlider.setBorder( new CompoundBorder(new TitledBorder("Scale"),
                               new EmptyBorder(10, 10, 10, 10) )
                             );
        apply.addActionListener(c.getApplyScalableFilterListener(scaleSlider));
        popup.add(scaleSlider);
        popup.add(apply);
        
        buildKarplusView();
        /* setting up create white noise popup */
        wNPopup.add(wNSlider);
        wNPopup.add(wNApply);
        wNSlider.setBorder( new CompoundBorder(
                                  new TitledBorder("Duration"),
                                  new EmptyBorder(10, 10, 10, 10) )
                                );
        wNApply.addActionListener(c.getCreateWhiteNoise(wNSlider));
        /*Building new Sound frame */
        newSound = buildNewToneFrame(); 
        
        /* Adding components to frame */
        add(toolBar,BorderLayout.NORTH);
        add(main, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
        
        /* Adding filters to menu */
        toolBar.addFilter(new GainFilter());
        Filter f = new KarplusStrongFilter();
        toolBar.addFilter(f, c.getKarplusStrongfilterListener(f));
        pack();
        setVisible(true);

    }
    
    
    /**
     * Builds frame for creating a tone
     * @return 
     */
    private JFrame buildNewToneFrame()
    {
        JFrame frame = new JFrame();
        JButton create = new JButton("Create sound");
        NumberFormat format = NumberFormat.getNumberInstance();
        JFormattedTextField dur = new JFormattedTextField(format);
        JFormattedTextField freq = new JFormattedTextField(format);
        
        /* sets up the layout */
        frame.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        frame.setTitle("New Sound");
        
        create.addActionListener(this.c.getCreateNewToneListener(   freq, 
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
    
    /**
     * Builds popup for karplus filter
     */
    public void buildKarplusView()
    {
        JSlider karplusLSlider = new JSlider();
        JSlider karplusDampSlider = new JSlider();
        JButton karplusApply = new JButton("Apply");
        kPopup = new JPopupMenu();
        
        
        karplusLSlider.setBorder( new CompoundBorder(
                                  new TitledBorder("length"),
                                  new EmptyBorder(10, 10, 10, 10) )
                                );
        karplusDampSlider.setBorder( new CompoundBorder(
                                     new TitledBorder("Damping"),
                                     new EmptyBorder(10, 10, 10, 10) )
                                    );
        karplusApply.addActionListener( c.getApplyKarplusFilterListener(
                                                            karplusLSlider, 
                                                            karplusDampSlider)
                                       );
        
        kPopup.add(karplusLSlider);
        kPopup.add(karplusDampSlider);
        kPopup.add(karplusApply);
    }
    
    /**
     *  Shows popup for creating white noise 
     */
    public void showWhiteNoiseSlider()
    {
        wNPopup.show(toolBar, 0, 50);
    }
    /**
     *  Shows popup for scalable filters 
     */
    public void showSlider()
    {
        popup.show(toolBar, 0, 50);
    }

    /**
     * Shows popup for karplus filter
     */
    public void showKarplus()
    {
        kPopup.show(toolBar,0,50);
    }
    
    /**
     * Shows new Tone frame
     */
    public void showNewTone()
    {
        newSound.setVisible(true);
    }
    
    
    
    
    private Model m;
    private Controller c;
    private JFrame newSound;
    private ToolBar toolBar;
    private JPopupMenu popup;
    private JSlider scaleSlider;
    private JSlider wNSlider;
    private JButton apply; 
    private JButton wNApply; 
    private JPopupMenu kPopup;
    private JPopupMenu wNPopup;
    
    public final int FRAME_WIDTH = 640;
    public final int FRAME_HEIGHT = 480;
}