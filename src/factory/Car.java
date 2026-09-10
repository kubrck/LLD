package factory;

public class Car implements Vehicle {

    private final String model;

    public Car(String model) {
        this.model = model;
    }

    @Override
    public void start() {
        System.out.println("Car [" + model + "] engine started.");
    }

    @Override
    public void stop() {
        System.out.println("Car [" + model + "] engine stopped.");
    }

    @Override
    public String getType() {
        return "CAR";
    }
}
