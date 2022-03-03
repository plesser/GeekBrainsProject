package lesson_08a;

public class Cat implements Properies{
    int run;
    int jump;
    String name;
    boolean status = true;

    public Cat(String name, int run, int jump) {
        this.run = run;
        this.jump = jump;
        this.name = name;
    }


    @Override
    public boolean running(int length) {
        if (length > run) {
            System.out.println("Cat " + name + " out from racing (running), max is " + run);
            return false;
        } else {
            System.out.println("Cat " + name + " running successfully, max is ");
            return true;
        }

    }

    @Override
    public boolean jumping(int height) {
        if (height > jump) {
            System.out.println("Cat " + name + " out from racing (jumping), max is " + jump);
            return false;
        } else {
            System.out.println("Cat " + name + " jumping successfully" );
            return true;
        }
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
