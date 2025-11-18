package it.unibo.mvc;

import java.io.File;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    private File currentFile;

    public void setCurrentFile(final File file){
        this.currentFile = file;
    }

    public File getCurrentFile(){
        return this.currentFile;
    }
}
