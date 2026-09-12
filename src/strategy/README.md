# Strategy Pattern — Payment Processing

**Intent:** Define a family of algorithms, encapsulate each one, and make them interchangeable at runtime.

## UML

```mermaid
classDiagram
    class PaymentStrategy {
        <<interface>>
        +pay(amount: double) void
    }

    class CreditCardPayment {
        -cardNumber: String
        -cardHolder: String
        +pay(amount: double) void
    }

    class PayPalPayment {
        -email: String
        +pay(amount: double) void
    }

    class UPIPayment {
        -upiId: String
        +pay(amount: double) void
    }

    class ShoppingCart {
        -items: List~Double~
        -paymentStrategy: PaymentStrategy
        +addItem(price: double) void
        +setPaymentStrategy(strategy: PaymentStrategy) void
        +checkout() void
    }

    PaymentStrategy <|.. CreditCardPayment
    PaymentStrategy <|.. PayPalPayment
    PaymentStrategy <|.. UPIPayment
    ShoppingCart o--> PaymentStrategy : uses
```

## Roles
| Class | Role |
|---|---|
| `PaymentStrategy` | Strategy interface |
| `CreditCardPayment`, `PayPalPayment`, `UPIPayment` | Concrete strategies |
| `ShoppingCart` | Context — delegates payment to the strategy |
