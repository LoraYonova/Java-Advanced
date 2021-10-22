package rowData;

public class Tires {
    private double tirePressure1;
    private int tireAge1;
    private double tirePressure2;
    private int tireAge2;
    private double tirePressure3;
    private int tireAge3;
    private double tirePressure4;
    private int tireAge4;


    public Tires(double tirePressure1, int tireAge1, double tirePressure2, int tireAge2, double tirePressure3, int tireAge3, double tirePressure4, int tireAge4) {
        this.tirePressure1 = tirePressure1;
        this.tireAge1 = tireAge1;
        this.tirePressure2 = tirePressure2;
        this.tireAge2 = tireAge2;
        this.tirePressure3 = tirePressure3;
        this.tireAge3 = tireAge3;
        this.tirePressure4 = tirePressure4;
        this.tireAge4 = tireAge4;
    }

    public double getTirePressure1() {
        return tirePressure1;
    }


    public double getTirePressure2() {
        return tirePressure2;
    }


    public double getTirePressure3() {
        return tirePressure3;
    }

    public double getTirePressure4() {
        return tirePressure4;
    }


}
