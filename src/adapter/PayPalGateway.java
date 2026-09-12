package adapter;

import java.util.UUID;

/*
 * Adaptee — simulates the real PayPal SDK.
 * Also incompatible with our PaymentProcessor interface.
 * We cannot change this class (it's a third-party library).
 */
public class PayPalGateway {

    // PayPal takes amount as a String and uses its own response format
    public PayPalResponse executePayment(String amount, String currencyCode, String note) {
        System.out.printf("[PayPal SDK] Executing payment: %s %s — \"%s\"%n",
            amount, currencyCode, note);
        return new PayPalResponse("PAY-" + UUID.randomUUID().toString().substring(0, 10), "COMPLETED");
    }

    public static class PayPalResponse {
        public final String paymentId;
        public final String state;

        public PayPalResponse(String paymentId, String state) {
            this.paymentId = paymentId;
            this.state = state;
        }
    }
}
