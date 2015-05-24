/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aoop;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class Model {
    
    public Model()
    {
        soundTypes = new LinkedList<>();
        keys = new ArrayList<>();
        for(int i = 0; i < 10 ; i++)
        {
            keys.add(new Key());
        }
        Sound t1 = new Tone(600.0, 0.2);
        keys.get(0).setSound(t1);
        Sound t2 = new Tone(200.0, 0.1);
        keys.get(1).setSound(t2);
        Sound w = new WhiteNoise(0.2);
        keys.get(2).setSound(w);
        
    }
    
    
    public Iterator<Key> getKeys()
    {
        return keys.iterator();
    }
    /*public Iterator<SoundIcon>[] getAllTracks()
    {
        Iterator[] it = {soundTrack[0].iterator(),
                         soundTrack[1].iterator(),
                         soundTrack[2].iterator(),
                         soundTrack[3].iterator()};
        
        return it;
    }
    
    public Iterator<SoundIcon> getTrack1()
    {
        return soundTrack[0].iterator();
    }
    
    public Iterator<SoundIcon> getTrack2()
    {
        return soundTrack[1].iterator();
    }
    
    public Iterator<SoundIcon> getTrack3()
    {
        return soundTrack[2].iterator();
    }
    
    public Iterator<SoundIcon> getTrack4()
    {
        return soundTrack[3].iterator();
    }*/
    
    public void addController(Controller c)
    {
        this.c = c;
    }
    
    public void addView(View v)
    {
        this.v = v;
    }
    
    public Iterator<SoundIcon> getTypes()
    {
        return soundTypes.iterator();
    }
    
    
    public int getTypeLength()
    {
        return soundTypes.size();
    }
    
    public void addType(SoundIcon s)
    {
        if(s != null)
        {
            soundTypes.add(s);
        }else
        {
            throw new NullPointerException();
        }
    }
    private final LinkedList<SoundIcon> soundTypes;
    private final ArrayList<Key> keys;
    private Controller c;
    private View v;
    public int KEYBOARD_SIZE = 10;
}
