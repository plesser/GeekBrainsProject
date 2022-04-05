package homework_13g;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MainClass {

    public static final int CARS_COUNT = 4;


    public static void main(String[] args) throws InterruptedException {


        CountDownLatch countDownLatch = new CountDownLatch(CARS_COUNT);
        Semaphore semaphore = new Semaphore(CARS_COUNT / 2);
        Lock lock = new ReentrantLock();

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), countDownLatch, semaphore, lock);
        }


        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }


        Thread finish = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(15000);
                    System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        finish.start();




    }
}













//    CountDownLatch countDownLatch = new CountDownLatch(CARS_COUNT);
//
//        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
//    Race race = new Race(new Road(60), new Tunnel(), new Road(40));
//    Car[] cars = new Car[CARS_COUNT];
//        for (int i = 0; i < cars.length; i++) {
//        cars[i] = new Car(race, 20 + (int) (Math.random() * 10), countDownLatch);
//    }
//        for (int i = 0; i < cars.length; i++) {
//        new Thread(cars[i]).start();
//    }
//        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
//        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");



