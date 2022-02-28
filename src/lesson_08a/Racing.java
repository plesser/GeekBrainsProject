package lesson_08a;

import java.util.ArrayList;
import java.util.Random;

public class Racing {
    public static void main(String[] args) {
        Random rand = new Random();


        ArrayList<Properies> sportsmens = new ArrayList<>();
        sportsmens.add(new Man("Олег", rand.nextInt(10), rand.nextInt(10)));
        sportsmens.add(new Man("Тимофей", rand.nextInt(10), rand.nextInt(10)));
        sportsmens.add(new Man("Игорь",rand.nextInt(10), rand.nextInt(10)));

        // имена котэ реальны :)
        sportsmens.add(new Cat("Маша", rand.nextInt(10), rand.nextInt(10)));
        sportsmens.add(new Cat("Тоша", rand.nextInt(10), rand.nextInt(10)));
        sportsmens.add(new Cat("Барсик",rand.nextInt(10), rand.nextInt(10)));

        sportsmens.add(new Robot("Маша", rand.nextInt(10), rand.nextInt(10)));
        sportsmens.add(new Robot("Тоша", rand.nextInt(10), rand.nextInt(10)));
        sportsmens.add(new Robot("Барсик",rand.nextInt(10), rand.nextInt(10)));

        ArrayList<Item> racing = new ArrayList<>();
        racing.add(new Item(Item.Task.RUN, rand.nextInt(10)));
        racing.add(new Item(Item.Task.JUMP, rand.nextInt(10)));
        racing.add(new Item(Item.Task.RUN, rand.nextInt(10)));
        racing.add(new Item(Item.Task.JUMP, rand.nextInt(10)));
        racing.add(new Item(Item.Task.RUN, rand.nextInt(10)));
        racing.add(new Item(Item.Task.JUMP, rand.nextInt(10)));
        racing.add(new Item(Item.Task.RUN, rand.nextInt(10)));
        racing.add(new Item(Item.Task.JUMP, rand.nextInt(10)));

        for (Item d : racing){

        }

    }
}
