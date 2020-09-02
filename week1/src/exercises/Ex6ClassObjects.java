package exercises;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/*
 *  Using class objects to represent heroes
 *  https://en.wikipedia.org/wiki/Gladiators_(1992_UK_TV_series)
 *
 * See:
 * - ClassObjects
 * - MethodsArrObj
 */
public class Ex6ClassObjects {

    public static void main(String[] args) {
        new Ex6ClassObjects().program();
    }

    final Scanner sc = new Scanner(in);

    void program() {
        // TODO
        Hero hero1 = new Hero();
        Hero hero2 = new Hero();

        out.print("What's the name of the hero 1? >");
        hero1.name = sc.nextLine();

        out.print("How strong is Hercules >");
    }

    // ------ The class to use  -----------
    // A class for objects that describes a Hero
    class Hero {
        String name;
        int strength;
    }


}
