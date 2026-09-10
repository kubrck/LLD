package observer;

// Concrete Observer — notifies an investor when a price threshold is crossed
public class InvestorAlert implements StockObserver {

    private final String investorName;
    private final double alertThreshold;

    public InvestorAlert(String investorName, double alertThreshold) {
        this.investorName = investorName;
        this.alertThreshold = alertThreshold;
    }

    @Override
    public void update(String stockSymbol, double newPrice) {
        if (newPrice <= alertThreshold) {
            System.out.printf("  [ALERT] %s: %s dropped to $%.2f (threshold: $%.2f) — Consider buying!%n",
                investorName, stockSymbol, newPrice, alertThreshold);
        } else {
            System.out.printf("  [INFO]  %s: %s is now $%.2f%n", investorName, stockSymbol, newPrice);
        }
    }
}
