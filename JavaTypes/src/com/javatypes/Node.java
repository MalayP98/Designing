package com.javatypes;

public interface Node<T> {

    public T getData();

    public Node<T> next();

    public void addChild(Node<T> child);
}
