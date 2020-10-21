package exercises.exam181031;

import static java.lang.System.out;

public class uppg8 {
    public static void main(String[] args) {
        new uppg8().program();
    }

    private void program() {
        //a) Eftersom C ärver från A innerbär det att allt A kan göra kan också C göra. När vi dår gör ett nytt objekt
        // C kommer det göra doA i klassen A
        /*
        A a1 = new C(); //Eftersom C ärver från A är det ok att skcva på detta sätt
        a1.doA();
        */

        //b) KOMPILERINGSFEL Det går inte att tilldela ett C-objekt till ett B-objekt eftersom de inte är relaterade till varandra
        /*
        B b1 = new C();
        b1.doA();
        */

        //c)
        /*
        IA ia2 = new C();
        IB ib2 = (IB) ia2; //vi skriver (IB) då vi är säkra på att det objekt vi får i ia2 kommer också ha alla
                            // metoder som ib2 kräver (om C däremot inte skulle implementera IB och vi ändå skulle
                            // skriva (IB) framför ia2 skulle vi få ett RUNTIME ERROR eftersom ia inte kan castas om
                            // till ib
        ib2.doB();
        */

        //d)
        /*
        IB ib4 = new C();   //Okej eftersom C implementerar IB
        C c = (C) ib4;      //vi castar om IB-objektet till ett C-objet och detta går eftersom det ib4 är ett C-objekt
        IA ia4 = c;         //tilldelar C-objektet till ett IA-objekt, det är okej eftersom i arvet implementerar C IA
        ia4.doA();          //här hörs Cs doA-metod, vilket är den som ärvs från A
        */

        //e)
        /*
        C c1 = (C) new B(); // KOMPILERINGSFEL B och C har ingen relation med varandra. B går inte att casta om till C.
        c1.doC();
        */

        //f) RUNTIME-FEL, kompilatorn ser inte att det blir fel och tror att det är ok att köra
        /*
        A a2 = new B();
        C c2 = (C) a2;      //det KAN gå ju att casta a2 till ett C objekt eftersom C ärver A.
                            //kompilatorn ser inga värden
                            //när vi väl kör och ser att a2 är ett B-objekt blir det fel för det går inte att casta
                            //B till C
        c2.doA();
        */

        //g)KOMPILERINGSFEL. kompilatorn vet inte om att ia1 är av typen C. Generellt sett har gränssnitt ingen
        // typomvandling. i runtim hade det fungerat. Kompilatorn kan inte garantera att det kommer fungera
        /*
        IA ia1 = new C();
        IB ib1 = ia1;       //här har vi ingen cast, om vi hade cast (IB) hade det funkat
        ia1.doA();
        */
    }


    public interface IA {
        void doA();
    }

    public interface IB {
        void doB();

    }

    public class A implements IA {
        public void doA() { out.println("A doA");}
    }

    public class B extends A {
        public void doA() { out.println("B doA");}
    }

    public class C extends A implements IB {
        public void doB() { out.println("C doB");}
        public void doC() { out.println("C doC");}
    }

}
