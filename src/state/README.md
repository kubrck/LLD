# State Pattern — ATM Machine

**Intent:** Allow an object to alter its behaviour when its internal state changes. The object will appear to change its class.

## UML

```mermaid
classDiagram
    class ATMState {
        <<interface>>
        +insertCard() void
        +ejectCard() void
        +enterPin(pin: int) void
        +requestCash(amount: double) void
    }

    class IdleState {
        -atm: ATMMachine
        +insertCard() void
        +ejectCard() void
        +enterPin(pin: int) void
        +requestCash(amount: double) void
    }

    class HasCardState {
        -atm: ATMMachine
        +insertCard() void
        +ejectCard() void
        +enterPin(pin: int) void
        +requestCash(amount: double) void
    }

    class HasCorrectPinState {
        -atm: ATMMachine
        +insertCard() void
        +ejectCard() void
        +enterPin(pin: int) void
        +requestCash(amount: double) void
    }

    class TransactionState {
        -atm: ATMMachine
        +insertCard() void
        +ejectCard() void
        +enterPin(pin: int) void
        +requestCash(amount: double) void
    }

    class ATMMachine {
        -currentState: ATMState
        -balance: double
        +insertCard() void
        +ejectCard() void
        +enterPin(pin: int) void
        +requestCash(amount: double) void
        +setState(state: ATMState) void
        +getBalance() double
        +deductBalance(amount: double) void
    }

    ATMState <|.. IdleState
    ATMState <|.. HasCardState
    ATMState <|.. HasCorrectPinState
    ATMState <|.. TransactionState
    ATMMachine o--> ATMState : currentState
    IdleState --> ATMMachine : transitions
    HasCardState --> ATMMachine : transitions
    HasCorrectPinState --> ATMMachine : transitions
    TransactionState --> ATMMachine : transitions
```

## State Transitions

```
[Idle] --insertCard()--> [HasCard] --enterPin(correct)--> [HasCorrectPin] --requestCash()--> [Transaction] --done--> [Idle]
         |                   |
         |            enterPin(wrong)
         |                   ↓
         |                [Idle]
         +--ejectCard()-->[Idle]
```

## Roles
| Class | Role |
|---|---|
| `ATMState` | State interface |
| `IdleState`, `HasCardState`, `HasCorrectPinState`, `TransactionState` | Concrete states |
| `ATMMachine` | Context — delegates all operations to current state |
