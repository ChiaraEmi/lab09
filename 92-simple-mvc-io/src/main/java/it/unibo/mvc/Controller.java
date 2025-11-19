package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    private static final String PATH = System.getProperty("user.home")
            + System.getProperty("file.separator")
            + "output.txt";
    private File currentFile = new File(PATH);

    /**
     * Sets a new file as current file.
     * 
     * @param file The new file to set as the current file.
     */
    public void setCurrentFile(final File file) {
        this.currentFile = file;
    }

    /**
     * Returns the current file.
     * 
     * @return Returns the current file.
     */
    public File getCurrentFile() {
        return this.currentFile;
    }

    /**
     * Returns the current file path.
     * 
     * @return Returns the current file path.
     */
    public String getFilePath() {
        return this.currentFile.getPath();
    }

    /**
     * Saves a text on the current file.
     * 
     * @param text The text that will be saved on the current file.
     */
    public void saveString(final String text) throws IOException {
        try (PrintStream ps = new PrintStream(currentFile, StandardCharsets.UTF_8)) {
            ps.print(text);
        }
    }
}
