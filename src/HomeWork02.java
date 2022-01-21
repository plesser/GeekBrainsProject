import java.util.Arrays;

public class HomeWork02 {
    public static void main(String[] args) {
        // Задать целочисленный массив, состоящий из элементов 0 и 1.
        // Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
        // С помощью цикла и условия заменить 0 на 1, 1 на 0;

        int[] array_1 = { 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };

        System.out.println("Массив до:" + Arrays.toString(array_1));
        for (int i=0; i < array_1.length; i++){
            if (array_1[i] == 0) {
                array_1[i] = 1;
            } else {
                array_1[i] = 0;
            }
        }
        System.out.println("Массив после:" + Arrays.toString(array_1));

        // Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
        int[] array_2 = new int[8];
        for (int i=0; i < array_2.length; i++){
            if (i == 0){
                array_2[i] = i;
            } else {
                array_2[i] = array_2[i-1] + 3;
            }
        }
        System.out.println("Созданный массив:" + Arrays.toString(array_2));

        // Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ], пройти по нему циклом, и числа, меньшие 6, умножить на 2;
        int[] array_3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        System.out.println("Массив до:" + Arrays.toString(array_3));
        for (int i=0; i < array_3.length; i++){
            if (array_3[i] < 6){
                array_3[i] = array_3[i] * 2;
            }
        }
        System.out.println("Массив после:" + Arrays.toString(array_3));

        // Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
        // и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
        int[][] array_4 = new int[5][5];
        print2DArray("Массив до:", array_4);
        for (int i = 0; i < array_4.length; i++){
            for (int j=0; j < array_4[i].length; j++){
                if (i == j){
                    array_4[i][j] = 1;
                };
            }
        }
        print2DArray("Массив после:", array_4);

        // Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
        int[] array_5 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int max, min;

        min = array_5[0];
        max = array_5[0];

        for (int i=0; i < array_5.length; i++){
            if (array_5[i] > max){
                max = array_5[i];
            }
            if (array_5[i] < min){
                min = array_5[i];
            }
        }

        System.out.println("min = " + min + ", max = " + max);

        // Написать метод, в который передается не пустой одномерный целочисленный массив,
        // метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
        // Примеры: checkBalance([1, 1, 1, || 2, 1]) → true,
        // checkBalance ([2, 1, 1, 2, 1]) → false,
        // checkBalance ([10, || 10]) → true,
        // граница показана символами ||, эти символы в массив не входят;
        int[] array_6_1 = {1, 1, 1, 2, 1};
        int[] array_6_2 = {2, 1, 1, 2, 1};
        int[] array_6_3 = {10, 10};

        System.out.println(Arrays.toString(array_6_1) + " -> " + checkArray(array_6_1));
        System.out.println(Arrays.toString(array_6_2) + " -> " + checkArray(array_6_2));
        System.out.println(Arrays.toString(array_6_3) + " -> " + checkArray(array_6_3));

        // *Написать метод, которому на вход подается одномерный массив и число n (может быть положительным или отрицательным),
        // при этом метод должен сместить все элементы массива на n позиций. Нельзя пользоваться вспомогательными массивами.
        // ps
        // каюсь сам сделать не мог, чего то впал в ступор, даже стыдно
        // нашел решение в интернете от одного из автора курса.

        int[] array_7 = {7, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 8};
        int[] array_7_out;
        int shift = 1;
        System.out.println("Массив до сдвига: " + Arrays.toString(array_7));
        array_7_out = shiftArrary(array_7, shift);
        System.out.println("Массив по сдвига: " + Arrays.toString(array_7_out));
        shift = -1;
        System.out.println("Массив до сдвига: " + Arrays.toString(array_7));
        array_7_out = shiftArrary(array_7, shift);
        System.out.println("Массив по сдвига: " + Arrays.toString(array_7_out));


    }

    private static int[] shiftArrary(int[] array, int shift) {
        int val = 0;
        if (shift > 0){
            for (int s=0; s < shift; s++){
                val = array[0];
                array[0] = array[array.length - 1];

                for (int i = 1; i < array.length - 1; i++) {
                    array[array.length - i] = array[array.length - i - 1];
                }
                array[1] = val;
            }
        } else if (shift < 0) {
            for (int s=0; s > shift; s--) {
                val = array[array.length - 1];
                array[array.length - 1] = array[0];
                for (int i = 1; i < array.length - 1; i++) {
                    array[i - 1] = array[i];
                }

                array[array.length - 2] = val;
            }
        }

        return array;
    }


    private static boolean checkArray(int[] array) {
        boolean res = false;
        int sum1 = array[0];
        int sum2;
        int index = 0;
        for (int i=0; i < array.length-1; i++) {
            if (i != 0) {
                sum1 += array[i];
            }
            sum2 = array[i+1];
            for (int j = i+1; j < array.length; j++){
                if (j != i+1){
                    sum2 += array[j];
                }
            }

            if (sum1 == sum2){
                res = true;
                index = i;
                break;
            }

        }

        for (int i=0; i < array.length; i++){
            System.out.print(array[i] + ",");
            if (i == index && res == true){
                System.out.print(" || ");
            }
        }
        System.out.println();

        return res;
    }

    private static void print2DArray(String message, int[][] array) {
        System.out.println(message);
        for (int i=0; i < array.length; i++){
            for (int j=0; j < array[i].length; j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
