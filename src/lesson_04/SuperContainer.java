package lesson_04;

public class SuperContainer extends Container{
    protected int weight;

    public SuperContainer(int w, int h, int d, int m) {
        super(w, h, d);
        weight = m;
    }
}
