package com.nagarro.dataStructure.linkedList;

import java.util.Iterator;

public class BasicLinkedList<X> implements LinkedList<X> {

    private Node head;
    private Node tail;
    private int nodeCount;

    public BasicLinkedList() {
        head = null;
        tail = null;
        nodeCount = 0;
    }

    @Override
    public int size() {
        return nodeCount;
    }

    @Override
    public void insert(X item) {
        if (head == null) {
            head = new Node(item);
            tail = head;
        } else {
            Node newLastNode = new Node(item);
            tail.setNextNode(newLastNode);
            tail = newLastNode;
        }
        nodeCount++;
    }

    @Override
    public void insertAt(int position, X item) {
        if (size() < position) {
            throw new IllegalStateException("LinkedList is smaller than the position entered");
        }
        Node currentNode = head;
        for (int i = 1; i < position && currentNode != null; i++) {
            currentNode = currentNode.getNextNode();
        }

        Node newNode = new Node(item);
        Node nextNode = currentNode.getNextNode();
        currentNode.setNextNode(newNode);
        newNode.setNextNode(nextNode);
        nodeCount++;
    }

    @Override
    public X delete() {
        if (head == null) {
            throw new IllegalStateException("The LinkedList is already empty");
        }
        X nodeItem = head.getNodeItem();
        head = head.getNextNode();
        nodeCount--;
        return nodeItem;
    }

    @Override
    public X deleteAt(int position) {
        if (head == null) {
            throw new IllegalStateException("Linked List is empty");
        }
        Node currentNode = head;
        Node prevNode = head;

        for (int i = 1; i < position && currentNode != null; i++) {
            prevNode = currentNode;
            currentNode = currentNode.getNextNode();
        }
        X nodeItem = currentNode.getNodeItem();
        prevNode.setNextNode(currentNode.getNextNode());
        nodeCount--;
        return nodeItem;
    }

    @Override
    public X center() {
        if (head == null) {
            throw new IllegalStateException("The LinkedList is empty");
        }
        int middle = size() / 2;
        Node currentNode = head;
        for (int i = 1; i < middle && currentNode != null; i++) {
            currentNode = currentNode.getNextNode();
        }
        return currentNode.getNodeItem();
    }

    @Override
    public void reverse() {
        Node prevNode = null;
        Node currentNode = head;
        Node nextNode;
        while (currentNode != null) {
            nextNode = currentNode.getNextNode();
            currentNode.setNextNode(prevNode);
            prevNode = currentNode;
            currentNode = nextNode;
        }
    }

    @Override
    public void print() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.getNodeItem() + "-->");
            currentNode = currentNode.getNextNode();
        }
    }

    private class Node {
        private Node nextNode;
        private final X nodeItem;

        public Node(X item) {
            this.nextNode = null;
            this.nodeItem = item;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }

        public Node getNextNode() {
            return nextNode;
        }

        public X getNodeItem() {
            return nodeItem;
        }
    }

}
