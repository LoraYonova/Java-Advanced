package DefinigClassesConstructor;



public class Constructor {
    private String brand;
    private String model;
    private int horsePower;


    public Constructor(String brand, String model, int horsePower){
        this.brand = brand;
        this.model = model;
        this.horsePower = horsePower;
    }
    public Constructor(String brand) {
        this(brand, "unknown", -1);
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    public String toString() {
        return String.format("The car is: %s %s - %d HP." , this.getBrand(), this.getModel(), this.getHorsePower());
    }
}
