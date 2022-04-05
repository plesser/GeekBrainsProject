package homework_13g;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private Race race;
    private int speed;
    private String name;

    private CountDownLatch countDownLatch;
    private Semaphore semaphore;
    private Lock lock = new ReentrantLock();


    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed, CountDownLatch countDownLatch, Semaphore semaphore, Lock lock) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.countDownLatch = countDownLatch;
        this.semaphore = semaphore;
        this.lock = lock;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
                System.out.println(this.name + " готовится");
                Thread.sleep(500 + (int) (Math.random() * 800));
                System.out.println(this.name + " готов");
                countDownLatch.countDown(); //отсчитываем готовность каждой машины и уменьшаем счетчик
                countDownLatch.await(); // ждем всех участников
                System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");

            } catch (Exception e) {
                e.printStackTrace();
            }


            for (int i = 0; i < race.getStages().size(); i++) {
                race.getStages().get(i).go(this);

            }




        }





    }






