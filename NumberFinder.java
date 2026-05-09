import java.util.regex.*;
import java.util.ArrayList;
import java.util.List;

public class NumberFinder {

    public static void main(String[] args) {
        String text1 = "The price of the product is $19.99 and the discount is -5.00";
        String text2 = "There are 42 apples, 17 oranges and 0 bananas";
        String text3 = "Temperature: -10.5°C, pressure: 1013.25 hPa, humidity: 65%";
        String text4 = "Invalid numbers: 12.34.56, ..99, 99.., .5";

        findAndPrintNumbers(text1);
        findAndPrintNumbers(text2);
        findAndPrintNumbers(text3);
        findAndPrintNumbers(text4);
    }


    public static void findAndPrintNumbers(String text) {
        System.out.println("Текст: " + text);
        System.out.print("Найденные числа: ");

        try {
            String regex = "-?\\d+(?:\\.\\d+)?";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(text);

            List<String> numbers = new ArrayList<>();

            while (matcher.find()) {
                numbers.add(matcher.group());
            }

            if (numbers.isEmpty()) {
                System.out.println("числа не найдены");
            } else {
                System.out.println(String.join(", ", numbers));
            }

        } catch (PatternSyntaxException e) {
            System.err.println("Ошибка в синтаксисе регулярного выражения: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Произошла ошибка: " + e.getMessage());
        }

        System.out.println();
    }
}