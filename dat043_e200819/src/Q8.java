/*
        Solution to question 8 here.
 */
import static java.lang.System.out;
public class Q8 {

    public static void main(String[] args) throws Exception {
        new Q8().program();
    }

    /**
            Write explanations here as comments

            a)Vi skapar först ett objekt X-objekt x som är av typen Y, vilket går bra eftersom Y är sub-klass till X.
            När vi sedan gör x.doIt(5) kommer doIt-metoden i X-klassen att köras eftersom den överladdar (overload)
            doIt-metoden i Y. doIt-metoden i Y kommer inte att köras eftersom en doIt-metod med inparametern int
            inte finns i X-klassen.

            Sedan skapar vi ett objekt Y-objekt y av typen Y, och eftersom vi skickar in en double s kallar vi
            på den överladdade funktionen i X-klassen.

            b)
            **/
    void program() {
        /*
        X x = new Y();
        x.doIt(5);
        Y y = new Y();
        y.doIt(5.0);

         */



        //C c = new C(1);
    }

    /*
    class X {
        void doIt(double d) { out.println("doIt A " + d); }
    }
    class Y extends X {
        void doIt(int i) { out.println("doIt B " + i);}
        //void doIt(double d) { out.println("doIt B " + d); }
    }


    class A {
        int i;
        A(int i) {
            this.i = i;
            out.println("ctor A");
        }
    }

    static class B extends A {
        static C c = new C(4);
        B(int i) {
            super(i);
            out.println("ctor B");
        }
    }

    static class C extends B {
        C(int i) {
            super(i);
            out.println("ctor C");
        }
    }

     */

}
