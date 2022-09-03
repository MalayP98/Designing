package com.javatypes;

public class SimpleNode<T> implements Node<T> {

    private T data;

    private Node<T> next;

    public SimpleNode(T data) {
        this.data = data;
        next = null;
    }

    public SimpleNode(T data, SimpleNode<T> next) {
        this.data = data;
        this.next = next;
    }

    @Override
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public Node<T> next() {
        return next;
    }

    @Override
    public void addChild(Node<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }
}
