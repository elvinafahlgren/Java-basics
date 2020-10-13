package exercises.ex2usemoreclasses;

import exercises.ex1useaclass.Rational;

import java.util.Arrays;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/*
      A class for a Triangle in 3D
      Should use Point class and Herons formula

      NOTE: No IO here, this is just the logical concept.

      To test run Ex2TestPointTriangle

*/
public class Triangle {
    private final Point p1;
    private final Point p2;
    private final Point p3;

    public Triangle(Point p1, Point p2, Point p3){
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }
    private Point getP1(){
        return this.p1;
    }
    private Point getP2(){
        return this.p2;
    }
    private Point getP3(){
        return this.p3;
    }

    public double area(){
        double a = p1.distance(this.p2);
        double b = p1.distance(this.p3);
        double c = p2.distance(this.p3);
        double A = 0.25 * sqrt(pow((4 * pow(a, 2) * pow(b, 2)- ((pow(a, 2) + pow(b, 2) - pow(c, 2)))), 2));

        return A;
    }

    @Override
    public boolean equals(Object o){
        Triangle t = (Triangle) o;
        if(t.getP1() == this.p1 && t.getP2() == this.p1 && t.getP3() == this.p3)
            return true;
        return false;
    }


}

