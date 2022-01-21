package lesson_02;

import java.util.Arrays;

public class MyArray {
    public static void main(String[] args) {
        // Одномерные массивы
        int[] arr = new int[5];
        int i = 0;

        arr[i] = i++;
        arr[i] = i++;
        arr[i] = i++;
        arr[i] = i++;
        arr[i] = i++;

        System.out.println(Arrays.toString(arr));

        int[] num = {5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(num));

        // Двумерные массивы
        int[][] table1 = new int[3][2];
        table1[0][0] = 1;
        table1[1][0] = 2;
        table1[2][0] = 2;
        table1[0][1] = 3;
        table1[1][1] = 4;
        table1[2][1] = 5;

        // Нерегулярные массивы
        int[][] table2 = new int[3][];
        table2[0] = new int[1];
        table2[1] = new int[5];
        table2[2] = new int[3];

        // Многомерные массивы
        int[][][] mdarr = new int[2][3][4];

        // Альтернативный синтаксис объявления массивов
        int arr1[] = new int[3];
        int[] arr2 = new int[3];

        // Получение длины массива
        int[] arr3 = {2, 4, 5, 1, 2, 3, 4, 5};
        System.out.println("arr.length: " + arr3.length);
        for (int j = 0; j < arr3.length; j++) {
            System.out.print(arr3[j] + " ");
        }
    }
}
