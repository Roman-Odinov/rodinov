package ru.job4j.point;

import java.util.Arrays;
/**
 * Создать класс Triangle c тремя полями Point.
 * Класс Point использовать из предыдущего задания.
 *
 * Нужно составить программу которая будет вычислять площадь треугольника образованного этими точками.
 *
 * Программа должна учитывать условия невозможности построить треугольник через эти точки.
 */
public class Triangle {
    private Point a;
    private Point b;
    private Point c;

    /**
     * Установить координаты треугольника.
     */
    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Вычисление площади.
     * @return 0 если построить треугольник невозможно; double - вычисленная площадь
     */
    public double area() {
        /*
         определение того можно ли построить треугольник по условию:
         Если бОльшая сторона равна сумме двух других сторон, то треугольник построить нельзя
         =>
         из трех вычислить бОльшую;
            для этого посчитать дилины всех отрезков
            |AB| = sqrt( (yB - yA)² + (xB - xA)² )
            |AC| = sqrt( (yC - yA)² + (xC - xA)² )
            |BC| = sqrt( (yC - yB)² + (xC - xB)² )
        */
        double ab = Math.abs( Math.sqrt( Math.pow(b.getY() - a.getY(), 2) + Math.pow(b.getX() - a.getX(), 2) ) );
        double ac = Math.abs( Math.sqrt( Math.pow(c.getY() - a.getY(), 2) + Math.pow(c.getX() - a.getX(), 2) ) );
        double bc = Math.abs( Math.sqrt( Math.pow(c.getY() - b.getY(), 2) + Math.pow(c.getX() - b.getX(), 2) ) );

        // сортировка длин отрезков в порядке увеличения
        double lineArr[] = {ab, ac, bc};
        Arrays.sort(lineArr);

        if (lineArr[2] == lineArr[0] + lineArr[1]) {
            return 0;   // треугольник построить нельзя
        }

        /*
         * При успешном построении вычисляем площадь:
         * S = |(xB−xA)*(yC−yA)−(xC−xA)*(yB−yA)| / 2
         */
        return Math.abs((b.getX() - a.getX()) * (c.getY() - a.getY()) - (c.getX() - a.getX()) * (b.getY() - a.getY())) / 2;
    }

}

