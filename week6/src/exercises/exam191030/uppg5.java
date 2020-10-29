package exercises.exam191030;

public class uppg5 {
    public static void main(String[] args) {
        new exercises.exam191030.uppg5().program();
    }

    final char NL = '\n'; // New line (last on all rows except the final one)
    final char SPACE = '.';

    private void program() {
        // Return string of n spaces (i.e n=3 gives "...")
        //String getSpaces(int n);

        System.out.println(format("aaa.bb.cc.dddd", 6)); //TODO INTE KLAR
    }

    String format(String str, int nCols){
        StringBuilder sb = new StringBuilder();
        StringBuilder currentRow = new StringBuilder();
        StringBuilder currentWord = new StringBuilder();
        char prev = 'o';

        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == SPACE)
                currentRow.append(SPACE);

            while(i < str.length() && str.charAt(i) != SPACE){
                currentWord.append(str.charAt(i));
                i++;
            }


            if(currentRow.length() + currentWord.length() <= nCols){
                currentRow.append(currentWord);
                currentWord.setLength(0);
                if(currentRow.length() < nCols)
                    currentRow.append(SPACE);
            }
            else if(i == str.length() - 1){
                sb.append(currentWord);
            }
            else{
                while(currentRow.length() <= nCols){
                    currentRow.append(SPACE);
                }
                sb.append(currentRow);
                sb.append(NL);
                currentRow.setLength(0);
                currentRow.append(currentWord);
            }
            //System.out.println(currentWord);
            //System.out.println(currentRow);

            currentWord.setLength(0);
        }
        return sb.toString();
    }
}
