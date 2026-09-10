package observer;

/*
 * Observer Pattern — Stock Price Notification System
 *
 * Intent: Define a one-to-many dependency between objects so that when one
 * object changes state, all its dependents are notified automatically.
 *
 * Real-world use: Event systems, pub/sub, UI data-binding, stock tickers.
 */
public class ObserverDemo {

    public static void main(String[] args) {
        StockMarket appleStock = new StockMarket("AAPL", 175.00);

        InvestorAlert alice = new InvestorAlert("Alice", 160.00);
        InvestorAlert bob   = new InvestorAlert("Bob",   155.00);
        TradingBot    bot   = new TradingBot("AlphaBot", 158.00, 180.00);

        appleStock.subscribe(alice);
        appleStock.subscribe(bob);
        appleStock.subscribe(bot);

        appleStock.setPrice(162.50);
        appleStock.setPrice(157.00);
        appleStock.setPrice(183.00);

        // Alice unsubscribes
        System.out.println("\nAlice unsubscribed.");
        appleStock.unsubscribe(alice);
        appleStock.setPrice(150.00);
    }
}
