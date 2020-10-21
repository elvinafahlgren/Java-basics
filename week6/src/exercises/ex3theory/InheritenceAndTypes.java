package exercises.ex3theory;

/*
    Uncomment each row in turn and explain why the row compiles or not.

 */
public class InheritenceAndTypes {

    public static void main(String[] args) {
        new InheritenceAndTypes().program();
    }

    public void program() {
        IA ia = new A();    // Because A implements IA, we can create a object IA using new A()

        ia = new B();       // Works because B implements IA
        ia = new C();       // Works because C extends A that implements IA
        //ia = new D();     // Does not work because D doesn't extends any class that implements IA or implements IA
        ia = new E();       // Works because E implements IA

        A a = new A();
        //a = new B();      // Doesn't work because B doesn't extends A or extends any class that extends A
        a = new C();        // Works because C extends A
        //a = new D();      // Doesn't work because D doesnät extends A or any class that extends A
        //a = new E();

        //B b = new A();    // We cannot create a object B using new A() because A doesn't extends B or any class that extends B
        //B b = new C();    // We cannot create a object B using new C() because C doesn't extends B ar andy class that extends B
        //C c = new D();    // same as above
        //C c = new E();    // same
        D d = new E();      // We can create  an object D using new E() because E extends D
        //E e = new C();    // We cannot create a object E using new C() because C doesn't extends E or any class that extends E
        //E e = new D();    // We cannot create a object E using new D() because D doesn't extends E or any class that extends E

    }

    // -------------  Interfaces and classes ----------------------

    public interface IA {

    }

    public class A implements IA {

    }

    public class B implements IA {

    }

    public class C extends A {
    }

    public class D {

    }

    public class E extends D implements IA {

    }


}
