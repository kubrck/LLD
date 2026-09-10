package adapter;

/*
 * Adapter Pattern — Payment Processor (Stripe & PayPal integration)
 *
 * Intent: Convert the interface of a class into another interface that clients
 * expect. Adapter lets classes work together that otherwise couldn't because of
 * incompatible interfaces.
 *
 * Problem: Our app uses PaymentProcessor.process(amount, currency, description).
 * Stripe SDK uses createCharge(amountInCents, currency, description).
 * PayPal SDK uses executePayment(amountStr, currencyCode, note).
 * Both are third-party — we cannot change them.
 *
 * Solution: An adapter for each SDK that translates our interface into theirs.
 */
public class AdapterDemo {

    public static void main(String[] args) {
        // Pay via Stripe
        PaymentProcessor stripeProcessor = new StripeAdapter(new StripeClient());
        CheckoutService stripeCheckout = new CheckoutService(stripeProcessor);
        stripeCheckout.checkout(99.99, "USD");

        // Swap to PayPal — CheckoutService code doesn't change at all
        PaymentProcessor paypalProcessor = new PayPalAdapter(new PayPalGateway());
        CheckoutService paypalCheckout = new CheckoutService(paypalProcessor);
        paypalCheckout.checkout(49.50, "EUR");
    }
}
