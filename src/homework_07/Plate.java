package homework_07;

public class Plate {
    int eat;

    public Plate(int eat) {
        this.eat = eat;
    }

    public boolean eat(int eat){
        if (eat > this.eat){
            return false;
        } else {
            this.eat -= eat;
            return true;
        }
    }

    public void addEat(int eat){
        this.eat += eat;
    }

    public void infoPlate(){
        System.out.println("In plate is " + eat + " unit  of eat");
        System.out.println("----------------------------------------------------");

    }
}
