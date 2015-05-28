/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aoop;

/**
 * Extension of interface filter
 * For filters using one scale
 * @author Daniel and Erik
 */
public interface ScalableFilter extends Filter {
    public void setScale(double scale);
}
