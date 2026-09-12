# State Pattern — Vending Machine

**Intent:** Allow an object to alter its behaviour when its internal state changes. The object will appear to change its class.

## UML

```mermaid
classDiagram
    class VendingMachineState {
        <<abstract>>
        +insertCoin(machine: VendingMachine, coin: int) void
        +selectItem(machine: VendingMachine) void
        +dispense(machine: VendingMachine) void
        +returnCoin(machine: VendingMachine) void
        +refill(machine: VendingMachine, qty: int) void
    }

    class NoCoinState {
        +insertCoin(machine: VendingMachine, coin: int) void
        +selectItem(machine: VendingMachine) void
        +dispense(machine: VendingMachine) void
        +returnCoin(machine: VendingMachine) void
        +refill(machine: VendingMachine, qty: int) void
    }

    class HasCoinState {
        +insertCoin(machine: VendingMachine, coin: int) void
        +selectItem(machine: VendingMachine) void
        +dispense(machine: VendingMachine) void
        +returnCoin(machine: VendingMachine) void
        +refill(machine: VendingMachine, qty: int) void
    }

    class DispenseState {
        +insertCoin(machine: VendingMachine, coin: int) void
        +selectItem(machine: VendingMachine) void
        +dispense(machine: VendingMachine) void
        +returnCoin(machine: VendingMachine) void
        +refill(machine: VendingMachine, qty: int) void
    }

    class SoldOutState {
        +insertCoin(machine: VendingMachine, coin: int) void
        +selectItem(machine: VendingMachine) void
        +dispense(machine: VendingMachine) void
        +returnCoin(machine: VendingMachine) void
        +refill(machine: VendingMachine, qty: int) void
    }

    class VendingMachine {
        -state: VendingMachineState
        -itemCount: int
        -balance: int
        +insertCoin(coin: int) void
        +selectItem() void
        +dispense() void
        +returnCoin() void
        +refill(qty: int) void
        +setState(state: VendingMachineState) void
    }

    VendingMachineState <|-- NoCoinState
    VendingMachineState <|-- HasCoinState
    VendingMachineState <|-- DispenseState
    VendingMachineState <|-- SoldOutState

    VendingMachine *--> VendingMachineState : has-a (state)
```

## State Transitions

```
[NoCoinState] --insertCoin()--> [HasCoinState] --selectItem()--> [DispenseState] --dispense()--> [NoCoinState]
                                     |                                                                  |
                                returnCoin()                                               itemCount==0 |
                                     |                                                                  ▼
                                [NoCoinState]                                              [SoldOutState]
                                                                                                |
                                                                                            refill()
                                                                                                |
                                                                                           [NoCoinState]
```

## Roles
| Class | Role |
|---|---|
| `VendingMachineState` | Abstract state — defines all operations; `machine` passed as parameter so states need no back-reference |
| `NoCoinState` | Waiting for coin |
| `HasCoinState` | Coin inserted, waiting for item selection |
| `DispenseState` | Dispensing item |
| `SoldOutState` | No items left |
| `VendingMachine` | Context — delegates all calls to current state, passing `this` |
