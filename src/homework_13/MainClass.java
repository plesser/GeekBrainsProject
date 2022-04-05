package homework_13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class MainClass {
    public static final int CARS_COUNT = 4;

    public static void main(String[] args) {
        CountDownLatch cdl = new CountDownLatch(CARS_COUNT);
        Semaphore semaphore = new Semaphore(CARS_COUNT/2);

        List<String> results = Collections.synchronizedList(new ArrayList<String>());

        System.out.println("Важное объявление >>> Подготовка");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];

        for (int i=0; i < cars.length; i++){
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), cdl, semaphore, results);
        }


        Thread thread[] = new Thread[CARS_COUNT];

        for (int i = 0; i < cars.length; i++){
            thread[i] = new Thread(cars[i], "cars #" + i);
            thread[i].start();
        }

        // ждем пока счетчик не обнулится
        while (cdl.getCount() != 0) {

        }
        System.out.println("Важное объявление >>> Гонка началась!!!");


        try {
        for (int i = 0; i < cars.length; i++){
                thread[i].join();
        }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Важное объявление >>> Гонка закончилась!!!");
        // когда все гонщики все финишировали

        System.out.println("Важное объявление >>> Результаты заезда!!!");
        for (String name : results){
            System.out.println(name);
        }
    }
}