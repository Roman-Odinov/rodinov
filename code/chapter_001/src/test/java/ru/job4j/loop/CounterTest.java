package ru.job4j.loop;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

//import static org.hamcrest.core.Is.is;

public class CounterTest {
    @Test
    public void Add() throws Exception {
        int expectedValue = 30;
        Counter counter = new Counter();
        int actualValue = counter.add(-6, 12);
        assertEquals(expectedValue, actualValue);
    }

}