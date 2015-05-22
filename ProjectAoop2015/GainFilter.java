public class GainFilter implements Filter{
	private double gain;
	public GainFilter(double g){
		gain = g;
	}
	public Sample apply(Sample s){
		return s;
	}
}

