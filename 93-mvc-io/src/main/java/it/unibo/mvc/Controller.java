package it.unibo.mvc;

import java.util.List;

/**
 * Controller interface.
 */
public interface Controller {
    void setNextString(final String s);

    String getNextString();

    List<String> getHistory();

    void printCurrentString();
}
