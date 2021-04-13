package com.nagarro.dataStructure.linkedList;

public interface LinkedList<X> {
    void insert(X item);

    void insertAt(int position, X item);

    X delete();

    X deleteAt(int position);

    X center();

    int size();

    void reverse();

    void print();
}
