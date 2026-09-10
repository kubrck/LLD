package adapter;

/*
 * Adapter — wraps StripeClient and translates our PaymentProcessor
 * interface calls into Stripe SDK calls.
 *
 * Translations handled here:
 *  - double dollars  ->  long cents  (Stripe requires smallest currency unit)
 *  - PaymentResult   <-  StripeResponse
 */
public class StripeAdapter implements PaymentProcessor {

    private final StripeClient stripeClient;

    public StripeAdapter(StripeClient stripeClient) {
        this.stripeClient = stripeClient;
    }

    @Override
    public PaymentResult process(double amount, String currency, String description) {
        long amountInCents = Math.round(amount * 100);
        StripeClient.StripeResponse response = stripeClient.createCharge(amountInCents, currency, description);
        boolean success = "succeeded".equals(response.status);
        return new PaymentResult(success, response.chargeId, "Stripe: " + response.status);
    }
}
