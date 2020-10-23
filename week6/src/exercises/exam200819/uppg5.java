package exercises.exam200819;

import static java.lang.System.out;
import static java.lang.System.setErr;

public class uppg5 {
    public static void main(String[] args) {
        new exercises.exam200819.uppg5().program();
    }

    private void program() {
        String walk1 = "e1w1s1n1";

        out.println(willHit(0, 0, 0, 0, walk1));
        out.println(willHit(1, 1, 1, 1, walk1));
    }
    // TODO FRÅN GENOMGÅNG, INTE KLAR, sista för. sista del
    boolean willHit(int ix, int iy, int fx, int fy, String walk){

        char currentDirection = 'o';
        StringBuilder num= new StringBuilder();

        for(int i = 0; i < walk.length(); i++){
            if(!Character.isDigit(walk.charAt(i))){
                if(num.length() > 0){
                    out.println(num);
                    int tmp = Integer.parseInt(num.toString());

                    if(currentDirection == 'n')
                        iy += tmp;
                    else if(currentDirection == 'e')
                        ix += tmp;
                    else if(currentDirection == 's')
                        iy -= tmp;
                    else if(currentDirection == 'w')
                        iy -= tmp;

                    num.setLength(0);
                }
                currentDirection = walk.charAt(i);
            }else {
                num.append(walk.charAt(i));
            }
        }

        int tmp = Integer.parseInt(num.toString());

        if(currentDirection == 'n')
            iy += tmp;
        else if(currentDirection == 'e')
            ix += tmp;
        else if(currentDirection == 's')
            iy -= tmp;
        else if(currentDirection == 'w')
            iy -= tmp;


        out.println(ix + " " + iy + " "+ fx + " " + fy);
        return (ix == fx) && (iy == fy);
    }
}
