package lesson_03a;

import java.util.Arrays;

public class FindLostNumber {
    public static void main(String[] args) {
        //int[] array = {1, 2 ,3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16 };

        int[] array = {1, 2, 4, 5, 6}; // 18 21
        int lostNumber = findLostNumber(array);
        System.out.println(Arrays.toString(array) + " -> " + lostNumber);

        array = new int[]{};
        lostNumber = findLostNumber(array);
        System.out.println(Arrays.toString(array) + " -> " + lostNumber);


        array = new int[]{1, 2, 3, 4, 5, 6};
        lostNumber = findLostNumber(array);
        System.out.println(Arrays.toString(array) + " -> " + lostNumber);

        array = new int[]{2, 3, 4, 5, 6};
        lostNumber = findLostNumber(array);
        System.out.println(Arrays.toString(array) + " -> " + lostNumber);
    }

    private static int findLostNumber(int[] array) {
        if (array.length == 0 || array[0] == 2){
            return 1;
        }
        int cnt_num = array.length + 1;
        int expected_num_sum = cnt_num * (cnt_num + 1) / 2;
        int sum = 0;
        for (int i=0; i < array.length; i++){
            sum += array[i];
        }
        //System.out.println(cnt_num + " " + expected_num_sum + " " + sum);
        return expected_num_sum - sum;
    }
}
