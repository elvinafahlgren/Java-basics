package exercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

import static java.lang.System.out;

/**
 * A String problem
 * <p>
 * See:
 * - UseString
 */
public class Ex5StringOrdering {

    public static void main(String[] args) {
        new Ex5StringOrdering().program();
    }

    void program() {

        // Yes, "aa bb cc" is ordered like "abc" because all
        // a's are before all b's that are before all c's
        out.println(isOrdered("abc", "aa bb cc"));
        // Yes, all a's before all b's
        out.println(isOrdered("ab", "aa eee bb ddd cc"));
        // Yes, all e's before all c's
        out.println(isOrdered("ec", "aa eee becb c dddc"));

        // Not all c's are before all b's
        out.println(!isOrdered("acb", "aa bb cc"));
        // Not all b's before all c's
        out.println(!isOrdered("abc", "aa bb ccc b"));
        // No!
        out.println(!isOrdered("bac", "aa eee bbb ddd ccc"));

        // Degenerate cases
        out.println(isOrdered("a", "aa bb cc"));
        out.println(isOrdered("", "aa bb cc"));
        out.println(isOrdered("abc", ""));//TODO NOT WORKING
        out.println(!isOrdered("ax", "aa bb cc"));//TODO NOT WORKING
    }


    // -------- Methods ---------------

    // TODO
    boolean isOrdered(String ord, String str){
        if(ord.length() == 0 || str.length() == 0)
            return true;

        Deque<Character> queue = new ArrayDeque<>();

        for(char ch : str.toCharArray()){
            if(ord.indexOf(ch) != -1 && queue.isEmpty())
                queue.addLast(ch);
            else if(ord.indexOf(ch) != -1 && ch != queue.getLast()) //TODO MÅSTE VARA SISTA ELEMENTET I QUEUE
                queue.addLast(ch);

        }

        for(char ch : ord.toCharArray()){
            if(queue.isEmpty())
                return false;
            else if(ch == queue.getFirst())
                queue.pop();
            else
                return false;

        }

        if(queue.isEmpty())
            return true;
        else
            return false;




        /*
        *for(
        *
        *
        *
        */
        //return true;
    }


}
