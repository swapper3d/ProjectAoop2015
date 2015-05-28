package aoop;

public class GainFilter implements ScalableFilter{
	private double gain;
	public GainFilter(){
            
	}
        /**
         * sets scale of filter
         * @param scale Value of 0 to 100
         */
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
	public Sample apply(Sample s){
            
            double[] d = s.toArray();
            for(int i = 0; i < d.length; i++){
                d[i] *= gain;
            }
            return new Sample(d);
	}
        public String getName()
        {
            return "Gain";
        }
}
