package it.unibo.mvc;

import java.util.List;

/**
 * Controller interface.
 */
public interface Controller {
    /**
     * Sets the next string to print.
     *
     * @param s the next string
     */
    void setNextString(String s);

    /**
     * Gets the next string to print.
     *
     * @return the next string
     */
    String getNextString();

    /**
     * Gets the history of the printed strings.
     *
     * @return the history of the printed strings
     */
    List<String> getHistory();

    /**
     * Prints the current string.
     */
    void printCurrentString();
}
