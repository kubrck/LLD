package factory;

/*
 * Factory — centralises object creation so the client never
 * calls `new` on concrete classes directly.
 */
public class VehicleFactory {

    public enum VehicleType { CAR, BIKE, TRUCK }

    public static Vehicle create(VehicleType type, String model) {
        return switch (type) {
            case CAR   -> new Car(model);
            case BIKE  -> new Bike(model);
            case TRUCK -> new Truck(model);
        };
    }
}
