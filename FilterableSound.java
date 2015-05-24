package aoop;

public interface FilterableSound{
	public Sample generateSample();
	public void play();
	public void addFilter(Filter f);
	public double getDuration();
}

