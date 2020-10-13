package exercises.ex3theory;

import static java.lang.System.out;
/*
 *  More subclasses and subclasses (objects) connected
 *
 *  See
 *  - useaclass/*
 *  - usemoreclasses/*
 *  - usestatic/*
 */
public class Ex3Theory {

    public static void main(String[] args) {
        new Ex3Theory().program();
    }

    void program() {
        //1. What will be printed? Why?
        /*
        Pt p1 = new Pt();
        Pt p2 = new Pt();
        Pt p3;

        p1.x = 1;
        p1.y = 2;
        p2.x = 2 * p1.x;    //p2.x == 2
        p2.y = 2 * p1.y;    //p2.y == 4
        p3 = p1;            //p3 == p1
        p1 = p2;

        out.println(p1 == p2);      //true because p1 get initialized as p2
        out.println(p2 == p3);      //false because p3 get initialized as p1 before p1 get initialized as p2
        out.println(p1 == p3);      //different

        //same as above
        out.println(p1.x == p2.x);
        out.println(p2.x == p3.x);
        out.println(p3.y == p1.y);
        */

        // 2. What will be printed? Why? See Mth class below
        /*
        out.println((int)d);
        Mth m = new Mth(3);
        m.op(1.5);      //m.op = 3 + 1 = 4
        m.op();            //m.op = 4 * 2 = 8
        m.op(2);         //m.op = 8 + 2 = 10
        out.println(m.i);  //print 10
        */

        // 3. What will be printed? Why? How many objects are involved? //5 objects
        /*
        Cainc cc = new Cainc(5);
        out.println(cc.doIt().doIt().doIt().doIt().i); // 5 +1 +1 +1 +1 = 9
        */

        // 4. What will be printed? Why? How many objects are involved? //3 objects
        /*
        CCtor c = new CCtor(new CCtor(new CCtor(8)));
        out.println(c.i); // prints 8
        */

        // 5. Some rows will give errors. Explain!
        /*

        //A.a = A.b;              // 1 - a is a static int, which means we don't have to make a new object to get...
                                       //... the variable a, but b isn't a static int which means we cannot...
                                       //... just access it like this
        A.a = new A().b;        // 2 -  But this works!
        //A.b = A.a;              // 3 - same here
        new A().b = A.a;        // 4
        new A().a = new A().b;  // 5 - not necessary to get a this way, but we can still do it
        new A().b = new A().a;  // 6
        A a = null;             // 7 - do new class object a, let it be null
        out.println(a.a);       // 8 - static int a is defined at class level (created when class is defined)...
        //... and is not dependant on a class object and will therefore be referenced directly from class definition

         */
    }

    // ---------- Classes ----------------------------

    // "static" before class A has nothing to do with the problems, ignore it
    static class A {
        static int a;    // A class variable
        int b;
    }

    class Pt {
        int x;
        int y;
    }

    class Mth {
        int i;

        Mth(int i) {
            this.i = i;
        }

        void op() {
            i = 2 * i;
        }

        void op(double d) {
            i = i + (int) d;
        }

        void op(int i) {
            this.i += i;
        }
    }

    class Cainc {
        final int i;

        Cainc(int i) {
            this.i = i;
        }

        Cainc doIt() {
            return new Cainc(i + 1);
        }

    }

    class CCtor {
        int i;

        CCtor(int i) {
            this.i = i;
        }

        CCtor(CCtor o) {
            i = o.i;
        }
    }
}
