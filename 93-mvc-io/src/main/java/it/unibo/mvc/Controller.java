package it.unibo.mvc;

import java.util.List;

/**
 * Controller respondible of I/O access able to print on STDOUT.
 */
public interface Controller {

    /**
     * This method sets the next string in the list.
     * 
     * @param nextString is the next string of the list
     */
    void setNext(String nextString);

    /**
     * This method returns the next string in the list.
     * 
     * @return the next string in the list
     */
    String getNext();

    /**
     * This method returns the history of all the strings used.
     * 
     * @return the List of all the Strings
     */
    List<String> getHistory();

    /**
     * This method prints the current string.
     */
    void printCurrent();
}
