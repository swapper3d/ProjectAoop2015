package aoop;

import java.io.File;
import javax.swing.filechooser.*;

/**
 * Filters out all files but .wav
 * @author Daniel and Erik
 */
public class WavFilter extends FileFilter{

    /**
     * Sets which files to be accepted
     * @param f file to be checked
     * @return if file is .wav or not
     */
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

    /**
     * Description
     * @return description of file
     */
    @Override
    public String getDescription() {
        return "*.wav";
    }
    
}
