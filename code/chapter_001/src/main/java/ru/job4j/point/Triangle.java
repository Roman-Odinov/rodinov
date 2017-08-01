/**
* Создать класс Triangle c тремя полями Point.
* Класс Point использовать из предыдущего задания.
*
* Нужно составить программу которая будет вычислять площадь треугольника образованного этими точками.
*
* Программа должна учитывать условия невозможности построить треугольник через эти точки.
*/

package ru.job4j.point;


public class Triangle {
  private Point a;
  private Point b;
  private Point c;

  public Triangle(Point a, Point b, Point c) {
	/**
	* Set coordinates of the triangle.
	*/
    this.a = a;
    this.b = b;
    this.c = c;
  }

  public double area() {
  /**
  * Calculate the triangle area.
  */
  // S = |(xB−xA)*(yC−yA)−(xC−xA)*(yB−yA)| / 2
  double sq;
  sq = Math.abs((b.getX() - a.getX()) * (c.getY() - a.getY()) - (c.getX() - a.getX()) * (b.getY() - a.getY())) / 2;
  return sq;
  }

}

