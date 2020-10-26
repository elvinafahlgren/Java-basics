package exercises.exam181031;

import java.util.Scanner;

import static java.lang.System.in;

public class uppg3 {
    public static void main(String[] args) {
        new uppg3().program();
    }

    final Scanner sc = new Scanner(in);

    private void program() {
        System.out.println("Grader > ");
        double deg = sc.nextDouble();

        System.out.println("Heltal > ");
        int n = sc.nextInt();

        System.out.println("Cosinus is: " + cosinus(deg, n));

    }

    double cosinus(double deg, int n){
        double rad = deg * (Math.PI / 180);
        double res = 1, sign = 1, fact = 1, pow = 1;

        for(int i = 1; i < n; i++){
            sign = sign * -1;
            fact *= (2 * i - 1) * (2 * i);
            pow *= rad * rad;
            res += sign * pow / fact;            
        }
        
        return res;
    }
}
