package lesson_09;

public class MyArraySizeException extends Exception {

    String message;

    public MyArraySizeException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}