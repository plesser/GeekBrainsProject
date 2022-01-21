package lesson_04;

public class CatDemo4 {
    public static void main(String[] args) {
        Cat cat1 = new Cat();
        Cat cat2 = new Cat("Barsik");
        Cat cat3 = new Cat("Murzik", "White", 5);

        System.out.println("Cat1 name: " + cat1.getName() + ", color: " + cat1.color + ", age: " + cat1.age);
        System.out.println("Cat2 name: " + cat2.getName() + ", color: " + cat2.color + ", age: " + cat2.age);
        System.out.println("Cat3 name: " + cat3.getName() + ", color: " + cat3.color + ", age: " + cat3.age);

    }
}
