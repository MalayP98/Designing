package com.javatypes;

import java.util.Objects;

class KeyValueNode<K, V> extends SimpleNode<K> {

    private V value;

    public KeyValueNode(K data, V value) {
        super(data);
        this.value = value;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return Objects.toString(getData()) + " = " + Objects.toString(value);
    }
}

public class HashMap<K, V> {

    private final int DEFAULT_SIZE = 4;

    private final float DEFAULT_LOAD_FACTOR = 0.75f;

    private Object[] bucket;

    private float loadFactor;

    private int size;

    private int currentSize = 0;

    public HashMap() {
        this.bucket = createBucket(DEFAULT_SIZE);
        this.size = DEFAULT_SIZE;
        this.loadFactor = DEFAULT_LOAD_FACTOR;
    }

    public HashMap(int size) {
        this.bucket = createBucket(size);
        this.size = size;
        this.loadFactor = DEFAULT_LOAD_FACTOR;
    }

    public HashMap(int size, int loadFactor) {
        this.bucket = createBucket(size);
        this.size = size;
        this.loadFactor = loadFactor;
    }

    private Object[] createBucket(int size) {
        Object[] bucket = new Object[size];
        for (int i = 0; i < size; i++) {
            bucket[i] = new LinkedList<K>();
        }
        return bucket;
    }

    public void put(K key, V value) {
        increaseSize();
        int index = Objects.hash(key) % size;
        KeyValueNode<K, V> node = search(index, key);
        if (node != null) {
            node.setValue(value);
        } else {
            ((LinkedList<K>) bucket[index]).add(new KeyValueNode<K, V>(key, value));
            currentSize++;
        }
    }

    private void increaseSize() {
        if (currentSize >= (int) (loadFactor * size)) {
            size += size / 2;
            Object[] expandedBucket = createBucket(size);
            currentSize = 0;
            rehash(bucket, expandedBucket);
        }
    }

    private void rehash(Object[] parentBucket, Object[] childBucket) {
        this.bucket = childBucket;
        for (Object list : parentBucket) {
            KeyValueNode<K, V> head = (KeyValueNode<K, V>) ((LinkedList<K>) list).getRoot();
            while (head != null) {
                put(head.getData(), head.getValue());
                head = (KeyValueNode<K, V>) head.next();
            }
        }
    }

    public V get(K key) {
        int index = Objects.hash(key) % size;
        KeyValueNode<K, V> node = search(index, key);
        return node.getValue();
    }

    public KeyValueNode<K, V> search(int index, K key) {
        Node<K> head = ((LinkedList<K>) bucket[index]).getRoot();
        while (head != null) {
            if (head.getData().equals(key))
                return (KeyValueNode<K, V>) head;
            head = head.next();
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder map = new StringBuilder();
        map.append("{");
        for (int i = 0; i < size; i++) {
            KeyValueNode<K, V> head = (KeyValueNode<K, V>) ((LinkedList<K>) bucket[i]).getRoot();
            while (head != null) {
                map.append(head.toString());
                if (!(head.next() == null && i == size - 1))
                    map.append(", ");
                head = (KeyValueNode<K, V>) head.next();
            }
        }
        map.append("}");
        return map.toString();
    }
}
