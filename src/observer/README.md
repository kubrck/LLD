# Observer Pattern — Stock Price Notification

**Intent:** Define a one-to-many dependency so that when one object changes state, all dependents are notified automatically.

## UML

```mermaid
classDiagram
    class StockObserver {
        <<interface>>
        +update(stockSymbol: String, newPrice: double) void
    }

    class InvestorAlert {
        -investorName: String
        -alertThreshold: double
        +update(stockSymbol: String, newPrice: double) void
    }

    class TradingBot {
        -botName: String
        -buyBelow: double
        -sellAbove: double
        +update(stockSymbol: String, newPrice: double) void
    }

    class StockMarket {
        -symbol: String
        -price: double
        -observers: List~StockObserver~
        +subscribe(observer: StockObserver) void
        +unsubscribe(observer: StockObserver) void
        +setPrice(newPrice: double) void
        -notifyObservers() void
    }

    StockObserver <|.. InvestorAlert
    StockObserver <|.. TradingBot
    StockMarket o--> "many" StockObserver : notifies
```

## Roles
| Class | Role |
|---|---|
| `StockObserver` | Observer interface |
| `InvestorAlert`, `TradingBot` | Concrete observers |
| `StockMarket` | Subject (Observable) — maintains and notifies observer list |
