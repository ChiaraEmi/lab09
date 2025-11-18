package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import javax.swing.JOptionPane;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    private static final String PATH = System.getProperty("user.home")
            + File.separator
            + "output.txt";
    private File currentFile;

    Controller() {
        this.currentFile = new File(PATH);
    }

    public void setCurrentFile(final File file) {
        this.currentFile = file;
    }

    public File getCurrentFile() {
        return this.currentFile;
    }

    public String getFilePath (final File file) {
        return this.currentFile.getPath();
    }

    public void saveString (final String text) throws IOException {
        try (PrintStream ps = new PrintStream(currentFile, StandardCharsets.UTF_8)) {
            ps.print(text);
        }
    }
}
