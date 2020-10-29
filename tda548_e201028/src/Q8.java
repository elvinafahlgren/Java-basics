/*
        Solution to question 8 here.
 */

import java.util.ArrayList;

import static java.lang.System.*;
public class Q8 {

    public static void main(String[] args) throws Exception {
        new Q8().program();
    }

    /*
            TODO Write explanations here as comments
            a) Kompileringsfel. Kompilatorn ser inte att det finns någon sådan doIt-metod (utan parametrar) i A-klassen.

            b) Skriver ut "doIt B". Funkar eftersom A castas till ett B-objekt.

            c) Skriver ut "doIt D" eftersom doIt()-metoden i D överskriver doIt()-metoden i C.

            d) Körningsfel. Vi säger att det går att casta om a3 till ett C-objekt, men när vi kör får vi fel eftersom
            B och C inte är sub/super-typer till varandra (de har ingen relation).

            e) Körningsfel. Det gpr inte att casta om C till IX.

            f) Det går bra att skriva så eftersom A är sub-typ till Object.

            g) Kompileringsfel. Det går inte att skriva så eftersom generiska typer inte har sub/super typer.

            h) Eftersom A <: Object gäller även att A[] <: Object[]

     */

    void program() {

        //A a = new B();a.doIt();
        //A a2 = new B();((B) a2).doIt();
        //C c2 = new D();c2.doIt();
        //A a3 = new B();C c3 = (C) a3;
        //IX ix4 = (IX) new B();ix4 = (IX) new C();ix4.doIt();
        //Object o5 = new A();
        //ArrayList<Object> objects6 = new ArrayList<A>();
        //Object[] objects7 = new A[10];

    }

    interface IX { void doIt();}
    interface IY { void doOther(double d);}
    class A {
        public void doIt(double d) { out.println("doIt A " + d); }
    }
    class B extends A implements IX {
        public void doIt() { out.println("doIt B");}
        public void doIt(int i) { out.println("doIt B " + i); }
    }
    class C extends A implements IY {
        public void doIt() { out.println("doIt C"); }
        public void doOther(double d) { out.println("doOther C");
        }
    }
    class D extends C {
        public void doIt() { out.println("doIt D");}
        public void doOther(int i) { out.println("doOther D");}
    }

}
