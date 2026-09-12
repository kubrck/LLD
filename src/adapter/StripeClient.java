package adapter;

import java.util.UUID;

/*
 * Adaptee — simulates the real Stripe SDK.
 * Its method signatures are completely different from our PaymentProcessor interface.
 * We cannot change this class (it's a third-party library).
 */
public class StripeClient {

    // Stripe works in smallest currency unit (cents), not dollars
    public StripeResponse createCharge(long amountInCents, String currency, String description) {
        System.out.printf("[Stripe SDK] Creating charge: %d %s cents — \"%s\"%n",
            amountInCents, currency.toUpperCase(), description);
        return new StripeResponse("ch_" + UUID.randomUUID().toString().substring(0, 8), "succeeded");
    }

    // Stripe's response object — also different from our PaymentResult
    public static class StripeResponse {
        public final String chargeId;
        public final String status;

        public StripeResponse(String chargeId, String status) {
            this.chargeId = chargeId;
            this.status = status;
        }
    }
}
