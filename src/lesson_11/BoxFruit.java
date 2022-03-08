package lesson_11;

import java.util.ArrayList;

public class BoxFruit {
    public static void main(String[] args) {
        ArrayList<Box> boxes = new ArrayList<>();

        // создаем первый ящик
        boxes.add(new Box());
        // работаем с ящиком 1
        boxes.get(0).addFruit(new Apple());
        boxes.get(0).addFruit(new Apple());
        boxes.get(0).addFruit(new Apple());
        boxes.get(0).addFruit(new Orange());

        System.out.println("В первом ящике лежит фруктов весом " + boxes.get(0).getWeight());
        // создаем второй ящик
        boxes.add(new Box());
        // работаем с ящиком
        boxes.get(1).addFruit(new Orange());
        boxes.get(1).addFruit(new Orange());
        boxes.get(1).addFruit(new Orange());
        boxes.get(1).addFruit(new Apple());

        System.out.println("Во втором ящике лежит фруктов весом " + boxes.get(1).getWeight());

        // сравниваем первую со второй коробкой
        System.out.println(boxes.get(1).compare(boxes.get(0)));
        boxes.get(0).addFruit(new Apple());
        boxes.get(0).addFruit(new Apple());
        boxes.get(0).addFruit(new Apple());
        boxes.get(1).addFruit(new Orange());
        //System.out.println(boxes.get(0).getWeight() + " " + boxes.get(1).getWeight());
        System.out.println(boxes.get(1).compare(boxes.get(0)));

        boxes.get(0).moveFruits(boxes.get(1));
        boxes.add(new Box());
        // работаем с ящиком
        boxes.get(2).addFruit(new Orange());
        boxes.get(2).addFruit(new Orange());
        boxes.get(2).addFruit(new Orange());

        boxInfo(boxes);
        boxes.get(0).moveFruits(boxes.get(1));
        boxInfo(boxes);
        boxes.get(1).moveFruits(boxes.get(2));
        boxInfo(boxes);

    }

    private static void boxInfo(ArrayList<Box> boxes) {
        System.out.println("Мы имеем " + boxes.size() + " ящика(ов)");
        for (Box box : boxes){
            if (box.getFruits().size() > 0) {
                System.out.println("В ящике #" + boxes.indexOf(box) + " лежит " + box.getFruits().get(0).getClass().getName().split("\\.")[1] + " в количестве " + box.getFruits().size());
            } else {
                System.out.println("Ящик #" + boxes.indexOf(box) + " пуст ");
            }
        }
    }
}
