package exercises.exam190107;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class uppg8 {
    public static void main(String[] args) {
        new exercises.exam190107.uppg8().program();
    }

    private void program() {
        /*
        a) Skriver ut "doIt C" eftersom doIt-funktionen i C skriver över doIt-funktionen i A. Override.
        Eftersom C ärver från A är det okej att skriva "A a = new C()"

        b)KOMPILERINGSFEL. Det går inte att göra gör ett B objekt genom att skriva "C c = new B()"
        eftersom B inte ärver från C eller ärver från något obejekt som i sin tur äver från C osv.

        c)Skriver ut "doIt A" eftersom doIt-funktionen i A overloads doIt-funktionen i B.

        d)KÖRNINGSFEL. Vi säger att det går att casta om C-objektet o till ett D-objekt,
        men när programmet körs kommer detta inte gå eftersom C och D inte har något med varandra att göra.

        e)Skriver ut "doIt C" eftersom A-objektet skapas från ett C-objekt.

        f)Skriver ut "doIt A" eftersom os-arrayen pekar på as-arrayen som har ett A-objekt på plats 0.

        g)KOMPILATORFEL, no super sub for generic types (os = as)
        A är subtyp till Object men List<A> är INTE subtyp till List<Object> eftersom generiska typer inte har
        något super/subtype förhållande. Vi kan inte skriva os = as.
        */


        //a
        //A a = new C(); a.doIt(1.0);

        //b
        //C c = new B();c.doIt(1.0);

        //c
        //A a = new B();a.doIt(1);

        //d
        /*
        Object o = new C();
        D d = (D) o;
        d.doIt(1.0);
        */

        //e
        /*
        IX i = new C();
        A a = (A) i;
        a.doIt(1.0);
        */

        //f
        /*
        Object[] os;
        A[] as = {new A(), new A()};
        os = as;
        ((A) os[0]).doIt(5);
        */

        //g
        /*
        List<Object> os = new ArrayList<>();
        List<A> as = new ArrayList<>();
        os = as;
        os.add(new B());
        ((B) os.get(0)).doIt(5);
        */
    }



// --- Interfaces and classes
        interface IX { void doIt(double d);}

        class A implements IX {
            public void doIt(double d) {
                out.println("doIt A"); }
        }
        class B extends A {
            public void doIt(int i) {
                out.println("doIt B"); }
        }
        class C extends A {
            public void doIt(double d) {
                out.println("doIt C"); }
        }
        class D{
            public void doIt(double d) {
                out.println("doIt D"); }
        }



}
