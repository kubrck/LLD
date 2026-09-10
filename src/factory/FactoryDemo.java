package factory;

/*
 * Factory Pattern — Vehicle Factory
 *
 * Intent: Define an interface for creating an object, but let the factory
 * decide which class to instantiate. Clients work with the Vehicle interface
 * and never depend on concrete types.
 *
 * Real-world use: Ride-sharing apps creating different vehicle types.
 */
public class FactoryDemo {

    public static void main(String[] args) {
        Vehicle car   = VehicleFactory.create(VehicleFactory.VehicleType.CAR,   "Tesla Model 3");
        Vehicle bike  = VehicleFactory.create(VehicleFactory.VehicleType.BIKE,  "Harley Davidson");
        Vehicle truck = VehicleFactory.create(VehicleFactory.VehicleType.TRUCK, "Volvo FH");

        for (Vehicle v : new Vehicle[]{car, bike, truck}) {
            System.out.printf("Type: %-5s -> ", v.getType());
            v.start();
            v.stop();
        }
    }
}
