package ru.job4j.point;

/**
 * Задано уравнение функции y(x) = a * x + b.
 * например: a=2 b=1 x=5
 * y = 11
 */


public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public boolean equationCorrect(int a, int b) {
        return (this.y == a * this.x + b);
    }


}

