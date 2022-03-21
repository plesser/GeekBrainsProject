package lesson_04a;

public interface Deque<E> extends Queue {
    boolean insertLeft(E value);
    boolean insertRight(E value);

    E removeLeft();
    E removeRight();
}
