package lesson_04;

public class CatDemo1 {
    public static void main(String[] args) {
        Cat cat1 = new Cat();
        Cat cat2 = new Cat();

        cat1.setName("Barsik");
        cat1.color = "White";
        cat1.age = 4;

        cat2.setName("Murzik");
        cat2.color = "Black";
        cat2.age = 6;

        System.out.println("Cat1 name: " + cat1.getName() + ", color: " + cat1.color + ", age: " + cat1.age);
        System.out.println("Cat2 name: " + cat2.getName() + ", color: " + cat2.color + ", age: " + cat2.age);
    }
}
