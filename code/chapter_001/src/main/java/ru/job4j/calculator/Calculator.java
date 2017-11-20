package ru.job4j.calculator;

/**
 * class Calculator - выполнение простых арифметических действий.
 */
public class Calculator {

    private double result;

    public void add(double first, double second) {
        this.result = first + second;
    }

    public void substract(double first, double second) {
        this.result = first - second;
    }

    public void div(double first, double second) {
        this.result = first / second;
    }

    public void multiply(double first, double second) {
        this.result = first * second;
    }

    public double getResult() {
        return this.result;
    }
}