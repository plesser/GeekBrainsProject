import java.util.Arrays;

public class HomeWorkApp3 {
    public static void main(String[] args) {
        // 1. Задать целочисленный массив, состоящий из элементов 0 и 1.
        // Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
        changeOneZero();

        // 2. Задать пустой целочисленный массив длиной 100. С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 … 100;
        initArray();

        // 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
        transformArray();

        // 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
        // и с помощью цикла(-ов) заполнить его диагональные элементы единицами (можно только одну из диагоналей, если обе сложно).
        // Определить элементы одной из диагоналей можно по следующему принципу: индексы таких элементов равны,
        // то есть [0][0], [1][1], [2][2], …, [n][n];
        initOneArray(5);

        // 5. Написать метод, принимающий на вход два аргумента: len и initialValue, и возвращающий одномерный массив типа int длиной len,
        // каждая ячейка которого равна initialValue;
        int array[] = getArray(5, 10);
        System.out.println(Arrays.toString(array));

        // 6. * Задать одномерный массив и найти в нем минимальный и максимальный элементы ;
        findMinMax();

        // 7. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
        // если в массиве есть место, в котором сумма левой и правой части массива равны.
        System.out.println(checkArray(new int[]{2, 2, 2, 1, 2, 2, 10, 1}));
        System.out.println(checkArray(new int[]{1, 1, 1, 1, 4}));
        System.out.println(checkArray(new int[]{1, 1, 1, 2, 5}));

        // Написать метод, которому на вход подается одномерный массив и число n
        // (может быть положительным, или отрицательным), при этом метод должен сместить все элементы массива на n позиций.
        // Элементы смещаются циклично. Для усложнения задачи нельзя пользоваться вспомогательными массивами.
        // Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ];
        // [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].
        // При каком n в какую сторону сдвиг можете выбирать сами.
        shiftArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 2);
        shiftArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, -2);
    }

    private static void shiftArray(int[] array, int shift) {
        System.out.println("Array before: " + Arrays.toString(array));
        if (shift > 0){
            for (int s = 0; s < shift; s++) {
                int last = array[array.length - 1];
                for (int i = array.length - 1; i > 0; i--) {
                    array[i] = array[i - 1];
                }
                array[0] = last;
            }
        } else if (shift < 0){
            for (int s = 0; s < shift * (-1); s++) {
                int first = array[0];
                for (int i = 0; i < array.length - 1; i++) {
                    array[i] = array[i + 1];
                }
                array[array.length - 1] = first;
            }
        }

        System.out.println("Array after: " + Arrays.toString(array));
    }

    private static boolean checkArray(int[] array){
        boolean res = false;
        int index = 0;

        int summa1, summa2;

        for (int i=1; i < array.length; i++){
            summa1 = 0;
            summa2 = 0;
            for (int beg=0; beg < i; beg++){
                summa1 += array[beg];
            }
            for (int beg=i; beg < array.length; beg++){
                summa2 += array[beg];
            }

            if (summa1 == summa2){
                index = i;
                res = true;
                break;
            }
        }

        if (res) {
            for (int i = 0; i < array.length; i++) {
                if (i == index){
                    System.out.print(" | ");
                }
                System.out.print(array[i] + " ");
            }
            System.out.println();
        }

        return res;
    }

    private static void findMinMax() {
        int array[] = {10, 5, 44, 33, 1, -5, 5, -66};
        int max = array[0];
        int min = array[1];

        for (int i=0; i < array.length; i++){
            if (array[i] > max){
                max = array[i];
            }
            if (array[i] < min){
                min = array[i];
            }
        }
        System.out.println(Arrays.toString(array));
        System.out.println("min is " + min + ", max is " + max);
    }

    private static int[] getArray(int len, int initialValue) {
        int array[] = new int[len];
        for (int i=0; i < array.length; i++){
            array[i] = initialValue;
        }
        return array;
    }

    private static void initOneArray(int size) {
        int array[][] = new int[size][size];
        for (int i=0; i < array.length; i++){
            array[i][i] = 1;
            array[array.length - i - 1][i] = 1;
        }

        for (int i=0; i < array.length; i++){
            System.out.println(Arrays.toString(array[i]));
        }

    }

    private static void transformArray() {
        int array[] = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Array before: " + Arrays.toString(array));
        for (int i=0; i < array.length; i++){
            if (array[i] < 6){
                array[i] *= 2;
            }
        }
        System.out.println("Array after: " + Arrays.toString(array));
    }

    private static void initArray() {
        int array[] = new int[100];
        for (int i=0; i < array.length; i++){
            array[i] = i;
        }
        System.out.println(Arrays.toString(array));
    }

    private static void changeOneZero() {
        int array[] = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println("Array before: " + Arrays.toString(array));
        for (int i=0; i < array.length; i++){
            if (array[i] == 0){
                array[i] = 1;
            } else {
                array[i] = 0;
            }
        }
        System.out.println("Array after: " + Arrays.toString(array));
    }
}
