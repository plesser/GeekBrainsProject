package lesson_08a;

public class Cat implements Properies{
    int run;
    int jump;
    String name;

    public Cat(String name, int run, int jump) {
        this.run = run;
        this.jump = jump;
        this.name = name;
    }


    @Override
    public boolean running(int length) {
        if (length > run) {
            System.out.println("Cat " + name + " out from racing (running)");
            return false;
        } else {
            System.out.println("Cat " + name + " running successfully" );
            return true;
        }

    }

    @Override
    public boolean jumping(int height) {
        if (height > jump) {
            System.out.println("Cat " + name + " out from racing (jumping)");
            return false;
        } else {
            System.out.println("Cat " + name + " jumping successfully" );
            return true;
        }
    }
}
