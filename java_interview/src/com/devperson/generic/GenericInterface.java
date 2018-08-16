package com.devperson.generic;

public interface GenericInterface<T> {

    boolean add( T t );

    /**
     * 打印对象类型
     * */
    void printObject( T t);

    /**
     * 获取对象实例
     * */
    T getInstence();


}
