package adapter;

// Value object returned by every payment processor
public class PaymentResult {

    private final boolean success;
    private final String transactionId;
    private final String message;

    public PaymentResult(boolean success, String transactionId, String message) {
        this.success = success;
        this.transactionId = transactionId;
        this.message = message;
    }

    @Override
    public String toString() {
        return String.format("PaymentResult{success=%s, txnId='%s', message='%s'}",
            success, transactionId, message);
    }
}
