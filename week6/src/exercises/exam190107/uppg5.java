package exercises.exam190107;

public class uppg5 {
    public static void main(String[] args) {
        new exercises.exam190107.uppg5().program();
    }

    private void program() {

        System.out.println(compress("aaaaaeeeefffw").equals("5a4e3f1w"));
        System.out.println(compress("qqqqqqqqqqqq").equals("12q"));
        System.out.println(compress("").equals(""));
        System.out.println(compress("x").equals("1x"));
    }

    String compress(String s){
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            int count = 1;

            while (i < s.length() - 1 && c == s.charAt(i + 1)){
                count++;
                i++;
            }
            sb.append(count);
            sb.append(c);
        }


        return sb.toString();
    }
}
