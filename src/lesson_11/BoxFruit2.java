package lesson_11;

import java.util.ArrayList;

public class BoxFruit2 {
    public static void main(String[] args) {
        // создаем первый ящик
        GenericBox<Apple> box1 = new GenericBox<>();
        box1.addFruit(new Apple());
        box1.addFruit(new Apple());
        box1.addFruit(new Apple());
        box1.addFruit(new Apple());

        System.out.println("В первом ящике лежит фруктов весом " + box1.getWeight());

        // создаем второй ящик
        GenericBox<Orange> box2 = new GenericBox<>();
        box2.addFruit(new Orange());
        box2.addFruit(new Orange());
        box2.addFruit(new Orange());
        //box2.addFruit(new Apple());  //wrong

        System.out.println("В втором ящике лежит фруктов весом " + box2.getWeight());

        // сравниваем первую со второй коробкой
        System.out.println(box1.compare(box2));

        box1.addFruit(new Apple());
        box1.addFruit(new Apple());
        box2.addFruit(new Orange());
        //box2.addFruit(new Apple()); // wrong
        System.out.println(box1.getWeight() + " " + box2.getWeight());
        System.out.println(box1.compare(box2));

        box1.moveFruits(box2);
        System.out.println(box1.getWeight() + " " + box2.getWeight());

    }


}
