package exercises.exam190819;

import static java.lang.System.out;

public class uppg8 {
    public static void main(String[] args) {
        new uppg8().program();
    }

    private void program() {
        /*
        a) Det går bra att casta om ix till ett IY-interface eftersom ix är ett C-objekt och C implementerar från IY.
        Det skrivs sedan ut "doIt C" eftersom doIt-metoden i C-klassen överskriver doIt-metoden i IY.

        b) Skiver ut "doIt A" eftersom doIt-metoden i A överladdar (overload) metoden i B.

        c)KOMPILERINGSFEL. C ärver inte från B, det går inte att skriva på detta sätt.

        d)KÖRNINGSFEL. Vi säger att det går att casta ett B-objekt (ix) till ett C-objekt,
        men när programmet körs kommer detta inte gå eftersom C och D inte har något med varandra att göra.

        e)Skriver ut "doIt C" eftersom doIt-metoden i C tar in rätt typ av objekt (B ärver frånm IX).

        f)KOMPILERINGSFEL. Det fi8nns ingen metod som tar emot iy som parameter.

        g)KOMPILERINGSFEL. Generiska typer har inga sub/super-types förhållanden.

        h)KÖRNINGSFEL. (array store exception)
        */

        //a)
        //IX ix = new C(); IY iy = (IY) ix; iy.doIt(new B());

        //b)
        //A a = new B(); a.doIt(1);

        //c)
        //B b = new C(); b.doIt(1);

        //d)
        //A a = new B(); IX ix = (IX) a; C c = (C) ix; c.doIt(1.0);

        //e)
        //C c = new C(); c.doIt(new B());

        //f)
        //IY iy = new C(); iy.doIt(iy);

        //g)
        //List<A> as = new ArrayList<>(); List<B> bs = as; bs.get(0).doIt(5);

        //h)
        //B[] bs = new B[2]; bs[0] = (B) new C();
    }

    // --- Interfaces and classes
    interface IX { void doIt(double d); }

    interface IY { void doIt(IX ix); }

    class A implements IX {
        public void doIt(double d) {
            out.println("doIt A");
        }
    }

    class B extends A {
        public void doIt(int i) {
            out.println("doIt B");
        }
    }

    class C extends A implements IY{
        public void doIt(IX ix) {
            out.println("doIt C");
        }
    }
}
