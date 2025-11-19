package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Controller is used to manage a file.
 */

public class Controller {
    private static final String PATH = System.getProperty("user.home")
    + File.separator
    + "output.txt";

    private File file;

    /**
     * The default constructor.
     */
    public Controller() {
        final Path path = Paths.get(PATH);
        this.file = path.toFile();
    }

    /**
     * This method sets a file as current file.
     * 
     * @param newfile the file you want to add to the Controller
     * 
     */
    public void setCurrentFile(final File newfile) {
        this.file = newfile;
    }

    /**
     * This method returns the current file.
     * 
     * @return the current file of the controller
     */
    public File getCurrentFile() {
        return this.file;
    }

    /**
     * This method gets the path of the current file.
     * 
     * @return the path of the file
     */
    public String getCurrentPath() {
        return file.getAbsolutePath();
    }

    /**
     * This method saved the path in the same file.
     */
    public void saveCurrentPath() throws IOException {
        final PrintStream ps = new PrintStream(this.file, StandardCharsets.UTF_8);
        ps.print(this.file.getAbsolutePath());
        ps.close();
    }
}
