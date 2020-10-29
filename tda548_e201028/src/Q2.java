
import static java.lang.System.*;

public class Q2 {

    public static void main(String[] args) {
        new Q2().program();
    }

    private void program() {
        int x = 5;
        try {
            x = 6;
            out.println(1/0);
            x = 7;
        } catch (ArithmeticException e) {
            out.println("Error");
        }
        out.println("x = " + x);

        // TODO Write answer to question
        /*
        SVAR: x får värdet 6 eftersom i try-satsen får först x värdet 6 och på raden under försöker
        programmet skriva ut ett tal som inte går att skriva ut (går ej att dela med 0). Try-satsen avslutas därmed
        och catch körs: printar "Error". x får aldrig värdet 7.
        */
    }

}
