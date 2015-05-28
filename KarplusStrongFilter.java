package aoop;


import java.util.LinkedList;
/**
 *
 * @author Erik and Daniel
 */
public class KarplusStrongFilter implements Filter{

    public KarplusStrongFilter()
    {}
    
    /**
     * Configures filter to l and d
     * rescales d to (d-1)/100
     * rescales l to l/10
     * @param l length range 0-> 100
     * @param d damping range 0->100
     */
    public void setScale(int l, double d){
        d --;
        d/=100;
        l /=10;
        length = l;
        if(d< 1.0)
            damping = d;
        else 
            damping = 0.99;
        
        System.out.println(damping);
    }
    
    /**
     * Applies filter to Sample s
     * @param s sound sample to filter
     * @return
     */
    @Override
    public Sample apply(Sample s) 
    {
        LinkedList<Double> Q1 = new LinkedList<>();
        LinkedList<Double> Q2 = new LinkedList<>();
        double[] output = new double[length*44100];
        Q2.add(0.0);

        for(double d:s.toArray())
        {
            Q1.add(d);
        }
        for(int m = 0; m<length*44100;m++)
        {
           double a = Q1.remove();
           double o = damping* (a + Q2.remove())/2;
           Q1.add(o);
           Q2.add(a);
           output[m] = (o);
        }
        return new Sample(output);
    }
         
    /**
     * Name of filter
     * @return name of filter
     */
    @Override
    public String getName()
    {
        return "Karplus filter";
    }
    
    private int length;
    private double damping;
    
}

