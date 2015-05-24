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
public class MusicMaker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Model m = new Model();
        Controller c = new Controller();
        View v = new View();
        m.addController(c);
        m.addView(v);
        c.addModel(m);
        c.addView(v);
        v.addModel(m);
        v.addController(c);
        v.build();
    }
    
}
