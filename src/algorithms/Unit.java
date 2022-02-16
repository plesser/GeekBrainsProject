package algorithms;

public class Unit {
    public static void main(String[] args) {
        int n = 10000;
        int step = 0;
        for (int j = 1; j < n; j *= 2) {       // 14
            step++;
        }
        System.out.println(step);

    }
}
