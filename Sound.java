package aoop;

import java.util.ArrayList;
/**
 * Abstract class sound
 * Implements basic functions used by a filterable sound
 * @author Daniel and Erik
 */
public abstract class Sound implements FilterableSound{
 
    /**
     * default constructor. Initializes filter list
     */
    public Sound(){
        filters = new ArrayList();
    }
    
    /**
     * Plays the sound
     */
    @Override
    public void play(){
        sample = generateSample();
        applyFilters();
        duration = sample.toArray().length/SAMPLING_RATE;
        StdAudio.play(sample.toArray());
    }

    /**
     * adds a filter to the list
     * @param f filter
     */
    public void addFilter(Filter f){
        filters.add(f);
    }

    /**
     * applies all filters
     */
    private void applyFilters(){
        for(Filter f : filters){
            sample = f.apply(sample);
        }
    }

    /**
     * Return the duration of the sound
     * @return 
     */
    public double getDuration(){
            return duration;	
    }
    public double[] getSample()
    {
        sample = generateSample();
        applyFilters();
        return sample.toArray();
    }
    
    private double duration;
    public final int SAMPLING_RATE = StdAudio.SAMPLE_RATE;
    private Sample sample;
    private final ArrayList<Filter> filters;
    
}

