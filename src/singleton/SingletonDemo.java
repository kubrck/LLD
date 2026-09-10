package singleton;

/*
 * Singleton Pattern — Application Logger
 *
 * Intent: Ensure a class has only one instance and provide a global point
 * of access to it.
 *
 * Real-world use: Logger, config manager, connection pool — resources that
 * should be shared and instantiated exactly once.
 */
public class SingletonDemo {

    public static void main(String[] args) {
        Logger log1 = Logger.getInstance();
        Logger log2 = Logger.getInstance();

        // Both references point to the same instance
        System.out.println("Same instance? " + (log1 == log2));

        log1.info("Application started");
        log2.warn("Low memory warning");
        log1.error("Connection timed out");
    }
}
