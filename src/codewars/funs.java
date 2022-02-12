package codewars;

import java.util.Locale;

public class funs {
    public static void main(String[] args) {
        String res;
        res = accum("abcd");
        System.out.println(res);
        res = accum("RqaEzty");
        System.out.println(res);
        res = accum("cwAt");
        System.out.println(res);
    }

    private static String accum(String s) {
        int step = 1;
        String res = "";
        for (char ch: s.toCharArray()){
            for (int i=0; i < step; i++ ){
                if (i == 0) {
                    res += Character.toString(ch).toUpperCase();
                } else {
                    res += Character.toString(ch).toLowerCase();
                }
            }
            res += "-";
            step++;
        }

        return res.substring(0, res.length()-1);
    }
}
