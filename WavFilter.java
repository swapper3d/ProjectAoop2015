/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aoop;

import java.io.File;
import javax.swing.filechooser.*;

/**
 *
 * @author Daniel
 */
public class WavFilter extends FileFilter{

    @Override
    public boolean accept(File f) {
        if(f.isDirectory())
        { return true;}
        String extension = f.getName();
        
        int i = extension.lastIndexOf('.');
        if (i > 0) {
            extension = extension.substring(i+1);
        }
        return extension.equalsIgnoreCase("wav");
    }

    @Override
    public String getDescription() {
        return "*.wav";
    }
    
}
