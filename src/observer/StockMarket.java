package observer;

import java.util.ArrayList;
import java.util.List;

/*
 * Subject (Observable) — maintains a list of observers and notifies them
 * whenever the stock price changes.
 */
public class StockMarket {

    private final String symbol;
    private double price;
    private final List<StockObserver> observers = new ArrayList<>();

    public StockMarket(String symbol, double initialPrice) {
        this.symbol = symbol;
        this.price = initialPrice;
    }

    public void subscribe(StockObserver observer) {
        observers.add(observer);
    }

    public void unsubscribe(StockObserver observer) {
        observers.remove(observer);
    }

    public void setPrice(double newPrice) {
        System.out.printf("%n[Market] %s price changed: $%.2f -> $%.2f%n", symbol, price, newPrice);
        this.price = newPrice;
        notifyObservers();
    }

    private void notifyObservers() {
        observers.forEach(o -> o.update(symbol, price));
    }
}
