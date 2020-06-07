package com.trustgeek.junit;

public class GreetingsImpl implements Greetings {
    @Override
    public String greet(String name) {
        if(null == name || name.length() == 0){
            throw new IllegalArgumentException();
        }
        return "Hello " + name;
    }
}
