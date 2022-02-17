package homework_06a;

public class Animal {
    String name;
    int running;
    int swiming;

    static int cntCat = 0;
    static int cntDog = 0;

    public Animal(String name, int running, int swiming) {
        this.name = name;
        this.running = running;
        this.swiming = swiming;

        if (this.getClass().getName().split("\\.")[1].equals("Cat")){
            cntCat++;
        } else if (this.getClass().getName().split("\\.")[1].equals("Dog")){
            cntDog++;
        }
    }

    public void run(int distance){
        if (distance <= running){
            System.out.println(this.name + " пробежал(а) " +  distance + " метров");
        } else if (running == 0) {
            System.out.println(this.name + " не умеет бегать, видимо у него(нее) нет ножек");
        } else {
            System.out.println("Для " + this.name + " " + distance + " слишком большая дистанция.");
        }
    }
    public void swim(int distance){
        if (distance <= swiming){
            System.out.println(this.name + " проплыл(а) " +  distance + " метров");
        } else if (swiming == 0) {
            System.out.println(this.name + " не умеет плавать, видимо у него(нее) лапки");
        } else {
            System.out.println("Для " + this.name + " " + distance + " слишком большая дистанция.");
        }
    }

    public static int getCntCat() {
        return cntCat;
    }

    public static int getCntDog() {
        return cntDog;
    }

}
