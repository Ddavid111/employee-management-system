package main;

import java.util.Iterator;

public interface ListIterator<T> {

    T getNext();
    T getCurrentElement();
    boolean hasMore();
    void resetIterator();
}
