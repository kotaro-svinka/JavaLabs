import java.util.regex.*;

public class UppercaseAfterLowercase {

    public static void main(String[] args) {
        String text1 = "приветКакДела";
        String text2 = "HelloWorld";
        String text3 = "aBcDeF";
        String text4 = "JavaProgramming";
        String text5 = "МойEmailАдрес";

        processText(text1);
        processText(text2);
        processText(text3);
        processText(text4);
        processText(text5);
    }

    public static void processText(String text) {
        String regex = "([a-zа-яё])([A-ZА-ЯЁ])";
        String replacement = "!$1$2!";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        String result = matcher.replaceAll(replacement);

        System.out.println("Исходный текст: " + text);
        System.out.println("Результат:      " + result);
        System.out.println();
    }
}