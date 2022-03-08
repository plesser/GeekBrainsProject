package lesson_03a;

public class QueueImpl <E> implements Queue<E>{
    protected final int DEFAUlT_TAIL = -1;
    protected final int DEFAULT_HEAD = 0;

    protected final E[] data;
    protected int size;
    protected int tail;
    protected int head;

    public QueueImpl(int maxSize) {
        this.data = (E[]) new Object[maxSize];
        tail = DEFAUlT_TAIL;
        head = DEFAULT_HEAD;
    }

    @Override
    public boolean insert(E value) {
        if (isFull()){
            return false;
        }

        data[++tail] = value;
        size++;

        return true;
    }

    @Override
    public E remove() {
        if (isEmpty()){
            return null;
        }

        E value = data[head];

        for (int i=1; i < size; i++){
            data[i-1] = data[i];
        }
        data[size-1] = null;
        //System.out.println(size);

        size--;
        tail--;

        return value;
    }

    @Override
    public E peekFront() {
        return data[head];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == data.length;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = head; i <= tail; i++){
            sb.append(data[i]);
            if (i != tail){
                sb.append(", ");
            }
        }
        return sb.append("]").toString();
    }
}
