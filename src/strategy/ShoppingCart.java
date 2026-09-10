package strategy;

import java.util.ArrayList;
import java.util.List;

// Context — holds a reference to the current payment strategy and delegates to it
public class ShoppingCart {

    private final List<Double> items = new ArrayList<>();
    private PaymentStrategy paymentStrategy;

    public void addItem(double price) {
        items.add(price);
    }

    // Strategy can be swapped at runtime without changing cart logic
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout() {
        if (paymentStrategy == null) {
            throw new IllegalStateException("Payment strategy not set");
        }
        double total = items.stream().mapToDouble(Double::doubleValue).sum();
        paymentStrategy.pay(total);
        items.clear();
    }
}
