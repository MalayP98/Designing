package com.train.manage.repository;

public interface Repository<T> {

    public boolean add(T object);

    public boolean update(int index, T object);

    public boolean delete(int index);

    public T get(int index);
}
