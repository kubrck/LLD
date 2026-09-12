package adapter;

// Target interface — the contract our application works with
public interface PaymentProcessor {
    PaymentResult process(double amount, String currency, String description);
}
