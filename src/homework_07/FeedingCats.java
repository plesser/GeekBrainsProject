package homework_07;

import java.util.Random;

public class FeedingCats {
    public static void main(String[] args) {
        Cat[] cats = new Cat[10];
        Plate plate = new Plate(30);

        Random rand = new Random();

        for (int i=0; i < cats.length; i++){
            Cat cat = new Cat("Cat #" + i, rand.nextInt(10) + 4);
            cats[i] = cat;
        }

        statusCats(cats);

        plate.infoPlate();
        eatCats(cats, plate);
        plate.infoPlate();

        statusCats(cats);

        plate.infoPlate();
        plate.addEat(30);
        plate.infoPlate();

        eatCats(cats, plate);
        plate.infoPlate();

        statusCats(cats);
    }

    private static void eatCats(Cat[] cats, Plate plate) {
        for (int i = 0; i < cats.length; i++){
            cats[i].eat(plate);
        }
        System.out.println("----------------------------------------------------");
    }

    private static void statusCats(Cat[] cats) {
        for (int i = 0; i < cats.length; i++) {
            System.out.println(cats[i].getName() + " is " + cats[i].isSatiety());
        }
        System.out.println("----------------------------------------------------");
    }
}
