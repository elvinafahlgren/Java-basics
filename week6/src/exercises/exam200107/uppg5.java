package exercises.exam200107;

import static java.lang.System.out;

public class uppg5 {
    public static void main(String[] args) {
        new uppg5().program();
    }

    private void program() {
        out.println(girlangOrd(""));

        out.println("jackhammer blir: " + girlangOrd("jackhammer"));

        out.println("zvioz blir: " + girlangOrd("zvioz"));

        out.println("aaaa blir: " + girlangOrd("aaaa"));

        out.println("alfalfa blir: " + girlangOrd("alfalfa"));

    }

    String girlangOrd(String s){
        String subs = delSträng(s);
        if(subs.equals(""))
            return s;

        String subsRemoved = s.substring(subs.length());

        for(char c : subs.toCharArray())
            s += subsRemoved;

        return s;
    }

    String delSträng(String s){
        for(int i = 0; i < s.length() - 1; i++){
            String str = s.substring(0, (s.length() - 1 - i));
            if(str.equals(s.substring((i + 1)))){
                return str;
            }
        }
        return "";
    }

}
