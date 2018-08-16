package com.devperson.generic;

import java.util.ArrayList;
import java.util.List;

public class TestGeneric {

    public static void main(String[] args) {
        GenericInterfaceStringImpl gsi = new GenericInterfaceStringImpl();
        System.out.println(gsi.getInstence());
        List<String> list = new ArrayList();
        list.add("ss");
    }
}
