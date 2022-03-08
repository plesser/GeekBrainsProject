package lesson_11;

import java.util.ArrayList;

public class ChangeItem {
    public static void main(String[] args) {
        ArrayList<String> strs = new ArrayList<>();
        strs.add("qqqqqqqq");
        strs.add("wwwwwwww");
        strs.add("eeeeeeee");
        strs.add("rrrrrrrr");
        strs.add("tttttttt");
        strs.add("yyyyyyyy");
        strs.add("uuuuuuuu");
        strs.add("iiiiiiii");
        strs.add("oooooooo");
        strs.add("pppppppp");

        System.out.println(strs);

        changeItem(strs, 3, 4);

        System.out.println(strs);
    }

    private static void changeItem(ArrayList<String> strs, int i1, int i2) {
        String tmp = strs.get(i1);
        strs.set(i1, strs.get(i2));
        strs.set(i2, tmp);
    }
}
