package adapter;

/*
 * Client — only depends on the PaymentProcessor interface.
 * Has zero knowledge of Stripe, PayPal, or any SDK internals.
 * Switching providers = swapping the injected adapter, nothing else changes here.
 */
public class CheckoutService {

    private final PaymentProcessor paymentProcessor;

    public CheckoutService(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    public void checkout(double orderTotal, String currency) {
        System.out.printf("%nProcessing checkout for %.2f %s%n", orderTotal, currency);
        PaymentResult result = paymentProcessor.process(orderTotal, currency, "Order payment");
        System.out.println("Result: " + result);
    }
}
