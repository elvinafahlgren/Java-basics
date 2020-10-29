/*
        Solution to question 5 here.
 */

import static java.lang.System.*;
import java.util.ArrayList;
import java.util.List;

public class Q5 {

    public static void main(String[] args) {
        new Q5().program();
    }

    private void program() {
        List<String> ex1 = new ArrayList<>(List.of("java", "kod", "gillar", "akademisk", "debug", "okej"));
        List<String> ex2 = new ArrayList<>(List.of("ab", "cd", "bc"));
        List<String> ex3 = new ArrayList<>(List.of("abc"));
        List<String> ex4 = new ArrayList<>(List.of("a", "b", "c"));
        List<String> ex5 = new ArrayList<>(List.of("ab", "bc", "xx"));

        out.println(longestSnake(ex1) == 6);
        out.println(longestSnake(ex2) == 3);
        out.println(longestSnake(ex3) == 1);
        out.println(longestSnake(ex4) == 1);
        out.println(longestSnake(ex5) == 2);
    }

    int longestSnake(List<String> words) {
        // TODO write code and return correct value
        int sum = 0;

        //testar alla olika ordlängder och lägger den längsta ordlängden till sum
        for(int i = 0; i < words.size(); i++){
            String startWord = words.get(i);
            List<String> temp = new ArrayList<>();
            for(String s : words)
                temp.add(s);

            temp.remove(i);
            int currentSum = getSnakeLength(startWord, temp);
            if(sum < currentSum)
                sum = currentSum;
        }

        return sum;
    }
    // TODO write code more methods if needed

    // Returnerar längden på en ordläng
    int getSnakeLength(String startWord, List<String> words){
        List<String> snakeList = new ArrayList<>(List.of(startWord));
        boolean stillFinding = true;
        while (stillFinding){
            String current = snakeList.get(snakeList.size() - 1);
            stillFinding = false;
            for(String s : words){
                if(current.charAt(current.length() - 1) == s.charAt(0)){
                    stillFinding = true;
                    snakeList.add(s);
                }
            }
        }
        return snakeList.size();
    }


    // You are allowed to call this method
    public List<List<String>> permutations(List<String> words) {

        return recPermutations(words.size(), words);
    }













    // Just helper methods, ignore these. DON'T CALL THEM!
    public List<List<String>> recPermutations(int n, List<String> words) {
        List<List<String>> newList = new ArrayList<List<String>>();
        List<List<String>> subList;

        if(n == 1) {
            newList.add( new ArrayList<String>(words) );    // Deep copy
        } else {
            for(int i = 0; i < n-1; i++) {
                subList = recPermutations(n - 1, words);
                for(List al : subList) {
                    newList.add(al);
                }
                if(n % 2 == 0) {
                    premutationsSwap(words, i, n-1);
                } else {
                    premutationsSwap(words, 0, n-1);
                }
            }
            subList = recPermutations(n - 1, words);
            for(List al : subList) {
                newList.add(al);
            }
        }

        return newList;
    }

    public void premutationsSwap(List<String> words, int i, int n) {
        String tmp = words.get(i);
        words.set(i, words.get(n));
        words.set(n, tmp);
    }
}