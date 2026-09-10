package facade;

/*
 * Facade Pattern — Home Theater System
 *
 * Intent: Provide a unified, simplified interface to a complex subsystem.
 * The facade doesn't encapsulate the subsystem, it just provides a simpler view.
 *
 * Real-world use: Service layer hiding microservice calls, SDK wrappers,
 * AWS SDK facade over multiple service clients.
 */
public class FacadeDemo {

    public static void main(String[] args) {
        // Subsystem components
        Projector      projector = new Projector();
        Amplifier      amplifier = new Amplifier();
        StreamingPlayer player   = new StreamingPlayer();
        TheaterLights  lights    = new TheaterLights();
        PopcornPopper  popper    = new PopcornPopper();

        // Facade hides the 10+ individual calls behind 1 simple method
        HomeTheaterFacade homeTheater = new HomeTheaterFacade(
            projector, amplifier, player, lights, popper
        );

        homeTheater.watchMovie("Inception");
        System.out.println();
        homeTheater.endMovie();
    }
}
