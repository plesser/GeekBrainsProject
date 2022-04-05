package lesson_13;

import java.util.concurrent.CountDownLatch;

public class SimpleCDL {
    public static void main(String[] args) {
        final int THREADS_COUNT = 4;
        final CountDownLatch cdl = new CountDownLatch(THREADS_COUNT);

        System.out.println("Начинаем");

        for (int i = 0; i < THREADS_COUNT; i++ ){
            final int w = i;
            new Thread(() -> {
                try {
                    Thread.sleep(500 + (int) (500 * Math.random()));

                    cdl.countDown();
                    System.out.println(" Поток #" + w + " - готов");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Работа завершена");
        }
    }
}