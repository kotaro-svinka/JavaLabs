public class Smartphone extends ElectronicDevice{
    private String operatingSystem;
    private int storageGB;
    private int cameraMP;

    public Smartphone(String brand, String model, int year, double weight,
                      int batteryCapacity, boolean hasWireless,
                      String operatingSystem, int storageGB, int cameraMP) {
        super(brand, model, year, weight, batteryCapacity, hasWireless);
        this.operatingSystem = operatingSystem;
        this.storageGB = storageGB;
        this.cameraMP = cameraMP;
    }
    public Smartphone() {
        this("Unknown", "Unknown", 0, 0.0, 0, false,
                "Unknown", 0, 0);
    }

    public String getOperatingSystem() { return operatingSystem; }
    public int getStorageGB() { return storageGB; }
    public int getCameraMP() { return cameraMP; }

    public void setOperatingSystem(String operatingSystem) { this.operatingSystem = operatingSystem; }
    public void setStorageGB(int storageGB) { this.storageGB = storageGB; }
    public void setCameraMP(int cameraMP) { this.cameraMP = cameraMP; }

    @Override
    public void turnOn() {
        System.out.println("Смартфон " + getBrand() + " " + getModel() + "загружается");
    }

    @Override
    public void turnOff() {
        System.out.println("Смартфон " + getBrand() + " " + getModel() + " выключается");
    }

    @Override
    public void charge() {
        System.out.println("Смартфон заряжается через USB-C");
    }

    public void takePhoto() {
        System.out.println("Фото сделано");
    }

    public void installApp(String appName) {
        System.out.println("Приложение " + appName + " установлено");
    }

    public void takePhoto(String mode) {
        System.out.println("Фото сделано в режиме: " + mode);
    }
}
