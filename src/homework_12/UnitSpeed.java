package homework_12;

import java.util.Arrays;

public class UnitSpeed {
    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;


    public static void main(String[] args) throws InterruptedException {
        float[] arr = new float[SIZE];

        for (int i=0; i < SIZE; i++){
            arr[i] = 1;
        }

        // ну поехали считать
        long start = System.currentTimeMillis();

        Calc calc = new Calc(arr, 0);
        calc.run();;
        arr = calc.getData();
        long finish = System.currentTimeMillis();
        System.out.println("Затраченное время: " + (finish - start));

        display(arr);

        //System.out.println("step 1 -> " + Arrays.toString(arr));

        // заново инициализируем массив
        for (int i=0; i < SIZE; i++){
            arr[i] = 1;
        }

        float[] arr_1 = new float[HALF];
        float[] arr_2= new float[HALF];

        start = System.currentTimeMillis();

        System.arraycopy(arr, 0, arr_1, 0, HALF);
        System.arraycopy(arr, HALF, arr_2, 0, HALF);

        //System.out.println(Arrays.toString(arr_1));
        //System.out.println(Arrays.toString(arr_2));

        Calc calc_1 = new Calc(arr_1, 0);
        Calc calc_2 = new Calc(arr_2, HALF);

        Thread t1 = new Thread(calc_1);
        Thread t2 = new Thread(calc_2);

        t1.start();
        t2.start();


        t1.join();
        t2.join();

        arr_1 = calc_1.getData();
        arr_2 = calc_2.getData();

        //System.out.println(Arrays.toString(arr_1));
        //System.out.println(Arrays.toString(arr_2));

        System.arraycopy(arr_1, 0, arr, 0, HALF);
        System.arraycopy(arr_2, 0, arr, HALF, HALF);

        //System.out.println(Arrays.toString(arr));


        finish = System.currentTimeMillis();
        System.out.println("Затраченное время: " + (finish - start));

        display(arr);

    }

    static void display(float[] arr){
        System.out.println(arr[0] + " " + arr[HALF] + " " + arr[SIZE-1]);
    }


    static class Calc implements Runnable{

        float[] data;
        int shift;

        public Calc(float[] data, int shift) {
            this.data = data;
            this.shift = shift;
        }

        public float[] getData() {
            return data;
        }

        @Override
        public void run() {
            for (int i =0; i < data.length; i++){
                data[i] = (float) (data[i] * Math.sin(0.2f + (i + shift) / 5) * Math.cos(0.2f + (i + shift)  /5) * Math.cos(0.4f + (i + shift) / 2));
            }
        }


    }

}
