package aoop;
/**
 * Gain filter. modifies amplitude of sound
 * @author Erik and Daniel
 */
public class GainFilter implements ScalableFilter{
	
        /**
         * sets scale of filter
         * rescales to scale/33
         * @param scale Value of 0 to 100
         */
        @Override
        public void setScale(double scale)
        {
            scale /= 33;
            if(scale >= 0)
            {    
		gain = scale;
            }
            else
            {
                gain = 0.0;
            }
        }
        
    /**
     * Applies filter to Sample s
     * @param s sound sample to filter
     * @return
     */
    @Override
    public Sample apply(Sample s){

        double[] d = s.toArray();
        for(int i = 0; i < d.length; i++){
            d[i] *= gain;
        }
        return new Sample(d);
    }
    
    /**
     * Name of filter
     * @return name of filter
     */
    public String getName()
    {
        return "Gain";
    }
    
    private double gain;
}
