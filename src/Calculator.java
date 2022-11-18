import java.util.Scanner;
public class Calculator {

        public static void main(String[] args) throws ScannerException {
            Scanner scan = new Scanner(System.in);
            System.out.print("Введите выражение:");
            String input = scan.nextLine();
            System.out.println(calc(input));
        }
        public static String calc(String input) throws ScannerException {
            romanNum convert = new romanNum();
            String[] actions = {"+", "-", "/", "*"};
            String[] op = {"\\+", "-", "/", "\\*"};
            int operatorIndex = -1;
            for (int i = 0; i < actions.length; i++) {
                if (input.contains(actions[i])) {
                    operatorIndex = i;
                    break;
                }
            }
            if (operatorIndex == -1) {
                throw new ScannerException("т.к. строка не является математической операцией");
            }
            String[] data = input.split(op[operatorIndex]);
            if (data.length > 2) {
                throw new ScannerException("т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            }
            if (convert.isRoman(data[0]) == convert.isRoman(data[1])) {
                int a, b;
                boolean isRoman = convert.isRoman(data[0]);
                if (isRoman) {
                    a = convert.romanToInt(data[0]);
                    b = convert.romanToInt(data[1]);
                } else {
                    a = Integer.parseInt(data[0]);
                    b = Integer.parseInt(data[1]);
                }
                if (a <= 0 || a > 10) {
                    throw new ScannerException("Ввод чисел от 1 до 10 включительно");
                }
                if (b <= 0 || b > 10) {
                    throw new ScannerException("Ввод чисел от 1 до 10 включительно");
                }
                int result = switch (actions[operatorIndex]) {
                    case "+" -> a + b;
                    case "-" -> a - b;
                    case "*" -> a * b;
                    default -> a / b;
                };
                if (isRoman) {
                    if (result < 0) {
                        throw new ScannerException("т.к. в римской системе нет отрицательных чисел");
                    }
                    input = convert.IntToRoman(result);
                } else {
                    input = (String.valueOf(result));
                }
            } else {
                throw new ScannerException("т.к. используются одновременно разные системы счисления");
            }
            return input;
        }
    }

