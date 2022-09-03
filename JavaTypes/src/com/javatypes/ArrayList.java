package com.javatypes;

import java.util.Objects;

public class ArrayList<T> {

    private final int DEAFULT_ARRAY_SIZE = 10;

    private T[] array;

    private int currentSize;

    private int currentIndex = 0;

    @SuppressWarnings("unchecked")
    public ArrayList() {
        array = (T[]) new Object[DEAFULT_ARRAY_SIZE];
        currentSize = DEAFULT_ARRAY_SIZE;
    }

    @SuppressWarnings("unchecked")
    public ArrayList(int size) {
        array = (T[]) new Object[size];
        currentSize = size;
    }

    public void add(T element) {
        if (isFilled()) {
            increaseSize();
        }
        array[currentIndex++] = element;
    }

    public T get(int index) {
        if (0 > index || index >= currentIndex) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    public int size() {
        return currentIndex;
    }

    private boolean isFilled() {
        return (currentIndex == currentSize);
    }

    @SuppressWarnings("unchecked")
    private void increaseSize() {
        currentSize += currentSize / 2;
        T[] temporaryArray = (T[]) new Object[currentSize];
        for (int i = 0; i < currentIndex; i++) {
            temporaryArray[i] = array[i];
        }
        array = temporaryArray;
    }

    @Override
    public String toString() {
        StringBuilder list = new StringBuilder();
        list.append("[");
        for (int i = 0; i < currentIndex; i++) {
            list.append(Objects.toString(array[i]) + ((i == currentIndex - 1) ? "" : " "));
        }
        list.append("]");
        return list.toString();
    }
}
