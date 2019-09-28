package com.fcvscodemvn.basic;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

class InitializationOrdering {
    private long a;

    public InitializationOrdering() {
        this.a = 1;
    }

    public long getA() {
        return this.a;
    }
}

public class UnsafeDemo {
    public static void main(String[] args)
            throws InterruptedException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Unsafe unsafe = (Unsafe) f.get(null);

        InitializationOrdering o3 = (InitializationOrdering) unsafe.allocateInstance(InitializationOrdering.class);

        InitializationOrdering i1 = new InitializationOrdering();

        System.out.println(i1.getA());

        System.out.println(o3.getA());
    }
}
