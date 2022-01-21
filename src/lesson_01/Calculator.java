package lesson_01;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        String operation = readStringArgument("Введите операцию [+,-,*,/]: ");
        double argument1 = readDoubleArgument("Введите первый аргумент: ");
        double argument2 = readDoubleArgument("Введите второй аргумент: ");

        if (validateCalculationData(operation)){
            calculate(operation, argument1, argument2);
        }

    }

    private static void calculate(String operation, double argument1, double argument2) {

        switch(operation){
            case "+":
                System.out.println(argument1 + argument2);
                break;
            case "-":
                System.out.println(argument1 - argument2);
                break;
            case "/":
                System.out.println(argument1 / argument2);
                break;
            case "*":
                System.out.println(argument1 * argument2);
                break;
            default:
                System.err.println("Нет такой операции!");
                break;
        }
    }

    static boolean validateCalculationData(String operation) {
        boolean result = true;

        if (!operation.equals("+") && !operation.equals("-") && !operation.equals("/") && !operation.equals("*")){
            System.err.println("Нет такой операции!");
            result = false;
        }

        return result;
    }

    static double readDoubleArgument(String userText){
        Scanner userInput = new Scanner(System.in);

        System.out.print(userText);
        double argument = userInput.nextDouble();
        //userInput.close();

        return argument;
    }

    static String readStringArgument(String userText){
        Scanner userInput = new Scanner(System.in);

        System.out.print(userText);
        String argument = userInput.nextLine();
        //userInput.close();

        return argument;
    }

}
