package homework_12;

import java.util.Arrays;

public class UnitSpeed {
    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;


    public static void main(String[] args) {
        float[] arr = new float[SIZE];

        for (int i=0; i < SIZE; i++){
            arr[i] = 1;
        }

        // ну поехали считать
        long start = System.currentTimeMillis();
        // формально нам не нужен результат, а нужно только время
        // поэтому функция нечего не возвращает
        Calc calc = new Calc(arr);
        calc.run();;
        long finish = System.currentTimeMillis();
        System.out.println("Затраченное время: " + (finish - start));

        // заново инициализируем массив
        for (int i=0; i < SIZE; i++){
            arr[i] = 1;
        }

        start = System.currentTimeMillis();

        float[] arr_1 = Arrays.copyOfRange(arr, 0, HALF);
        float[] arr_2 = Arrays.copyOfRange(arr, HALF, SIZE);

        Calc calc_1 = new Calc(arr_1);
        Calc calc_2 = new Calc(arr_2);

        calc_1.run();
        calc_2.run();

        System.arraycopy(calc_1.getData(), 0, arr, 0, HALF);
        System.arraycopy(calc_2.getData(), 0, arr, HALF, HALF);

        finish = System.currentTimeMillis();
        System.out.println("Затраченное время: " + (finish - start));


    }


    static class Calc implements Runnable{

        float[] data;

        public Calc(float[] data) {
            this.data = data;
        }

        public float[] getData() {
            return data;
        }

        @Override
        public void run() {
            for (int i =0; i < data.length; i++){
                data[i] = (float) (data[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i /5));
            }
        }


    }

}
