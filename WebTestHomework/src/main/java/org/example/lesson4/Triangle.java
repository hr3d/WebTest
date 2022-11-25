package org.example.lesson4;

public class Triangle {

    public double getTriangleArea (int a, int b, int c) throws MyNotTriangleException {

        if (a<0 || b<0 || c<0) throw new MyNotTriangleException("Сторона треугольника не может быть меньше 0");
        if (a==0 || b==0 || c==0) throw new MyNotTriangleException("Сторона треугольника не может быть равна 0");
        if (a > (b + c) || b > (a + c) || c > (a + b)) throw new MyNotTriangleException("Треугольника с текущими значениями сторон не существует");

        //Вычислим полупериметр треугольника
        double p = (a + b + c)/2.0;

        //Вычислим площадь треугольника
        double s = Math.sqrt(p*(p-a)*(p-b)*(p-c));

        return s;

    }
}