/*
        Solution to question 5 here.
 */

import static java.lang.System.*;

public class Q5 {

    public static void main(String[] args) {
        new Q5().program();
    }

    private void program() {
        String walk1 = "e1w1s1n1";
        String walk2 = "e12w12s12n12";
        String walk3 = "e123w1";
        String walk4 = "e122w123e1";
        String walk5 = "n3e4s2e2";
        out.println(willHit(0, 0, 0, 0, walk1));
        out.println(willHit(1, 1, 1, 1, walk2));
        out.println(willHit(0, 0, 0, 0, walk3));
        out.println(willHit(0, 0, 0, 0, walk4));
        out.println(willHit(2, 2, 8, 3, walk5));
        /*
        */
    }
    // TODO FRÅN GENOMGÅNG, INTE KLAR, sista för. sista del
    boolean willHit(int ix, int iy, int fx, int fy, String walk){

        char currentDirection = 'o';
        StringBuilder num = new StringBuilder();

        for(char c : walk.toCharArray()){
            if(!Character.isDigit(c)){
                if(num.length() > 0){
                    int tmp = Integer.parseInt(num.toString());

                    if(currentDirection == 'n')
                        iy += tmp;
                    else if(currentDirection == 'e')
                        ix += tmp;
                    else if(currentDirection == 's')
                        iy -= tmp;
                    else if(currentDirection == 'w')
                        ix -= tmp;

                    num.setLength(0);
                }
                currentDirection = c;
            }
            else
                num.append(c);

        }

        int tmp = Integer.parseInt(num.toString());

        if(currentDirection == 'n')
            iy += tmp;
        else if(currentDirection == 'e')
            ix += tmp;
        else if(currentDirection == 's')
            iy -= tmp;
        else if(currentDirection == 'w')
            ix -= tmp;

        //out.println(num);

        //out.print(ix + " " + iy + " "+ fx + " " + fy);
        return (ix == fx) && (iy == fy);
    }
}
