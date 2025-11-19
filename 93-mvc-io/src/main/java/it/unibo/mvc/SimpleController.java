package it.unibo.mvc;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 *
 */
public final class SimpleController implements Controller {

    private String nextString;
    private final List<String> history = new ArrayList<>();

    @Override
    public void setNextString(final String s) {
        if (s == null) {
            throw new IllegalArgumentException();
        }

        this.nextString = s;
    }

    @Override
    public String getNextString() {
        return this.nextString;
    }

    @Override
    public List<String> getHistory() {
        return List.copyOf(this.history);
    }

    @Override
    public void printCurrentString() {
        final String s = getNextString();
        if (s == null) {
            throw new IllegalStateException();
        }
        System.out.println(s); //NOPMD suppressed as it has to be printed in output
        this.history.add(s);
    }

}
