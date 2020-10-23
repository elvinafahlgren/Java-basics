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
        out.println(specialSubstrings(s));
    }

    List<String> specialSubstrings(String s){
        List<String> subs = stringToSubstring(s);
        List<String> specSub = new ArrayList<>();
        for(String str : subs){
            char first = str.charAt(0);
            char last = str.charAt(str.length() - 1);
            if(isVowel(first) && !isVowel(last) || !isVowel(first) && isVowel(last))
                specSub.add(str);
        }
        return specSub;
    }

    // Do a List of all substrings of the word
    List<String> stringToSubstring(String s){
        List<String> subs = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            for(int j = i + 1; j <= s.length(); j++){
                subs.add(s.substring(i, j));
            }
        }
        return subs;
    }

    boolean isVowel(char c){
        return "aeiouy".indexOf(c) >= 0;
    }
}
