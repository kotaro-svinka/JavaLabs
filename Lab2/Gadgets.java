public abstract class Gadgets {
    private String brand;
    private String model;
    private int year;

    public Gadgets(String brand,String model,int year){
        this.brand = brand;
        this.model = model;
        this.year = year;
    }
    public Gadgets(){
        this("Unknown","Unknown",0);
    }

    public String getBrand(){return brand;}
    public String getModel(){
        return model;
    }
    public int getYear(){
        return year;
    }

    public void setBrand(String brand){
        this.brand = brand;
    }
    public void setModel(String model){
        this.model = model;
    }
    public void setYear(int year){
        this.year = year;
    }

    public void displayInfo() {
        System.out.println("Бренд: " + brand);
        System.out.println("Модель: " + model);
        System.out.println("Год впыуска: " + year);
    }
    public abstract void turnOn();
    public abstract void turnOff();
}
