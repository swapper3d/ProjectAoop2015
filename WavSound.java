package aoop;

/**
 * Extension of Sound class
 * for imported wavfiles
 * @author Daniel and Erik
 */
public class WavSound extends Sound{

    /**
     * Constructor
     * @param s soundsamples
     */
    public WavSound(Sample s)
    {
        sample = s;
    }
    /**
     * returns samples
     * @return sample
     */
    @Override
    public Sample generateSample() {
        return sample;
    }
    private Sample sample;
}
