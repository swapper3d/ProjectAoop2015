public class WhiteNoise extends Sound{
	private double duration;
	public WhiteNoise(double d){
		duration = d;
	}
	public Sample generateSample(){
		double f = 44100*duration;
		int j = (int)f;
		double[] temp = new double[j];
		for(int i = 0; i < j; i++){
			temp[i] = Math.random();
		}
		setSample(new Sample(new double[0]));
		return new Sample(new double[0]);
	}
}

