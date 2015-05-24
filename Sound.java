package aoop;

public abstract class Sound implements FilterableSound{
	private double duration;
	public int SAMPLING_RATE;
	private Sample sample = null;
	//private ArrayList
	
	public void play(){
		if(sample != null)
			StdAudio.play(sample.toArray());
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

