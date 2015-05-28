package aoop;
/**
 *  This is a interface for a general filter
 * @author Daniel and Erik
 */
public interface Filter{
        
	public Sample apply(Sample s);
        public String getName();
        
}
