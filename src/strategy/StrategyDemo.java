package strategy;

/*
 * Strategy Pattern — Payment Processing
 *
 * Intent: Define a family of algorithms, encapsulate each one, and make them
 * interchangeable. Strategy lets the algorithm vary independently from clients.
 *
 * Real-world use: Switching payment methods (Credit Card, PayPal, UPI) at runtime.
 */
public class StrategyDemo {

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(29.99);
        cart.addItem(49.99);
        cart.addItem(9.99);

        // Pay with Credit Card
        cart.setPaymentStrategy(new CreditCardPayment("4111111111111234", "Alice"));
        cart.checkout();

        cart.addItem(99.00);

        // Swap strategy at runtime — pay with PayPal
        cart.setPaymentStrategy(new PayPalPayment("alice@example.com"));
        cart.checkout();

        cart.addItem(15.00);

        // Swap again — pay with UPI
        cart.setPaymentStrategy(new UPIPayment("alice@upi"));
        cart.checkout();
    }
}
