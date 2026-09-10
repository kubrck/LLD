package strategy;

public class UPIPayment implements PaymentStrategy {

    private final String upiId;

    public UPIPayment(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public void pay(double amount) {
        System.out.printf("Paid $%.2f via UPI [%s]%n", amount, upiId);
    }
}
