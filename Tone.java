package aoop;

/**
 * A simple tone
 * @author Erik and Daniel
 */

public class Tone extends Sound{
    
    /**
     * creates a tone with frequency freq and duration
     * @param freq
     * @param d 
     */
    public Tone(double freq, double d){
        frequency = freq;
        duration = d;
    }
    
    /**
     * generates Sample
     * @return Sample with sound
     */
    @Override
    public Sample generateSample() {
        int l = (int)(SAMPLING_RATE*duration);
        double[] tone = new double[l];
        
        for (int i = 0; i < l; i++) {
            tone[i] = (0.5 * Math.sin(2*Math.PI * frequency * i / SAMPLING_RATE));
        }
        return new Sample(tone);
    }
    
    private double frequency;
    private double duration;    
}
