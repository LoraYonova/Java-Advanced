package rowData;


public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tires tire;

    public Car(String model,Engine engine, Cargo cargo, Tires tire) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tire = tire;
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public Tires getTire() {
        return tire;
    }
}
