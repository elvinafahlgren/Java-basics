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

        out.print("What's the name of the hero 1? > ");
        hero1.name = sc.nextLine();

        out.print("How strong is " + hero1.name + "? > ");
        hero1.strength = sc.nextInt();

        sc.nextLine();

        out.print("What's the name of the hero 2? > ");
        hero2.name = sc.nextLine();

        out.print("How strong is " + hero2.name + "? > ");
        hero2.strength = sc.nextInt();

        if (hero1.strength > hero2.strength){
            out.println(hero1.name + " is stronger.");
        }
        else if (hero2.strength > hero1.strength){
            out.println(hero2.name + " is stronger.");
        }
        else if (hero1.strength == hero2.strength){
            out.println(hero1.name + " and " + hero2.name + " are both strong.");
        }
    }

    // ------ The class to use  -----------
    // A class for objects that describes a Hero
    class Hero {
        String name;
        int strength;
    }


}
