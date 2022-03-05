package lesson_09;

import java.util.Random;
import java.util.Scanner;

public class MyArray {


    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {

        int width = 4;
        int height = 4;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число столбцов: ");
        width = scanner.nextInt();

        System.out.print("Введите число строчек: ");
        height = scanner.nextInt();

        checkSizeArray(width, height);

        String array[][] = new String[height][width];

        // init array
        array[0][0] = "123";
        array[0][1] = "234";
        array[0][2] = "345.5";
        array[0][3] = "444";

        array[1][0] = "234";
        array[1][1] = "123";
        array[1][2] = "123";
        array[1][3] = "111";

        array[2][0] = "345";
        array[2][1] = "345";
        array[2][2] = "345";
        array[2][3] = "123";

        array[3][0] = "456";
        array[3][1] = "456";
        array[3][2] = "456";
        array[3][3] = "234";

        int val = 0;

        for (int i=0; i < height; i++){
            for (int j = 0; j < width; j++){
                try {
                    val = val + Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Don't convert String to Int, value is '" + array[i][j] + "' height = " + i + ", width = " + j);
                }
            }
        }

        System.out.println("Summa all elements is " + val);

    }

    private static void checkSizeArray(int width, int height) throws MyArraySizeException {
        if (width != 4 || height != 4){
            throw new MyArraySizeException("Size matrix is wrong, you input " + width + " and " + height + ", but must 4 and 4");
        }
    }

}
