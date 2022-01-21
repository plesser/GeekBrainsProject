package lesson_04;

public class Cat{
    private String name;
    protected String color;
    int age;

    public Cat(){
        System.out.println("Это конструктор класса Cat");
        this.name = "Unknown";
        this.color = "Unknown";
        this.age = 1;
    }

    public Cat(String _name, String _color,int _age){
        this.name = _name;
        this.color = _color;
        this.age = _age;
    }

    public Cat(String _name){
        this.name = _name;
        this.color = "Unknown";
        this.age = 1;
    }

    public void setAge(int age){
        if (age > 0){
            this.age = age;
        } else {
            System.out.println("Введен некорректный возраст");
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
