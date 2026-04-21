import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class LabWorkTask3 {
    public static void main(String[] args) {

        try {
            int a = 10;
            int b = 0;
            if (b == 0) throw new CustomDivisionException("Деление на ноль: " + a + " / " + b);
            int result = a / b;
            System.out.println("Результат деления: " + result);
        } catch (CustomDivisionException e) {
            ExceptionLogger.log(e);
        }

        try {
            int userAge = -5;
            if (userAge < 0 || userAge > 120) {
                throw new CustomAgeException("Недопустимый возраст: " + userAge);
            }
            System.out.println("Возраст прошел проверку.");
        } catch (CustomAgeException e) {
            ExceptionLogger.log(e);
        }

        try {
            File file = new File("data.txt");
            if (!file.exists()) {
                throw new CustomFileNotFoundException("Файл не существует: " + file.getName());
            }
        } catch (CustomFileNotFoundException e) {
            ExceptionLogger.log(e);
        }

        try {
            String str = "не_число";
            try {
                int num = Integer.parseInt(str);
            } catch (NumberFormatException nfe) {
                throw new CustomNumberFormatException("Ошибка формата. Строка '" + str + "' не число.");
            }
        } catch (CustomNumberFormatException e) {
            ExceptionLogger.log(e);
        }

        try {
            CustomStack stack = new CustomStack();
            stack.pop();
        } catch (CustomEmptyStackException e) {
            ExceptionLogger.log(e);
        }

        try {
            System.out.print("Введите целое число: ");
            Scanner sc = new Scanner(System.in);
            if (!sc.hasNextInt()) {
                throw new CustomInputMismatchException("Введены некорректные данные (не int).");
            }
            int input = sc.nextInt();
        } catch (CustomInputMismatchException e) {
            ExceptionLogger.log(e);
        }

        try {
            String email = "invalid-email";
            if (!email.contains("@") || !email.contains(".")) {
                throw new CustomEmailFormatException("Неверный формат email: " + email);
            }
        } catch (CustomEmailFormatException e) {
            ExceptionLogger.log(e);
        }

        try {
            String op = "возведение_в_степень";
            double x = 5, y = 2;
            calculate(x, y, op);
        } catch (CustomUnsupportedOperationException e) {
            ExceptionLogger.log(e);
        }

        System.out.println("Все варианты отработаны. Проверьте log.txt.");
    }

    public static void calculate(double x, double y, String op) throws CustomUnsupportedOperationException {
        switch (op) {
            case "+": System.out.println(x + y); break;
            case "-": System.out.println(x - y); break;
            case "*": System.out.println(x * y); break;
            case "/": System.out.println(x / y); break;
            default: throw new CustomUnsupportedOperationException("Операция '" + op + "' не поддерживается.");
        }
    }
}

class CustomStack {
    private ArrayList<Integer> list = new ArrayList<>();
    public void pop() throws CustomEmptyStackException {
        if (list.isEmpty()) {
            throw new CustomEmptyStackException("Стек пуст! Нечего извлекать.");
        }
        list.remove(list.size() - 1);
    }
}
