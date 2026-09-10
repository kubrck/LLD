package singleton;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*
 * Thread-safe Singleton Logger using double-checked locking.
 * Only one Logger instance exists across the entire application.
 */
public class Logger {

    private static volatile Logger instance;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private Logger() {}

    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    public void info(String message) {
        log("INFO", message);
    }

    public void warn(String message) {
        log("WARN", message);
    }

    public void error(String message) {
        log("ERROR", message);
    }

    private void log(String level, String message) {
        String timestamp = LocalDateTime.now().format(FORMATTER);
        System.out.printf("[%s] [%s] %s%n", timestamp, level, message);
    }
}
