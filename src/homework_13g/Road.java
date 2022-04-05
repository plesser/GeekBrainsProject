package homework_13g;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Road extends Stage {
    private Lock lock = new ReentrantLock();



    public Road(int length) {
        this.length = length;
        this.description = "Дорога " + length + " метров";
    }

    @Override
    public void go(Car c) {
        try {
            System.out.println(c.getName() + " начал этап: " + description);
            Thread.sleep(length / c.getSpeed() * 1000);
            System.out.println(c.getName() + " закончил этап: " + description);
            if (lock.tryLock()){
                System.out.println(c.getName() +" - WINNER !!!!!");
            }


        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }




}
