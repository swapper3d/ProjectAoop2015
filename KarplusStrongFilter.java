package aoop;

import java.util.ArrayDeque;
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author erik
 */
public class KarplusStrongFilter implements Filter{
    int length;
    double damping;
    
    public KarplusStrongFilter(int l, double d){
        length = l;
        if(damping < 1.0)
            damping = d;
        else 
            damping = 0.99;
    }
    
    @Override
    public Sample apply(Sample s) {
        //funkar riktigt dåligt.. pseudokod http://courses.cs.washington.edu/courses/cse373/12au/homework/hw01/karplus_strong.shtml
        LinkedList<Double> Q1 = new LinkedList();
        LinkedList<Double> Q2 = new LinkedList();
        double[] d = s.toArray();
        for(Double e : d){
            Q1.add(e);
        }
        Q2.add(0.0);
        Double a,b;
        for(int m = 0; m < length*44100; m++){
            a = Q1.remove();
            b = Q2.remove();
            Double c = damping * (double)a*b/2;    //average
            Q1.add(c);
            Q2.add(a);
        }
        double[] bb = new double[Q1.size()];
        for(int i = 0; !Q1.isEmpty(); i++){
            d[i] = Q1.remove();
        }
        return new Sample(d);
    }  
}

