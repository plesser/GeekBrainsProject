package lesson_11;

import java.util.ArrayList;

public class Box {
    ArrayList<Fruit> fruits;

    public Box(){
        fruits = new ArrayList<>();
    }

    public boolean addFruit(Fruit fruit){
        if (fruits.size() == 0){
            fruits.add(fruit);
            System.out.println("Ящик был пуст, потому я просто положу в него фрукт");
            return true;
        } else {
            String currentFruit = fruits.get(0).getClass().getName().split("\\.")[1];
            String newFruit = fruit.getClass().getName().split("\\.")[1];
            if (currentFruit.equals(newFruit)){
                fruits.add(fruit);
                System.out.println("Фрукт положен");
                return true;
            } else {
                System.out.println("В ящики уже лежат другие фрукты");
                return false;
            }
        }
    }

    public boolean moveFruits(Box box){
        if (fruits.size() == 0){
            fruits.addAll(box.getFruits());
            box.getFruits().clear();
            System.out.println("Ящик был пуст, потому я просто переложу в него фрукты");
            return true;
        } else {
            String currentFruit = fruits.get(0).getClass().getName().split("\\.")[1];
            String newFruit = box.getFruits().get(0).getClass().getName().split("\\.")[1];
            if (currentFruit.equals(newFruit)){
                fruits.addAll(box.getFruits());
                box.getFruits().clear();
                System.out.println("Фрукты переложены");
                return true;
            } else {
                System.out.println("В ящики уже лежат другие фрукты");
                return false;
            }
        }
    }

    public double getWeight(){
        double sum = 0;
        for (Fruit fruit : fruits){
            sum += fruit.weight;
        }
        return sum;
    }

    public boolean compare(Box box){
        if (this.getWeight() == box.getWeight()){
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Fruit> getFruits() {
        return fruits;
    }


}
