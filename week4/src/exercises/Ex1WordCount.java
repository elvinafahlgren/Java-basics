package exercises;

import java.util.*;

import static java.lang.System.in;
import static java.lang.System.out;
import static java.lang.String.*;

/*
 * Count number of words in some text
 *
 * See:
 * - UseCharacter
 * - UseString
 */
public class Ex1WordCount {

    public static void main(String[] args) {
        new Ex1WordCount().program();
    }

    void program() {
        out.println(countWords("") == 0);
        out.println(countWords("hello") == 1);
        out.println(countWords(" hello ") == 1);
        out.println(countWords("hello world") == 2);
        out.println(countWords("hello        world") == 2);
        out.println(countWords("   hello        world  ") == 2);
        String s = "Education is what remains after one has forgotten what one has learned in school.";
        out.println(countWords(s) == 14);

    }

    //--------------- Methods -----------------

    // TODO
    int countWords(String sentence){
        if (sentence == null || sentence.isEmpty())
            return 0;

        // Implement new list that splitting sentence at every space
        List<String> words = new ArrayList<String>(Arrays.asList(sentence.split("\\s+")));
        // Remove all empty places in list
        words.removeAll(Arrays.asList("", null));

        return words.size();
    }

}
