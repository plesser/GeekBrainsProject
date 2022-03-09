package lesson_11;

import java.util.ArrayList;

public class BoxFruit2 {
    public static void main(String[] args) {
        ArrayList<GenericBox> boxes = new ArrayList<>();

        // создаем первый ящик
        GenericBox<Apple> box1 = new GenericBox<>();
        box1.addFruit(new Apple());
        box1.addFruit(new Apple());
        box1.addFruit(new Apple());
        box1.addFruit(new Apple());

        System.out.println("В первом ящике лежит фруктов весом " + box1.getWeight());
        boxes.add(box1);


        // создаем второй ящик
        GenericBox<Orange> box2 = new GenericBox<>();
        box2.addFruit(new Orange());
        box2.addFruit(new Orange());
        box2.addFruit(new Orange());
        //box2.addFruit(new Apple());  //wrong

        System.out.println("В втором ящике лежит фруктов весом " + box2.getWeight());
        boxes.add(box2);



        // сравниваем первую со второй коробкой
        System.out.println(boxes.get(1).compare(boxes.get(0)));

        boxes.get(0).addFruit(new Apple());
        boxes.get(0).addFruit(new Apple());
        boxes.get(1).addFruit(new Apple());
        boxes.get(1).addFruit(new Orange());
        //System.out.println(boxes.get(0).getWeight() + " " + boxes.get(1).getWeight());
        System.out.println(boxes.get(1).compare(boxes.get(0)));

        System.out.println(boxes.get(0).toString());
        System.out.println(boxes.get(1).toString());

        //System.out.println(boxes.size());

        //boxes.get(0).moveFruits(boxes.get(1));
        //System.out.println(boxes.get(0).getWeight() + " " + boxes.get(1).getWeight());

        /*
        boxes.add(new GenericBox());
        // работаем с ящиком
        boxes.get(2).addFruit(new Orange());
        boxes.get(2).addFruit(new Orange());
        boxes.get(2).addFruit(new Orange());

        boxInfo(boxes);
        boxes.get(0).moveFruits(boxes.get(1));
        boxInfo(boxes);
        boxes.get(1).moveFruits(boxes.get(2));
        boxInfo(boxes);
        */
    }


    private static void boxInfo(ArrayList<GenericBox> boxes) {
        System.out.println("Мы имеем " + boxes.size() + " ящика(ов)");
        for (GenericBox box : boxes){
            if (box.getFruits().size() > 0) {
                System.out.println("В ящике #" + boxes.indexOf(box) + " лежит " + box.getFruits().get(0).getClass().getName().split("\\.")[1] + " в количестве " + box.getFruits().size());
            } else {
                System.out.println("Ящик #" + boxes.indexOf(box) + " пуст ");
            }
        }
    }
}
