/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aoop;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.Iterator;
import javax.swing.JFileChooser;
import javax.swing.JSlider;

/**
 *
 * @author Daniel
 */
public class Controller {
    
    public Controller()
    {
        /* filechooser */
        fc = new JFileChooser();
        fc.setFileFilter(new WavFilter());
    }
    public void addView(View v)
    {
        this.v = v;
    }
    public void addModel(Model m)
    {
        this.m = m;
    }
    
    
    public ActionListener getPlayListener()
    {
        return new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                m.getSound().play();
                System.out.println("PLAY");
            }
            
        };
    }
    
    /**
     *
     * @param f scaleable filter
     * @return handler for pressing the menuitem
     */
    public ActionListener getScaleableFilterMenuListener(Filter f)
    {
        return new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                m.setCurrentFilter(f);
                v.showSlider();
            }
            
        };
    }
    
    public ActionListener getApplyFilter(JSlider scale)
    {
        return new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                ScalableFilter tmp = (ScalableFilter)m.getCurrentFilter();
                Sound s = m.getSound();
                tmp.setScale(((double)scale.getValue()));
                s.addFilter(tmp);
                System.out.println(m.getCurrentFilter() + " applied");
                System.out.println(((double)scale.getValue()) + " scale");
            }
            
        };
    }
    

    
    public ActionListener menuExit()
    {
        return (ActionEvent e) -> 
        {
            System.exit(0);
        };
    }
    
    public ActionListener newSound()
    {
        return (ActionEvent e) -> 
        {
            v.showNewSound();
        };
    }
    
    public ActionListener settings()
    {
        return (ActionEvent e) -> 
        {
            System.exit(0);
        };
    }
    
    public ActionListener getNewSoundListener()
    {
        return (ActionEvent e) ->
        {
            v.showNewSound();
        };
    }
    
    public ActionListener getBrowseDiskListener()
    {
        return (ActionEvent e) ->
        {
            int ret = fc.showOpenDialog(v);
            if(ret == JFileChooser.APPROVE_OPTION)
            {
                //fc.setDialogTitle("Select file to load");
                File file = fc.getSelectedFile();
                Sample s = new Sample(StdAudio.read(file.toString()));
                m.setSound(new WavSound(s));
            }
        };
    }
    
    public ActionListener getSaveFileListener()
    {
        return (ActionEvent e) ->
        {
            int ret = fc.showSaveDialog(v);
            if (ret == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                StdAudio.save(file.getAbsolutePath(), m.getSample());
                System.out.println("Save as file: " + file.getAbsolutePath());
            }
        };
    }
    private JFileChooser fc;

    private Model m;
    private View v;
}


 /* public MouseListener getMenuDragged()
    {
        return new MouseAdapter()
        {
            @Override
            public void mouseDragged(MouseEvent e) 
            {
                System.out.println(e); 
            }
        };
    }
    
    public MouseListener getMenuPressed()
    {
        return new MouseAdapter() 
        {
            @Override
            public void mousePressed(MouseEvent e) 
            {
                Iterator<SoundIcon> it = m.getTypes();
                
                while(it.hasNext())
                {
                    SoundIcon tmp = it.next();
                    if( tmp.contains( e.getPoint() ) )
                    {
                        tmp.getPoint();//e.getPoint();
                        System.out.println("pressed in square");
                    }
                }
                System.out.println(e.getPoint()); 
            }
        };
    }
*/    
    /*public MouseListener getKeyPressed()
    {
        return new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent e)
            {
                Iterator<Key> it = m.getKeys();
                while(it.hasNext())
                {
                    Key tmp = it.next();
                    if(tmp.contains(e.getPoint()))
                    {
                        tmp.play();
                        System.out.println("Play Sound");
                    }
                }
            }
        };
    }*/