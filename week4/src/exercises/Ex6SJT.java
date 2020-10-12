package exercises;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

/*
   Using Steinhaus-Johnson-Trotter (non-recursive) algorithm for permutations
   See https://en.wikipedia.org/wiki/Steinhaus%E2%80%93Johnson%E2%80%93Trotter_algorithm

   See:
   - UseString
   - UseAList
 */
public class Ex6SJT { //TODO INTE KLAR

    public static void main(String[] args) {
        new Ex6SJT().program();
    }

    private void program() {
        // Call permutation method
        List<String> perms = permutationSJT("123456");
        // Replace null with permutationSJT("123456");

        out.println(perms.size());  // 720
        for (String s : perms) {
            out.println(s);
        }

        int count = 0;
        for (String s : perms) {
            if (s.equals("123456")) {
                count++;
            }
        }
        out.println(count == 1);
    }

    // Steinhaus–Johnson–Trotter permutation algorithm iterative!
    // Use functional decomposition!
    // TODO
    List<String> permutationSJT(String str){
        List<String> perms = new ArrayList<>();
        perms.add(str);
        int length = 1;
        int x_pos = str.length() - 1;
        //int x = Integer.parseInt(str.substring(str.length() - 1)); //last element in string
        out.println(x_pos);

        // get length of perms
        for(int i = 1; i <= str.length(); i++)
            length = length * i;
        out.println(length);


        for(int i = 0; i < length; i++){
            int pos_y;
            if(isEven(perms.get(i)))
                pos_y = i - 1;
            else
                pos_y = i + 1;
        }
        return perms;
    }

    boolean isEven(String str){
        
        return true;
    }

    int findLargestNr(List<String> perms){
        int maxIndex = 0;

        //for(int i = 0; i < perms)
        return 0;
    }

}