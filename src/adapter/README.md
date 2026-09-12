# Adapter Pattern — Payment Processor (Stripe & PayPal)

**Intent:** Convert the interface of a class into another interface that clients expect. Lets incompatible interfaces work together.

## UML

```mermaid
classDiagram
    class PaymentProcessor {
        <<interface>>
        +process(amount: double, currency: String, description: String) PaymentResult
    }

    class StripeAdapter {
        -stripeClient: StripeClient
        +process(amount: double, currency: String, description: String) PaymentResult
    }

    class PayPalAdapter {
        -payPalGateway: PayPalGateway
        +process(amount: double, currency: String, description: String) PaymentResult
    }

    class StripeClient {
        +createCharge(amountInCents: long, currency: String, description: String) StripeResponse
    }

    class PayPalGateway {
        +executePayment(amount: String, currencyCode: String, note: String) PayPalResponse
    }

    class CheckoutService {
        -paymentProcessor: PaymentProcessor
        +checkout(orderTotal: double, currency: String) void
    }

    PaymentProcessor <|.. StripeAdapter
    PaymentProcessor <|.. PayPalAdapter
    StripeAdapter o--> StripeClient
    PayPalAdapter o--> PayPalGateway
    CheckoutService o--> PaymentProcessor
```

## Roles
| Class | Role |
|---|---|
| `PaymentProcessor` | Target interface — what our app expects |
| `StripeClient`, `PayPalGateway` | Adaptees — third-party SDKs we can't change |
| `StripeAdapter`, `PayPalAdapter` | Adapters — translate our interface to the SDK |
| `CheckoutService` | Client — only knows `PaymentProcessor` |
