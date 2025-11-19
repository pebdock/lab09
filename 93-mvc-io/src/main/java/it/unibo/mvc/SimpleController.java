package it.unibo.mvc;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple controller responsible of I/O access.
 * It considers only the standard output, and it is able to print on it.
 */
public final class SimpleController implements Controller {

    private static PrintStream ps = System.out;
    private final List<String> stringList = new ArrayList<>();
    private String current;

    @Override
    public void setNext(final String nextString) {
        if (nextString.isBlank()) {
            throw new IllegalArgumentException("The String inserted is null");
        } else {
            this.current = nextString;
        }
    }

    @Override
    public String getNext() {
        return this.current;
    }

    @Override
    public ArrayList<String> getHistory() {
        return new ArrayList<>(this.stringList);
    }

    @Override
    public void printCurrent() {
        ps.println(this.current);
        this.stringList.add(this.current);
    }
}
