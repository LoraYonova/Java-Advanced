package ClassesSpeedRacing;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCostFor1Km;
    private double distance;
    private List<Car> cars;

    public Car(String model, double fuelAmount, double fuelCostFor1Km, double distance) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostFor1Km = fuelCostFor1Km;
        this.distance = distance;
        this.cars = new ArrayList<>();
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getFuelAmount(String model) {
        return fuelAmount;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public double getFuelCostFor1Km(String model) {
        return fuelCostFor1Km;
    }

    public void setFuelCostFor1Km(double fuelCostFor1Km) {
        this.fuelCostFor1Km = fuelCostFor1Km;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %.0f", model,fuelAmount,distance);
    }
}
