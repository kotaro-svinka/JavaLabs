public class Watch extends ElectronicDevice{
    private String strapMaterial;
    private int waterResistance;
    private boolean hasHeartRateMonitor;

    private static int watchCount = 0;

    public Watch(String brand,String model,int year,
                 double weight,int batteryCapacity,boolean hasWireless,
                 String strapMaterial,int waterResistance,boolean hasHeartRateMonitor){
        super(brand,model,year,weight,batteryCapacity,hasWireless);
        this.strapMaterial = strapMaterial;
        this.waterResistance = waterResistance;
        this.hasHeartRateMonitor = hasHeartRateMonitor;
        watchCount++;
    }
    public Watch(){this("Unknown", "Unknown", 0, 0.0, 0, false,
            "Unknown", 0, false);
    }

    public String getStrapMaterial(){return strapMaterial;}
    public int getWaterResistance(){
        return waterResistance;
    }
    public boolean getHasHeartRateMonitor(){
        return hasHeartRateMonitor;
    }

    public void setStrapMaterial(String strapMaterial){
        this.strapMaterial = strapMaterial;
    }
    public void setWaterResistance(int waterResistance){
        this.waterResistance = waterResistance;
    }
    public void setHasHeartRateMonitor(boolean hasHeartRateMonitor){
        this.hasHeartRateMonitor = hasHeartRateMonitor;
    }

    public static int getWatchCount() { return watchCount; }

    @Override
    public void turnOn() {
        System.out.println("Часы " + getBrand() + " " + getModel() + " включаются");
    }

    @Override
    public void turnOff() {
        System.out.println("Часы " + getBrand() + " " + getModel() + " выключаются");
    }

    @Override
    public void charge() {
        System.out.println("Часы заряжаются через беспроводную зарядку");
    }

    public void showTime() {
        System.out.println("Текущее время: 12:00");
    }

    public void startStopwatch() {
        System.out.println("Секундомер запущен");
    }

    public void setAlarm(String time) {
        System.out.println("Будильник установлен на " + time);
    }

    public void setAlarm(String time, boolean repeat) {
        System.out.println("Будильник установлен на " + time + " с повтором: " + repeat);
    }
}
