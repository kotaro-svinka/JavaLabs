public class Main {
    public static void main(String[] args) {
        System.out.println("=== Демонстрация работы иерархии классов ===\n");

        Watch watch1 = new Watch("Casio", "G-Shock", 2022, 85.5, 500, false,
                "Резина", 200, true);
        Watch watch2 = new Watch();

        Smartphone phone1 = new Smartphone("Apple", "iPhone 15", 2023, 171, 3300, true,
                "iOS", 256, 48);
        Smartphone phone2 = new Smartphone();

        Laptop laptop1 = new Laptop("Asus", "ROG", 2023, 2300, 60000, true,
                "Intel i7", 16, true);
        Laptop laptop2 = new Laptop();

        System.out.println("--- Информация о часах 1 ---");
        watch1.displayInfo();
        watch1.turnOn();
        watch1.showTime();
        watch1.setAlarm("07:00");
        watch1.setAlarm("07:00", true);
        watch1.charge();
        watch1.turnOff();

        System.out.println("\n--- Информация о часах 2 (по умолчанию) ---");
        watch2.displayInfo();

        System.out.println("\n--- Информация о смартфоне 1 ---");
        phone1.displayInfo();
        phone1.turnOn();
        phone1.takePhoto();
        phone1.takePhoto("ночной режим");
        phone1.installApp("Telegram");
        phone1.charge();
        phone1.turnOff();

        System.out.println("\n--- Информация о ноутбуке 1 ---");
        laptop1.displayInfo();
        laptop1.turnOn();
        laptop1.runProgram("IntelliJ IDEA");
        laptop1.runProgram("Photoshop", true);
        laptop1.openLid();
        laptop1.charge();
        laptop1.turnOff();

        System.out.println("\n--- Статистика ---");
        System.out.println("Всего создано часов: " + Watch.getWatchCount());
    }
}
