package aoop;
/**
 * datatype for samples
 * @author Daniel and erik
 */
public class Sample{

    /**
     * constructor
     * @param s sample
     */
    public Sample(double[] s){
            samples = s;
    }
    /**
     * returns sample in array
     * @return array sample
     */
    public double[] toArray(){
            return samples.clone();
    }
    
    double[] samples;
}

