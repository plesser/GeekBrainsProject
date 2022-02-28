package homework_07;

public class Cat {
    String name;
    int eat;
    boolean satiety = false;

    public Cat(String name, int eat) {
        this.name = name;
        this.eat = eat;
    }

     public void eat(Plate plate){
        if (!this.satiety) {
            if (plate.eat(this.eat)) {
                satiety = true;
                System.out.println("Cat " + name + " is satiety (cat eat " + eat + ")");
            } else {
                System.out.println("Cat " + name + " is not satiety (cat want " + eat + " unit eat, but in plate " + plate.eat + " )");
            }
        } else {
            System.out.println("Cat " + name + " already satiated");
        }
     }

    public boolean isSatiety() {
        return satiety;
    }

    public String getName() {
        return name;
    }
}
