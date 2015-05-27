package aoop;

public class GainFilter implements ScalableFilter{
	private double gain;
	public GainFilter(){
            
	}
        public void setScale(double scale)
        {
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
