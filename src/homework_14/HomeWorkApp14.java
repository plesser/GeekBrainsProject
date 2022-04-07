package homework_14;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.*;

public class HomeWorkApp14 {

    protected static final Logger log = Logger.getLogger("HomeWork14");

    public static void main(String[] args) {

        HomeWorkApp14 hw = new HomeWorkApp14();

        Handler handler = null;
        try {
            handler = new FileHandler("src/homework_14/log/mylog.log");
            handler.setFormatter(new Formatter() {
                @Override
                public String format(LogRecord logRecord) {
                    return String.format("%s\t%s\t%s\n", logRecord.getLevel(), new Date(), logRecord.getMessage());
                }
            });
            log.addHandler(handler);
        } catch (IOException e) {
            e.printStackTrace();
        }


        log.log(Level.INFO, "Написать метод, в который передается не пустой одномерный целочисленный массив, " +
                                   "метод должен вернуть true,  если в массиве есть место, в котором сумма левой и правой части массива равны.");
        boolean res;

        res = hw.checkArray(new int[]{2, 2, 2, 1, 2, 2, 10, 1});
        log.log(Level.INFO, "new int[]{2, 2, 2, 1, 2, 2, 10, 1} : " + res);
                System.out.println(res);

        res = hw.checkArray(new int[]{1, 1, 1, 1, 4});
        log.log(Level.INFO, "new int[]{1, 1, 1, 1, 4} : " + res);
        System.out.println(res);

        res = hw.checkArray(new int[]{1, 1, 1, 2, 5});
        log.log(Level.INFO, "new int[]{1, 1, 1, 2, 5} : " + res);
        System.out.println(res);

        log.log(Level.INFO, "Написать метод, которому на вход подается одномерный массив и число (может быть положительным, или отрицательным), " +
                                   " при этом метод должен сместить все элементы массива на n позиций." +
                                   " Элементы смещаются циклично. Для усложнения задачи нельзя пользоваться вспомогательными массивами." +
                                   " Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; " +
                                   " [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ]." +
                                   " При каком n в какую сторону сдвиг можете выбирать сами.");
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println("Array before: " + Arrays.toString(array));
        array = hw.shiftArray(array, 2);
        System.out.println("Array after: " + Arrays.toString(array));

        array = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println("Array before: " + Arrays.toString(array));
        array = hw.shiftArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, -2);
        System.out.println("Array after: " + Arrays.toString(array));
    }

    public int[] shiftArray(int[] array, int shift) {
        log.log(Level.INFO, "Array before: " + Arrays.toString(array));
        if (shift > 0){
            log.log(Level.INFO, "shift > 0");
            for (int s = 0; s < shift; s++) {
                int last = array[array.length - 1];
                for (int i = array.length - 1; i > 0; i--) {
                    array[i] = array[i - 1];
                }
                array[0] = last;
            }
        } else if (shift < 0){
            log.log(Level.INFO, "shift < 0");
            for (int s = 0; s < shift * (-1); s++) {
                int first = array[0];
                for (int i = 0; i < array.length - 1; i++) {
                    array[i] = array[i + 1];
                }
                array[array.length - 1] = first;
            }
        }

        log.log(Level.INFO, "Array after: " + Arrays.toString(array));
        return array;
    }

    public boolean checkArray(int[] array){
        boolean res = false;
        int index = 0;
        log.log(Level.INFO, "check array");

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
                log.log(Level.INFO, "find separator " + i);

                index = i;
                res = true;
                break;
            }
        }

        if (res) {
            log.log(Level.INFO, "res is true");
            /*
            for (int i = 0; i < array.length; i++) {
                if (i == index){
                    System.out.print(" | ");
                }
                System.out.print(array[i] + " ");
            }
            System.out.println();
             */
        } else {
            log.log(Level.INFO, "res is false");
        }

        return res;
    }

}
