package exercises;

import java.util.Arrays;

import static java.lang.System.out;

/**
 *  Some theory mostly about references and identity
 *
 *  See
 *  - References
 *  - Overloading
 */
public class Ex3Theory {

    public static void main(String[] args) {
        new Ex3Theory().program();
    }

    void program() {

        // 1. Uncomment section below and you will get compile errors. Why?
        /*
        int i = 1;
        char ch = '1';
        double d = 1.0;

        i = d;      // double can't be int (it contains decimals)
        i = ch;     // works because we get the ASCII - value (prints 49)
        ch = i;     // int can't be char because int can contain many numbers, char only one character
        ch = d;     // same as above
        d = i;      // int can be double
        d = ch;     // same as i = ch

        i = (int) d;        // type causing. this works because decimals can be removed
        (double) i = d;     // type causing. can't change variable type from type causing
        */

        // 2. Uncomment and run.  What will be printed. Explain! ---------
        /*int[] i1 = {1, 2, 3};
        int[] i2 = {10, 11, 12, 13, 14, 15};
        int[] i3 = i1;

        out.println(i3[1]);
        i3 = i2;
        out.println(i3[1]);
        i1 = i2;
        out.println(i3[1]);
        i3 = i1;
        out.println(i3[1]);     //11 because i3 pointing at i1 and i1 is pointing at i2
        */

        // 3. What will be printed. Explain! (methods below) ----------------
        /*int a = 1;
        int b = 2;
        swap(a, b);                 //the swap method takes in a and b as new integers-pointers
                                    //...  not changing the original integers
                                    //we get pointers that pointing at pointers
        out.println(a + ", " + b);

        int[] arr = {1, 2};
        swap(arr);                  //this swap method takes in the actual array and changing the actual values
        out.println(Arrays.toString(arr));

        Player p1 = new Player();
        Player p2 = new Player();
        p1.name = "olle";
        p1.points = 34;
        p2.name = "fia";
        p2.points = 56;

        swap( p1, p2 );
        out.println(p1.name + ", " + p2.name);
        */

        // 4. What will be printed. Explain! Methods below ----------------
        /*int[] a1 = getArr();
        int[] a2 = getArr();

        out.println(a1.length == a2.length); //printing true because same length (same int-value)
        out.println(a1[0] == a2[0]);         //true because same value at index 0 (same int-value)
        out.println(a1 == a2);               //printing false because a1 and a2 are two different objects
        */

        // 5. If uncommenting you'll get a compile error. Why? (methods below)
        //out.println(add(1,1));               //ambiguous (=mångtydlig) method call.
                                             //both add(double, int) and add(int, double) match
    }

    // ---------- Some methods used ---------------------------

    void swap(int a, int b) {
        int tmp = a;
        a = b;
        b = tmp;
    }

    void swap(int[] a) {
        int tmp = a[0];
        a[0] = a[1];
        a[1] = tmp;
    }

    void swap( Player p1, Player p2){
        String tmp = p1.name;
        p1.name = p2.name;
        p2.name = tmp;
    }

    int[] getArr() {
        int[] arr = {1, 2, 3};
        return arr;
    }

    double add(double d, int i) {
        return d + i;
    }

    double add(int i, double d) {
        return i + d;
    }

    class Player {
        String name;
        int points;
    }

}
