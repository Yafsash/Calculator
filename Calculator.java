import java.io.IOException;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Converter converter = new Converter();
        String[] actions = {"+", "-", "/", "*"};
        String[] regexActions = new String[]{"\\+", "-", "/", "\\*"};
        System.out.print("Введите выражение: ");
        String exp = scanner.nextLine();

        int actionIndex = -1;
        for (int i = 0; i < actions.length; i++) {
            if (exp.contains(actions[i])) {
                actionIndex = i;
                break;
            }
        }
        if (actionIndex == -1) {
            System.out.println("строка не является математической операцией");
            return;
        }
        String[] data = exp.split(regexActions[actionIndex]);
        if (converter.isRoman(data[0]) == converter.isRoman(data[1])) {
            int a;
            int b;
            boolean isRoman = converter.isRoman(data[0]);
            if (isRoman) {
                a = converter.romanToInt(data[0]);
                b = converter.romanToInt(data[1]);
            } else {
                a = Integer.parseInt(data[0]);
                b = Integer.parseInt(data[1]);
            }
            while (true) {
                if (a < 1) {
                    try {
                        throw new IOException();
                    } catch (IOException e) {
                        System.out.println("Исходные числа не могут быть меньше единицы");
                        return;
                    }
                }
                if (a > 10) {
                    try {
                        throw new IOException();
                    } catch (IOException e) {
                        System.out.println("Исходные числа не могут быть больше десяти");
                        return;
                    }
                }
                if (b < 1) {
                    try {
                        throw new IOException();
                    } catch (IOException e) {
                        System.out.println("Исходные числа не могут быть меньше единицы");
                        return;
                    }
                }
                if (b > 10) {
                    try {
                        throw new IOException();
                    } catch (IOException e) {
                        System.out.println("Исходные числа не могут быть больше десяти");
                        return;
                    }
                }
                break;
            }
            int result;
            switch (actions[actionIndex]) {
                case "+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    break;
                case "*":
                    result = a * b;
                    break;
                default:
                    result = a / b;
                    break;
            }
            if (isRoman) {
                if (result < 1) {
                    try {
                        throw new IOException();
                    } catch (IOException e) {
                        System.out.println("в римской системе нет отрицательных чисел");
                        return;
                    }
                }
                    System.out.println(converter.intToRoman(result));
            }
            else {
                System.out.println(result);
            }
        } else {
            System.out.println("используются одновременно разные системы счисления, числа должны быть в одном формате");
        }
    }
}