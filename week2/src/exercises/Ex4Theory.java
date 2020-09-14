package exercises;


import static java.lang.System.out;

/*
 *  For each of the section below. Uncomment and explain
 *
 */
public class Ex4Theory {

    public static void main(String[] args) {
        new Ex4Theory().program();
    }


    void program() {

        // 1. -------------------------------------------

        // Uncomment and run. Which value is correct for the volume of a sphere?
        /*
        int r = 10;
        double pi = 3.141;
        double vol1 = 4 * pi / 3 * r * r * r;
        double vol2 = pi * r * r * r * (4 / 3.0); // hade fungerat om man skrev 4.0 eller 3.0
        double vol3 = 4 / 3 * pi * r * r * r;
        double vol4 = 4 / (3 * pi) * r * r * r;

        out.println(vol1);
        out.println(vol2);
        out.println(vol3);
        out.println(vol4);
        */

        // 2. ---------------------------------------------------

        // Uncomment section below and you will get compile errors. Why?
        /*
        {
            int x = 0;
            {
                int x = 0;      //x är redan definerad
                int y = 0;
                out.println(x);
                out.println(y);
            }
            int x = 0;          //x är redan definerad
            int y = 0;
            out.println(x);
            out.println(y);
        }
        out.println(x);     //x och y är inte definerade i detta scope
        out.println(y);
        */

        // 3. ----------------------------------------------------------

        // Uncomment and run. Explain result!
        /*
        double d1 = 1.0;
        double d2 = 1.0;
        d1 = d1 - 0.7 - 0.3;        //double sparas som båktal. Det finns inga riktigt exakta båktal för udda decimaltal
                                    //d1 blir därför inte exakt noll
        d2 = d2 - 0.6 - 0.4;        //d2 där emot blir noll eftersom det finns exakta bråktal för jämna decimaltal
        out.println(d1 == 0);
        out.println(d2 == 0);
        out.println(d1 == d2);
        */

        // 4. -----------------------------------------------------

        // Uncomment and run. Explain output!

        out.println(1 + 2);         //matematisk operation
        out.println("2 + 1");       //sträng
        out.println(1 + 2.0 + "a"); //matematisk operation + sträng
        out.println("a" + 1 + 2);   //eftersom a är en sträng och ligger först kommer hela raden bli en sträng
        out.println('a' + 1 + 2);   //a är en char och sparas då som ascii värde, ascii värdet för litet a är 97
        out.println("a" + 'a');     //eftersom a är en sträng och ligger först kommer hela raden bli en sträng


        // 5. ---------------------------------
        // Why is there no return type for a constructor?
        // en konstruktor skall bara initialisera värden, själva klassen returnerar redan automatiskt en instans
        }
}
