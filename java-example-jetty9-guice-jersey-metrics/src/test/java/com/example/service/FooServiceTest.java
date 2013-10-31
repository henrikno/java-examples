package com.example.service;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.fest.assertions.Assertions.assertThat;

public class FooServiceTest {

    private FooService service;

    @BeforeMethod
    public void setUp() throws Exception {
        service = new FooService();
    }

    @Test
    public void example_test_that_Foo_hast_correct_age() {
        FooModel foo = service.findFoo();

        assertThat(foo.getAge()).isEqualTo(42);
    }

}
