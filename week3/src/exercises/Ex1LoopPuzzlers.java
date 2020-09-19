package exercises;

import static java.lang.System.out;

/*
 *  Some puzzlers
 *  General improvement of programming skills
 *
 *  See:
 *  - LoopPuzzler
 */
public class Ex1LoopPuzzlers {

    public static void main(String[] args) {
        new Ex1LoopPuzzlers().program();
    }


    void program() {
        // TODO Write solution (for loops) directly here
        for(int i = 1; i <= 10; i++){
            out.print('\n');
            for(int j = 1; j <= 10; j++){
                out.print(i * j + " ");
            }
        }

        for(int i = 0; i < 10; i++){
            out.print('\n');
            for(int j = 0; j < i; j++){
                out.print("X");
            }
        }

        for(int i = 0; i <= 10; i++){
            out.print('\n');
            for(int j = 0; j < i; j++){
                out.print(" ");
            }
            out.print("XXXXXXXXXX");
        }

    }
}
