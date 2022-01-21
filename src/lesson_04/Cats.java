package lesson_04;

public class Cats extends Beast{
    protected String color;

    public Cats(String name, int paswNumber, String color){
        this.name = name;
        this.pawsNumber = paswNumber;
        this.color = color;
    }

    public Cats(String name, String color){
        this.name = name;
        this.color = color;
    }

    public void catInfo(){
        System.out.println("Cat name: " + name + ", color: " + color);
    }
}
