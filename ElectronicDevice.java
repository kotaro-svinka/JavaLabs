public abstract class ElectronicDevice extends Gadgets{
    private double weight;
    private int batteryCapacity;
    private boolean hasWireless;

    public ElectronicDevice(String brand,String model,int year,
                            double weight,int batteryCapacity,boolean hasWireless){
        super(brand,model,year);
        this.weight = weight;
        this.batteryCapacity = batteryCapacity;
        this.hasWireless = hasWireless;
    }
    public ElectronicDevice(){this("Unknown","Unknown",0,
            0.0,0,false);
    }

    public double getWeight(){return weight;}
    public int getBatteryCapacity(){
        return batteryCapacity;
    }
    public boolean getHasWireless(){
        return hasWireless;
    }

    public void setWeight(double weight){
        this.weight = weight;
    }
    public void setBatteryCapacity(int batteryCapacity){
        this.batteryCapacity = batteryCapacity;
    }
    public void setHasWireless(boolean hasWireless){
        this.hasWireless = hasWireless;
    }

    public void checkBattery() {
        System.out.println("Ёмкость батареи: " + batteryCapacity + " мАч");
    }
    public abstract void charge();
}
