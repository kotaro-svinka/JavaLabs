import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileTask {
    public static void main(String[] args) {
        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("source.txt");
            out = new FileOutputStream("dest.txt");

            int data;
            while ((data = in.read()) != -1) {
                out.write(data);
            }

        } catch (FileNotFoundException e) {
            System.err.println("ОШИБКА ОТКРЫТИЯ: Не удалось найти или создать файл! " + e.getMessage());
        } catch (IOException e) {
            System.err.println("ОШИБКА: Произошел сбой при работе с данными: " + e.getMessage());
        } finally {
            try {
                if (in != null) {
                    in.close();
                    System.out.println("Входящий поток закрыт.");
                }
                if (out != null) {
                    out.close();
                    System.out.println("Исходящий поток закрыт.");
                }
            } catch (IOException e) {
                System.err.println("ОШИБКА ЗАКРЫТИЯ: Не удалось освободить ресурсы! " + e.getMessage());
            }
        }
    }
}
