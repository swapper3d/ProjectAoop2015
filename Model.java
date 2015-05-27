/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aoop;

import java.util.Iterator;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class Model {
    
    public Model()
    {
       sound = new Tone(600,0.2);
    }
    
    public void addController(Controller c)
    {
        this.c = c;
    }
    
    public void addView(View v)
    {
        this.v = v;
    }
    
    
    public void addFilter(Filter f) {
        filters.add(f);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void setCurrentFilter(Filter f)
    {curFilter = f;};
    
    public Filter getCurrentFilter()
    {
        return curFilter;
    }
    
    public Sound getSound()
    {
        return sound;
    }
    
    private Sound sound;
    private Filter curFilter;
    private ArrayList<Filter> filters;
    private Controller c;
    private View v;
    public int KEYBOARD_SIZE = 10;

    
}
