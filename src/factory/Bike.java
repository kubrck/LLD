package factory;

public class Bike implements Vehicle {

    private final String model;

    public Bike(String model) {
        this.model = model;
    }

    @Override
    public void start() {
        System.out.println("Bike [" + model + "] started.");
    }

    @Override
    public void stop() {
        System.out.println("Bike [" + model + "] stopped.");
    }

    @Override
    public String getType() {
        return "BIKE";
    }
}
