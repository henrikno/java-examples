package com.example.service;

import java.math.BigDecimal;

public class FooService {

    public FooModel findFoo() {
        FooModel foo = new FooModel();
        foo.setName("I'm Foo");
        foo.setAge(42);
        foo.getAccountList().add(new BigDecimal("23"));
        foo.getAccountList().add(new BigDecimal("42"));
        foo.getAccountList().add(new BigDecimal("42.23"));
        return foo;
    }
}
