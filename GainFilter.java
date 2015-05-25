package aoop;

public class GainFilter implements Filter{
	private double gain;
	public GainFilter(double g){
            if(g >= 0)
		gain = g;
            else
                gain = 0.0;
	}
	public Sample apply(Sample s){
            double[] d = s.toArray();
            for(int i = 0; i < d.length; i++){
                d[i] *= gain;
            }
            return new Sample(d);
	}
}
