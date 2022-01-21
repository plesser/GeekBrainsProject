package homework_04;

// unit case for class Animal and Cat

public class UnitsAnimals {
    public static void main(String[] args) {

        System.out.println("------CAT-------");
        Cat cat = new Cat();
        System.out.println(cat.jump(1.5f));
        System.out.println(cat.jump(3));

        System.out.println(cat.run(200f));
        System.out.println(cat.run(300f));

        cat.setJump(3);
        System.out.println(cat.jump(3));

        System.out.println(cat.sail(200f));
        System.out.println("------DOG-------");
        Dog dog = new Dog();
        System.out.println(dog.jump(1.5f));
        System.out.println(dog.jump(3));

        System.out.println(dog.run(600f));
        System.out.println(dog.run(500f));

        dog.setJump(3);
        System.out.println(dog.jump(3));

        System.out.println(dog.sail(10f));
        System.out.println(dog.sail(15f));

        cat.setRun(700f);
        System.out.println(dog.run(700f));
    }
}
