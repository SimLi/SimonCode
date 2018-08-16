package com.devperson.generic;

public class GenericInterfaceImpl<T> implements GenericInterface<T> {

    private int size = 10;

    Object[] element;

    public GenericInterfaceImpl(int size) {
        this.size = size;
        element = new Object[size];
    }

    public GenericInterfaceImpl() {
        element = new Object[size];
    }

    @Override
    public boolean add(T t) {

        return false;
    }

    @Override
    public void printObject(T t) {

    }

    @Override
    public T getInstence() {
        return null;
    }
}
