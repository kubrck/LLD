package facade;

/*
 * Facade — simplifies a complex subsystem (projector, amplifier, lights, etc.)
 * into a single easy-to-use interface for the client.
 */
public class HomeTheaterFacade {

    private final Projector projector;
    private final Amplifier amplifier;
    private final StreamingPlayer player;
    private final TheaterLights lights;
    private final PopcornPopper popper;

    public HomeTheaterFacade(Projector projector, Amplifier amplifier,
                              StreamingPlayer player, TheaterLights lights,
                              PopcornPopper popper) {
        this.projector = projector;
        this.amplifier = amplifier;
        this.player = player;
        this.lights = lights;
        this.popper = popper;
    }

    public void watchMovie(String movie) {
        System.out.println("--- Get ready to watch a movie! ---");
        popper.on();
        popper.pop();
        lights.dim(10);
        projector.on();
        projector.wideScreenMode();
        amplifier.on();
        amplifier.setVolume(5);
        player.on();
        player.play(movie);
    }

    public void endMovie() {
        System.out.println("--- Shutting movie theater down ---");
        popper.off();
        lights.on();
        projector.off();
        amplifier.off();
        player.stop();
        player.off();
    }
}
