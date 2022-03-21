package lesson_11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ArrayList;

public class GenericBox<E extends Fruit> {
    private ArrayList<E> fruits;

    public GenericBox(){
        fruits = new ArrayList<>();
    }

    public boolean addFruit(E fruit){

        fruits.add((E) fruit);
        return true;
    }

    public boolean moveFruits(GenericBox box){
        fruits.addAll(box.getFruits());
        box.getFruits().clear();
        return true;
    }


    public double getWeight(){
        double sum = 0;
        for (Fruit fruit : fruits){
            sum += fruit.weight;
        }
        return sum;
    }


    public ArrayList<E> getFruits() {
        return fruits;
    }

    public boolean compare(GenericBox box){
        System.out.println(this.getWeight() + " " + box.getWeight());
        if (this.getWeight() == box.getWeight()){
            return true;
        } else {
            return false;
        }
    }


    @Override
    public String toString() {
        return "GenericBox{" +
                "fruits=" + fruits +
                '}';
    }
}