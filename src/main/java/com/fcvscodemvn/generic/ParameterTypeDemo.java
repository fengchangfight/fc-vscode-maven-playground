package com.fcvscodemvn.generic;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

class Person<T> {

}

public class ParameterTypeDemo extends Person<ParameterTypeDemo> {

    @SuppressWarnings("unchecked")
    public static <T> void main(String[] args) {
        ParameterTypeDemo st = new ParameterTypeDemo();
        @SuppressWarnings("rawtypes")
        Class clazz = st.getClass();
        Class<? super T> parentClazz = clazz.getSuperclass();
        System.out.println(parentClazz);
        Type type = clazz.getGenericSuperclass();
        System.out.println(type);
        ParameterizedType p = (ParameterizedType) type;
        Class<T> c = (Class<T>) p.getActualTypeArguments()[0];
        System.out.println(c.getName());
        System.out.println(c);
    }
}