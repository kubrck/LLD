package observer;

// Concrete Observer — automated trading bot that reacts to price changes
public class TradingBot implements StockObserver {

    private final String botName;
    private final double buyBelow;
    private final double sellAbove;

    public TradingBot(String botName, double buyBelow, double sellAbove) {
        this.botName = botName;
        this.buyBelow = buyBelow;
        this.sellAbove = sellAbove;
    }

    @Override
    public void update(String stockSymbol, double newPrice) {
        if (newPrice < buyBelow) {
            System.out.printf("  [BOT]   %s: AUTO-BUY %s at $%.2f%n", botName, stockSymbol, newPrice);
        } else if (newPrice > sellAbove) {
            System.out.printf("  [BOT]   %s: AUTO-SELL %s at $%.2f%n", botName, stockSymbol, newPrice);
        } else {
            System.out.printf("  [BOT]   %s: Holding %s at $%.2f%n", botName, stockSymbol, newPrice);
        }
    }
}
