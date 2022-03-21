package lesson_04a;

public interface TwoSideLinkdedList<E> extends LinkedList<E> {
    void insertLast(E value);
    E getLast();
}
