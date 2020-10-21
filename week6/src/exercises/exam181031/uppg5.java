package exercises.exam181031;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.System.out;


public class uppg5 {

    public static void main(String[] args) {
        new uppg5().program();
    }

    private void program() {
        String s = "me";
        out.println(stringToSubstring(s));
    }

    List<String> specialSubstrings(String s){
        List<String> specSub = stringToSubstring(s);

        return null;
    }

    List<String> stringToSubstring(String s){
        List<String> subs = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            for(int j = i + 1; j <= s.length(); j++){
                subs.add(s.substring(i, j));
            }
        }
        return subs;
    }

    boolean isSpecial(){
        return false;
    }
}
