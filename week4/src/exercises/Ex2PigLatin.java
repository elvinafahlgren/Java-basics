package exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.System.out;

/*
 *  Pig Latin, silly secret language
 *  https://en.wikipedia.org/wiki/Pig_Latin
 *
 *  See:
 *  - UseCharacter
 *  - UseStringBuilder  //använde knappt denna
 *  - UseString
 *  - ShortForLoop
 *
 */
public class Ex2PigLatin {

    public static void main(String[] args) {
        new Ex2PigLatin().program();
    }

    void program() {
        out.println(toPigLatin("My  name is Eric"));
        out.println(toPigLatin("My  name is Eric")
                .equals("yMay amenay isway Ericway "));     // gjorde en fuling och la till ett mellanslag längst bak
    }

    // ---------- Methods --------------------

    // TODO
    String toPigLatin(String sentence){
        if (sentence == null || sentence.isEmpty())
            return "";

        //StringBuilder sb = new StringBuilder(sentence);

        String output = "";
        List<String> words = new ArrayList<String>(Arrays.asList(sentence.split("\\s+"))); // works as long as we don't start with spaces

        for (String word : words){
            output += translateWord(word) + " ";  // Translates each word individually
        }

        return output;
    }

    String translateWord(String word){
        String pigLatinWord = "";
        StringBuilder SBword = new StringBuilder(word);
        int pos = 0;

        // Count which position the first vowel is at
        for(char c : word.toCharArray()){
            if(isVowel(c)){
                break;
            }
            else
                pos++;
        }

        // If the word starts with vowel, just put "way" behind
        if(pos == 0)
            return String.valueOf(SBword.insert(word.length(), "way"));

        // If the word has a vowel at its second position, put the first letter at the back, and finally "ay"
        else{
            SBword.append(word.substring(0, pos) + "ay");
            word = String.valueOf(SBword.delete(0, pos));
            return word;
        }
    }

    public static boolean isVowel(char c) {
        return "AEIOUYÅÄÖaeiouyåäö".indexOf(c) != -1;
    }
}
