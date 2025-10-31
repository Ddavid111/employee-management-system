package main;

import java.util.Iterator;

public interface ListIterator<T> {

    T getNextElement();
    T getCurrentElement();
    boolean hasMoreElement();
    void resetIterator();
}
