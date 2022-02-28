package lesson_08a;

public class Item {
    public enum Task {
        RUN,
        JUMP
    }

    Task task;
    int val;

    public Item(Task task, int val) {
        this.task = task;
        this.val = val;
    }
}
