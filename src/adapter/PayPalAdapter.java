package adapter;

/*
 * Adapter — wraps PayPalGateway and translates our PaymentProcessor
 * interface calls into PayPal SDK calls.
 *
 * Translations handled here:
 *  - double amount  ->  String amount  (PayPal takes amount as String)
 *  - PaymentResult  <-  PayPalResponse
 */
public class PayPalAdapter implements PaymentProcessor {

    private final PayPalGateway payPalGateway;

    public PayPalAdapter(PayPalGateway payPalGateway) {
        this.payPalGateway = payPalGateway;
    }

    @Override
    public PaymentResult process(double amount, String currency, String description) {
        String amountStr = String.format("%.2f", amount);
        PayPalGateway.PayPalResponse response = payPalGateway.executePayment(amountStr, currency, description);
        boolean success = "COMPLETED".equals(response.state);
        return new PaymentResult(success, response.paymentId, "PayPal: " + response.state);
    }
}
