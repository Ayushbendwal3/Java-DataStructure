package com.nagarro.dataStructure.stack;

import java.util.Arrays;
import java.util.Iterator;

public class BasicStack<X> implements Stack<X> {
    private final X[] data;
    private int stackPointer;

    public BasicStack() {
        this.data = (X[]) new Object[1000];
        this.stackPointer = 0;
    }

    private void checker() {
        if (stackPointer == 0) {
            throw new IllegalStateException();
        }
    }

    @Override
    public void push(X item) {
        data[stackPointer++] = item;
    }

    @Override
    public X pop() {
        checker();
        return data[--stackPointer];
    }

    @Override
    public X peek() {
        checker();
        return data[stackPointer];
    }

    @Override
    public boolean contains(X item) {
        checker();
        for (int i = 0; i < stackPointer; i++) {
            if (data[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return stackPointer;
    }

    @Override
    public void reverse() {
        checker();
        X[] temp = (X[]) new Object[stackPointer];
        int j = stackPointer;
        for (int i = 0; i < stackPointer; i++) {
            temp[j - 1] = data[i];
            j = j - 1;
        }
        if (stackPointer >= 0) {
            System.arraycopy(temp, 0, data, 0, stackPointer);
        }
    }

    @Override
    public void print() {
        for (int i = stackPointer; i >= 0; i--) {
            System.out.print(data[stackPointer] + " ");
        }
    }

    @Override
    public Iterator<X> iterator() {
        return Arrays.stream(data).iterator();
    }
}
