package aoop;

public class WhiteNoise extends Sound{
	private double duration;
	public WhiteNoise(double d){
		duration = d;
	}
        @Override
	public Sample generateSample(){
            int l = (int)(SAMPLING_RATE*duration);
            double[] tone = new double[l];

            for (int i = 0; i < l; i++) {
                tone[i] = Math.random();
            }
            return new Sample(tone);
	}
}

