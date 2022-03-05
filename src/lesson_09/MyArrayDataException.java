package lesson_09;

public class MyArrayDataException extends Exception{
    String message;

    public MyArrayDataException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }

}