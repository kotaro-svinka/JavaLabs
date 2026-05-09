import java.util.regex.*;
import java.util.ArrayList;
import java.util.List;

public class WordFinderByLetter {

    public static void main(String[] args) {
        String text1 = "Мама мыла раму. Мама мыла окно, папа мыл пол.";
        String text2 = "Apple, apricot, banana, avocado, orange. An apple a day!";
        String text3 = "Солнце, снег, санки, сугроб, самолёт. Слава смеялся.";
        String text4 = "Кот кофе компьютер. Коньки каток. Коробка конфет.";

        findWordsByLetter(text1, 'м');
        findWordsByLetter(text2, 'a');
        findWordsByLetter(text2, 'A');
        findWordsByLetter(text3, 'с');
        findWordsByLetter(text4, 'к');
        findWordsByLetter(text4, 'К');
    }


    public static void findWordsByLetter(String text, char letter) {
        System.out.println("Текст: " + text);
        System.out.println("Ищем слова на букву: '" + letter + "'");

        try {
            String letterStr = String.valueOf(letter);
            String regex = "\\b[" + letterStr + "][а-яА-ЯёЁa-zA-Z]*\\b";
            Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE | Pattern.UNICODE_CHARACTER_CLASS);
            Matcher matcher = pattern.matcher(text);

            List<String> foundWords = new ArrayList<>();

            while (matcher.find()) {
                foundWords.add(matcher.group());
            }

            if (foundWords.isEmpty()) {
                System.out.println("Слова на букву '" + letter + "' не найдены.");
            } else {
                System.out.println("Найденные слова: " + String.join(", ", foundWords));
            }

        } catch (Exception e) {
            System.err.println("Произошла ошибка: " + e.getMessage());
        }

        System.out.println();
    }
}
