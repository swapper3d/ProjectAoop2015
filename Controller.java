package aoop;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JSlider;

/**
 * Controller of MVC pattern
 * manages user input
 * @author Daniel and Erik
 */
public class Controller {
    
    /**
     * Constructor. Initializes filechooser
     */
    public Controller()
    {
        /* filechooser */
        fc = new JFileChooser();
        fc.setFileFilter(new WavFilter());
    }
    
    /**
     * Add view part of MVC pattern
     * @param v view
     */
    public void addView(View v)
    {
        this.v = v;
    }
    
     /**
     * Add model part of MVC pattern
     * @param m model
     */
    public void addModel(Model m)
    {
        this.m = m;
    }
    
    
    /**
     * ActionListener for play button
     * @return PlayHandler
     */
    public ActionListener getPlayListener()
    {
        return (ActionEvent e) -> {
            m.getSound().play();
        };
    }
    
    /**
     * ActionListener for scalable filters
     * @param f scalable filter
     * @return ScalableFilterHandler
     */
    public ActionListener getScalableFilterMenuListener(Filter f)
    {
        return (ActionEvent e) -> {
            m.setCurrentFilter(f);
            v.showSlider();
        };
    }
    
    /**
     * Apply scalable filter
     * @param scale JSlider scale
     * @return ApplyScalableHandler
     */
    public ActionListener getApplyScalableFilterListener(JSlider scale)
    {
        return (ActionEvent e) -> {
            ScalableFilter tmp = (ScalableFilter)m.getCurrentFilter();
            Sound s = m.getSound();
            tmp.setScale(((double)scale.getValue()));
            s.addFilter(tmp);
        };
    }
    
    /**
     *  Apply Karplus Strong filter
     * @param lSlider Length of filter
     * @param dampSlider Damping
     * @return Karplus Filter Handler
     */
    public ActionListener getApplyKarplusFilterListener(JSlider lSlider, 
                                                        JSlider dampSlider)
    {
        return (ActionEvent e) ->
        {
            KarplusStrongFilter tmp = (KarplusStrongFilter)m.getCurrentFilter();
            Sound s = m.getSound();
            tmp.setScale(lSlider.getValue(), dampSlider.getValue());
            s.addFilter(tmp);
        };
    }
    
    /**
     * Menu exit handler
     * @return 
     */
    public ActionListener menuExitListener()
    {
        return (ActionEvent e) -> 
        {
            System.exit(0);
        };
    }
   

    /**
     * Shows Dialoge new Tone
     * @return new Tone Handler
     */
    public ActionListener getNewToneListener()
    {
        return (ActionEvent e) ->
        {
            v.showNewTone();
        };
    }
    
    /**
     * Shows browse for file dialogue
     * @return browse handler
     */
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
    
    /**
     * Shows save file dialogue
     * @return save file handler
     */
    public ActionListener getSaveFileListener()
    {
        return (ActionEvent e) ->
        {
            int ret = fc.showSaveDialog(v);
            if (ret == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                StdAudio.save(file.getAbsolutePath(), m.getSample());
            }
        };
    }
    
    /**
     * Handles create button
     * Strings in freq and dur must be double
     * @param freq textfield containing frequency
     * @param dur  textfield containing duration
     * @return 
     */
    public ActionListener getCreateNewToneListener(JFormattedTextField freq, JFormattedTextField dur)
    {
        return (ActionEvent e) ->
        {
            String tmp = freq.getText().replace(",",".");
            tmp = tmp.replaceAll("\\s+", "");
            double f = Double.parseDouble(tmp);
            double d = Double.parseDouble(dur.getText().replace(",",".").replace(" ", ""));
            m.setSound( new Tone(f,d));
        };
    }
    
    /**
     * Handles Karplus filter menu item 
     * @param f karplus filter
     * @return Karplus filter handler
     */
    public ActionListener getKarplusStrongfilterListener(Filter f)
    {
        return (ActionEvent e) ->
        {
            m.setCurrentFilter(f);
            v.showKarplus();
        };
    }
       
    /**
     * field variables
     */
    private final JFileChooser fc;
    private Model m;
    private View v;
}
