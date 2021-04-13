package com.nagarro.dataStructure.queue;

import java.util.Iterator;

public interface Queue<X> {
    void enQueue(X item);

    X deQueue();

    X peek();

    boolean contains(X item);

    int size();

    void reverse();

    Iterator<X> iterator();

    void print();
}
