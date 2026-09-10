package strategy;

// Strategy interface — defines the contract for all payment algorithms
public interface PaymentStrategy {
    void pay(double amount);
}
