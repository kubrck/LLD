package observer;

// Observer interface — every subscriber must implement this
public interface StockObserver {
    void update(String stockSymbol, double newPrice);
}
