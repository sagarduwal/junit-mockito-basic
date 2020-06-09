package com.trustgeek;

public class A {
    private final B b;

    public A(B b) {
        this.b = b;
    }

    public int usesVoidMethod() {
        try {
            b.voidMethod();
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
        return 1;
    }

}
