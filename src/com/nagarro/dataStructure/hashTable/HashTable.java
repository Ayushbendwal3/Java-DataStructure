package com.nagarro.dataStructure.hashTable;

public interface HashTable<X,Y>{
    int size();

    Y getValueByKey(X key);

    boolean containsKey(X key);

    boolean containsValue(Y value);

    Y delete(X key);

    void insert(X key, Y value);

    void print();
}
