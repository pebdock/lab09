package it.unibo.mvc;

import java.util.ArrayList;

/**
 * A simple controller responsible of I/O access.
 * It considers only the standard output, and it is able to print on it.
 */
public final class SimpleController implements Controller {

    @Override
    public void setNext(final String nextString) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setNext'");
    }

    @Override
    public String getNext() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNext'");
    }

    @Override
    public ArrayList<String> getHistory() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getHistory'");
    }

    @Override
    public void printCurrent() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'printCurrent'");
    }

}
