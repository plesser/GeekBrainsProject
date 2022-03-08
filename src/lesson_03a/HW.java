package lesson_03a;

public class HW {
    public static void main(String[] args) {
        testQueue();
    }

    private static void testQueue() {
        Queue<Integer> queue = new QueueImpl<>(4);
        System.out.println("add element " + queue.insert(34));
        System.out.println("add element " + queue.insert(12));
        System.out.println("add element " + queue.insert(20));
        System.out.println("add element " + queue.insert(16));
        System.out.println("add element " + queue.insert(14));

        queue.display();

        System.out.println("remove " + queue.remove());

        queue.display();

        System.out.println("remove " + queue.remove());

        queue.display();

        System.out.println("add element " + queue.insert(33));

        queue.display();

        System.out.println("add element " + queue.insert(44));

        queue.display();
    }
}
