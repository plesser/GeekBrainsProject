package lesson_08a;

import java.util.ArrayList;
import java.util.Random;

public class Racing {
    public static void main(String[] args) {
        Random rand = new Random();


        ArrayList<Properies> sportsmens = new ArrayList<>();
        sportsmens.add(new Man("Олег", rand.nextInt(10), rand.nextInt(20)));
        sportsmens.add(new Man("Тимофей", rand.nextInt(10), rand.nextInt(20)));
        sportsmens.add(new Man("Игорь",rand.nextInt(10), rand.nextInt(20)));

        // имена котэ реальны :)
        sportsmens.add(new Cat("Маша", rand.nextInt(20), rand.nextInt(20)));
        sportsmens.add(new Cat("Тоша", rand.nextInt(20), rand.nextInt(20)));
        sportsmens.add(new Cat("Барсик",rand.nextInt(20), rand.nextInt(20)));

        sportsmens.add(new Robot("Маша", rand.nextInt(20), rand.nextInt(20)));
        sportsmens.add(new Robot("Тоша", rand.nextInt(20), rand.nextInt(20)));
        sportsmens.add(new Robot("Барсик",rand.nextInt(20), rand.nextInt(20)));

        ArrayList<Item> racing = new ArrayList<>();
        racing.add(new Item(Item.Task.RUN, rand.nextInt(10) + 1));
        racing.add(new Item(Item.Task.JUMP, rand.nextInt(10) + 1));
        racing.add(new Item(Item.Task.RUN, rand.nextInt(10) + 1));
        racing.add(new Item(Item.Task.JUMP, rand.nextInt(10) + 1));
        racing.add(new Item(Item.Task.RUN, rand.nextInt(10)+ 1));
        racing.add(new Item(Item.Task.JUMP, rand.nextInt(10) + 1));
        racing.add(new Item(Item.Task.RUN, rand.nextInt(10) + 1));
        racing.add(new Item(Item.Task.JUMP, rand.nextInt(10) + 1));

        for (Item item : racing){
            System.out.println("--------" + item.getTask() + "----------" + item.getVal() + "------------------");
            for (Properies racer : sportsmens) {
                if (racer.isStatus()) {
                    if (item.getTask() == Item.Task.JUMP) {
                        if (racer.jumping(item.getVal())) {

                        } else {
                            racer.setStatus(false);
                            continue;
                        }
                    } else {
                        if (racer.running(item.getVal())) {

                        } else {
                            racer.setStatus(false);
                            continue;
                        }
                    }
                }
            }
            System.out.println("-----------------------------------------------");
        }

    }
}
