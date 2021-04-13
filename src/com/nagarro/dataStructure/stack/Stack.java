package com.nagarro.dataStructure.stack;

import java.util.Iterator;

public interface Stack<X> {
    void push(X item);

    X pop();

    X peek();

    boolean contains(X item);

    int size();

    void reverse();

    void print();

    Iterator<X> iterator();
}
