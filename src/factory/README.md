# Factory Pattern — Vehicle Factory

**Intent:** Define an interface for creating objects, letting the factory decide which class to instantiate. Clients depend only on the interface.

## UML

```mermaid
classDiagram
    class Vehicle {
        <<interface>>
        +start() void
        +stop() void
        +getType() String
    }

    class Car {
        -model: String
        +start() void
        +stop() void
        +getType() String
    }

    class Bike {
        -model: String
        +start() void
        +stop() void
        +getType() String
    }

    class Truck {
        -model: String
        +start() void
        +stop() void
        +getType() String
    }

    class VehicleFactory {
        <<static>>
        +create(type: VehicleType, model: String) Vehicle
    }

    Vehicle <|.. Car
    Vehicle <|.. Bike
    Vehicle <|.. Truck
    VehicleFactory ..> Car : creates
    VehicleFactory ..> Bike : creates
    VehicleFactory ..> Truck : creates
```

## Roles
| Class | Role |
|---|---|
| `Vehicle` | Product interface |
| `Car`, `Bike`, `Truck` | Concrete products |
| `VehicleFactory` | Factory — centralises object creation |
