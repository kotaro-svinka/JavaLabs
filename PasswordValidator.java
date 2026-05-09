import java.util.regex.*;
import java.util.Scanner;

public class PasswordValidator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Введите пароль (или 'exit' для выхода): ");
            String password = scanner.nextLine();

            if (password.equalsIgnoreCase("exit")) {
                System.out.println("Программа завершена.");
                break;
            }

            boolean isValid = validatePassword(password);

            if (isValid) {
                System.out.println("Пароль корректный!\n");
            } else {
                System.out.println("Пароль НЕ корректный. Попробуйте снова.\n");
            }
        }

        scanner.close();
    }


    public static boolean validatePassword(String password) {
        try {
            String regex = "^(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8,16}$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(password);

            return matcher.matches();

        } catch (PatternSyntaxException e) {
            System.err.println("Ошибка в синтаксисе регулярного выражения: " + e.getMessage());
            return false;
        }
    }
}