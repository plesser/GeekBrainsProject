package lesson_01;

public class Operation {
    public static void main(String[] args) {
        int a = getSum();

        System.out.println(a);

        System.out.println(getSum(2, 3));

        int result1 = getSum(4, 6);
        int result2 = getSum(5, 7);

        System.out.println(result1);
        System.out.println(result2);

        int a1 = multiply(5, 3);
        int b1 = (int) multiply(5.5);

        System.out.println(a1);
        System.out.println(b1);
    }

    static int getSum() {
        int x = 2;
        int y = 3;

        return x + y;
    }

    static int getSum(int x, int y){
        return x + y;
    }


    static int multiply(int x, int y){
        return x * y;
    }

    static double multiply(double x){
        return x * x;
    }
}
