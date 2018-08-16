package com.devperson.generic;

public class GenericInterfaceStringImpl implements GenericInterface<String> {

    private int size = 10;

    String[] element;

    public GenericInterfaceStringImpl(int size) {
        this.size = size;
        element = new String[size];
    }

    public GenericInterfaceStringImpl() {
        element = new String[size];
    }

    @Override
    public void printObject(java.lang.String string) {
        System.out.println(string);
    }


    @Override
    public java.lang.String getInstence() {
        return "这是字符串对象";
    }

    @Override
    public boolean add(String s) {
        return false;
    }
}
