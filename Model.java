/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aoop;

import java.util.ArrayList;

/**
 * Model of MVC pattern
 * Contains all data models
 * @author Daniel and Erik
 */
public class Model {
    
    /**
     * default constructor.
     * creates a tone
     */
    public Model()
    {
       sound = new Tone(600,0.2);
    }
    
    /**
     * Add controller part of MVC pattern
     * @param c controller
     */
    public void addController(Controller c)
    {
        this.c = c;
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
     * Sets current filter to f
     * @param f filter to use
     */
    public void setCurrentFilter(Filter f)
    {
        curFilter = f;
    }
    
    /**
     * Gets active filter
     * @return active filter
     */
    public Filter getCurrentFilter()
    {
        return curFilter;
    }
    
    /**
     * Gets current sound
     * @return current sound
     */
    public Sound getSound()
    {
        return sound;
    }
    
    /**
     * Sets current sound to s
     * @param s new sound
     */
    public void setSound(Sound s)
    {
        sound = s;
    }
    
    /**
     * Gets samples of current sound
     * @return current samples
     */
    public double[] getSample()
    {
        return sound.getSample();
    }
    
    /**
     * field variables
     */
    private Sound sound;
    private Filter curFilter;
    private Controller c;
    private View v;
}
