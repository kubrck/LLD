package strategy;

public class CreditCardPayment implements PaymentStrategy {

    private final String cardNumber;
    private final String cardHolder;

    public CreditCardPayment(String cardNumber, String cardHolder) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
    }

    @Override
    public void pay(double amount) {
        System.out.printf("Paid $%.2f using Credit Card [****%s] by %s%n",
            amount, cardNumber.substring(cardNumber.length() - 4), cardHolder);
    }
}
