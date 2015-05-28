package aoop;
/**
 * Interface for filterable sounds
 * @author Daniel and Erik
 */
public interface FilterableSound{
        
    /**
     * Returns soundsample
     * @return Sample of sound
     */
    public Sample generateSample();
    
    /**
     * Plays sound
     */
    public void play();
    
    /**
     * Adds a filter
     * @param f filter to be added
     */
    public void addFilter(Filter f);
    
    /**
     * Returns duration of the sound
     * @return duration
     */
    public double getDuration();
    
}

