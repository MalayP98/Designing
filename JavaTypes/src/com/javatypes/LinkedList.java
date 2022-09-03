package com.javatypes;

public class LinkedList<T> {

    private Node<T> ROOT = null;

    private Node<T> currentNode = null;

    public void add(T element) {
        add(new SimpleNode<T>(element));
    }

    public Node<T> getRoot() {
        return ROOT;
    }

    public void add(Node<T> node) {
        if (ROOT == null) {
            ROOT = node;
            currentNode = ROOT;
        } else {
            currentNode.addChild(node);
            currentNode = currentNode.next();
        }
    }

    public void delete() {
        Node<T> head = ROOT;
        if (head != null) {
            if (head == currentNode) {
                ROOT = null;
            } else {
                while (head.next() != currentNode) {
                    head = head.next();
                }
                currentNode = head;
                currentNode.addChild(null);
            }
        }
    }

    @Override
    public String toString() {
        Node<T> head = ROOT;
        if (head == null) {
            return "Linked List is empty.";
        }
        StringBuilder linkedList = new StringBuilder();
        linkedList.append("[");
        while (head != null) {
            linkedList.append(head + ((head.next() == null) ? "" : " "));
            head = head.next();
        }
        linkedList.append("]");
        return linkedList.toString();
    }
}
