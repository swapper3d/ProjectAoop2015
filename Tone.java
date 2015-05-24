/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aoop;

/**
 *
 * @author erik
 */

public class Tone extends Sound{
    private double frequency;
    private double duration;
    public Tone(double freq, double d){
        frequency = freq;
        duration = d;
    }
    @Override
    public Sample generateSample() {
        int l = (int)(SAMPLING_RATE*duration);
        double[] tone = new double[l];
        
        for (int i = 0; i < l; i++) {
            tone[i] = (0.5 * Math.sin(2*Math.PI * frequency * i / SAMPLING_RATE));
        }
        return new Sample(tone);
    }
    
}
