package factory;

public class Truck implements Vehicle {

    private final String model;

    public Truck(String model) {
        this.model = model;
    }

    @Override
    public void start() {
        System.out.println("Truck [" + model + "] engine started.");
    }

    @Override
    public void stop() {
        System.out.println("Truck [" + model + "] engine stopped.");
    }

    @Override
    public String getType() {
        return "TRUCK";
    }
}
