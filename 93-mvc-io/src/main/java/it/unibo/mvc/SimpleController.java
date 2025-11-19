package it.unibo.mvc;

/**
 * 
 *
 */
public final class SimpleController implements Controller {

    private String nextString = new String();

    public void setNextString(final String s) {
        if (s == null) {
            throw new NullPointerException();
        }

        this.nextString = s;
    }

    public String getNextString() {
        return this.nextString;
    }
    
    @Override
    public void print(String text) {
        System.out.println(text);
    }

}
