package exercises.exam200107;

import static java.lang.System.out;

public class uppg8 {
    public static void main(String[] args) {
        new uppg8().program();
    }

    private void program() {
        /*
        a)"doIt D" för att doIt i D överskiver doIt i C.

        b) doIt D, overload

        c)doIt A 1.0, overload

        d)Körningsfel, det går inte att casta om ett obejkt C till ett object B

        e)Körningsfel, det går inte att casta om ett C-obejkt till ett D-object eftersom C inte ärver fårn D

        f)Kompileringsfel, no super sub casting.

        g)Kompileringsfel, det finns ingen sådan metod
         */


        //a)
        //D d = new D();C c = d;c.doIt();

        //b)
        //IY iy = new D();C c1 = (C) iy;c1.doOther();

        //c)
        //A a = new B(); a.doIt(1);

        //d)
        //IX ix = new B();IY iy1 = new C();ix = (IX) iy1;ix.doIt(); // 2p

        //e)
        //A a1 = new C();D d1 = (D) a1;d1.doIt(1.0);

        //f)
        //C c2 = new D();B b = (B) c2;

        //g)
        //C c3 = new C();A a2 = c3;a2.doOther();

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
