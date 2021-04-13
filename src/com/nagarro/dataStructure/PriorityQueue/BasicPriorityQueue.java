package com.nagarro.dataStructure.PriorityQueue;

import com.nagarro.dataStructure.queue.Queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public class BasicPriorityQueue<X> implements Queue<X> {
    private final X[] data;
    private int front;
    private int end;

    public BasicPriorityQueue() {
        this(1000);
    }

    public BasicPriorityQueue(int size) {
        this.front = -1;
        this.end = -1;
        data = (X[]) new Object[size];
    }

    private void checker() {
        if (size() == 0) {
            throw new IllegalStateException("Queue is empty");
        }
    }

    @Override
    public void enQueue(X item) {
        if ((end + 1) % data.length == front) {
            throw new IllegalStateException("Queue is full");
        } else if (size() == 0) {
            front++;
            end++;
            data[end] = item;
        } else {
            end++;
            data[end] = item;
        }
        Arrays.sort(data, Collections.reverseOrder());
    }

    @Override
    public X deQueue() {
        X item;
        checker();
        item = data[front];
        data[front] = null;
        if (front == end) {
            front = -1;
            end = -1;
        } else {
            front++;
        }
        return item;
    }

    @Override
    public X peek() {
        checker();
        return data[front];
    }

    @Override
    public boolean contains(X item) {
        checker();
        for (int i = 0; i < size(); i++) {
            if (data[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        if (front == -1 && end == -1) {
            return 0;
        } else {
            return end - front + 1;
        }
    }

    @Override
    public void reverse() {
        int temp;
        temp = front;
        front = end;
        end = temp;
        print();
    }

    @Override
    public Iterator<X> iterator() {
        return Arrays.stream(data).iterator();
    }

    @Override
    public void print() {
        checker();
        for (int i = front; i <= end; i++) {
            System.out.print("-->" + data[i]);
        }
    }
}
