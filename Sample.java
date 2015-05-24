package aoop;

public class Sample{
	double[] samples;
	public Sample(double[] s){
		samples = s;
	}
	public double[] toArray(){
		return samples.clone();
	}
}

