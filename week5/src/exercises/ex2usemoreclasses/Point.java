package exercises.ex2usemoreclasses;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/*

  A class for points in 3D. Should be immutable (final)

  NOTE: No IO (input, output) here, this is just the logical concept.

  To test run Ex2TestPointTriangle

*/
public class Point {
    // TODO
    private final int a;
    private final int b;
    private final int c;

    public Point(int a, int b, int c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Point(Point p){
        this.a = p.getA();
        this.b = p.getB();
        this.c = p.getC();
    }

    private int getA(){
        return this.a;
    }
    private int getB(){
        return this.b;
    }
    private int getC(){
        return this.c;
    }

    int distance(Point p){
        int totalP1 = this.a + this.b + this.c;
        int totalP2 = p.getA() + p.getB() + p.getC();
        return -1 * (totalP1 - totalP2);
    }
}


