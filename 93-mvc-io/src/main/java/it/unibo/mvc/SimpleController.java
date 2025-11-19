package it.unibo.mvc;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 *
 */
public final class SimpleController implements Controller {

    private String nextString = new String();
    private List<String> history = new ArrayList<>();

    public void setNextString(final String s) {
        if (s == null) {
            throw new NullPointerException();
        }

        this.nextString = s;
    }

    public String getNextString() {
        return this.nextString;
    }

    public List<String> getHistory() {
        return this.history;
    }

    public void printCurrentString() {
        final String s = getNextString();
        if (s == null) {
            throw new IllegalStateException();
        }
        System.out.println(s);
        this.history.add(s);
    }

}
