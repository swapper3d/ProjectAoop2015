package aoop;

public abstract class Sound implements FilterableSound{
	private double duration;
	public int SAMPLING_RATE = StdAudio.SAMPLE_RATE;
	private Sample sample;
	//private ArrayList
	
	public void play(){
                sample = generateSample();
		if(sample != null)
			StdAudio.play(sample.toArray());
                else
                    System.out.println("null sound output");
	}
	public void addFilter(Filter f){

	}
	private void applyFilters(){

	}
	public void setSample(Sample s){
		sample = s;
	}
	public double getDuration(){
		return 0.0;	
	}
}

