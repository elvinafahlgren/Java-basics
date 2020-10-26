package exercises.exam190819;

import static java.lang.System.out;

public class uppg5 {


    public static void main(String[] args) {
        new uppg5().program();
    }

    private void program() {
        String start = "bbaba";
        //out.println(rotate(start));
        out.println(lyndon(start));
    }

    String lyndon(String word){

        String[] rotations = getRotations(word);
        // out.println(Arrays.toString(rotations));

        // find smallest word
        String smallest = rotations[0];
        for(String w : rotations){
            if(smallest.compareTo(w) > 0){
                smallest = w;
            }
        }
        // out.println(smallest);

        return smallest;
    }

    String[] getRotations(String word){
        String[] rotations = new String[word.length()];

        String prevRotation = word;
        for(int i = 0; i < word.length(); i++){
            rotations[i] = rotate(prevRotation);
            prevRotation = rotations[i];
        }
        return rotations;
    }

    String rotate(String word){
        // substring
        String s = word.substring(1) + word.charAt(0);
        return s;
    }
}
