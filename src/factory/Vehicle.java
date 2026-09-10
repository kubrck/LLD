package factory;

// Product interface — all vehicles must implement this
public interface Vehicle {
    void start();
    void stop();
    String getType();
}
