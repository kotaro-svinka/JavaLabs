public class Laptop extends ElectronicDevice{
    private String processor;
    private int ramGB;
    private boolean hasDedicatedGPU;

    public Laptop(String brand, String model, int year, double weight,
                  int batteryCapacity, boolean hasWireless,
                  String processor, int ramGB, boolean hasDedicatedGPU) {
        super(brand, model, year, weight, batteryCapacity, hasWireless);
        this.processor = processor;
        this.ramGB = ramGB;
        this.hasDedicatedGPU = hasDedicatedGPU;
    }

    public Laptop() {
        this("Unknown", "Unknown", 0, 0.0, 0, false,
                "Unknown", 0, false);
    }

    public String getProcessor() { return processor; }
    public int getRamGB() { return ramGB; }
    public boolean isHasDedicatedGPU() { return hasDedicatedGPU; }

    public void setProcessor(String processor) { this.processor = processor; }
    public void setRamGB(int ramGB) { this.ramGB = ramGB; }
    public void setHasDedicatedGPU(boolean hasDedicatedGPU) { this.hasDedicatedGPU = hasDedicatedGPU; }

    @Override
    public void turnOn() {
        System.out.println("Ноутбук " + getBrand() + " " + getModel() + " загружает BIOS");
    }

    @Override
    public void turnOff() {
        System.out.println("Ноутбук " + getBrand() + " " + getModel() + " завершает работу");
    }

    @Override
    public void charge() {
        System.out.println("Ноутбук заряжается через блок питания");
    }

    public void runProgram(String programName) {
        System.out.println("Программа " + programName + " запущена");
    }

    public void openLid() {
        System.out.println("Крышка ноутбука открыта");
    }

    public void runProgram(String programName, boolean adminMode) {
        if (adminMode) {
            System.out.println("Программа " + programName + " запущена от администратора");
        } else {
            runProgram(programName);
        }
    }
}
