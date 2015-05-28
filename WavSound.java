/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aoop;

/**
 *
 * @author Daniel
 */
public class WavSound extends Sound{
    private Sample sample;
    
    public WavSound(Sample s)
    {
        sample = s;
    }
    @Override
    public Sample generateSample() {
        return sample;
    }
    
}
