package aoop;

import java.util.ArrayList;

public abstract class Sound implements FilterableSound{

    private double duration;
    public final int SAMPLING_RATE = StdAudio.SAMPLE_RATE;
    private Sample sample;
    private final ArrayList<Filter> filters;
    
    
    public Sound(){
        filters = new ArrayList();
    }
    @Override
    public void play(){
        sample = generateSample();
        applyFilters();
        duration = sample.toArray().length/SAMPLING_RATE;
        StdAudio.play(sample.toArray());
    }

    public void addFilter(Filter f){
        filters.add(f);
    }

    private void applyFilters(){
        for(Filter f : filters){
            sample = f.apply(sample);
        }
    }

    public double getDuration(){
            return duration;	
    }
    public double[] getSample()
    {
        return generateSample().toArray();
    }
}

