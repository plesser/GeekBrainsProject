package lesson_09;

import java.util.Scanner;

public class MyArray {


    public static void main(String[] args) {

        int width = 4;
        int height = 4;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число столбцов");
        width = scanner.nextInt();
        System.out.print("Введите число строчек");

        height = scanner.nextInt();

        String array[][] = new String[height][width];



    }
}
