# Decorator Pattern — Coffee Shop

**Intent:** Attach additional responsibilities to an object dynamically. Provides a flexible alternative to subclassing for extending functionality.

## UML

```mermaid
classDiagram
    class Coffee {
        <<interface>>
        +getDescription() String
        +getCost() double
    }

    class SimpleCoffee {
        +getDescription() String
        +getCost() double
    }

    class CoffeeDecorator {
        <<abstract>>
        #decoratedCoffee: Coffee
        +getDescription() String
        +getCost() double
    }

    class MilkDecorator {
        +getDescription() String
        +getCost() double
    }

    class SugarDecorator {
        +getDescription() String
        +getCost() double
    }

    class WhipDecorator {
        +getDescription() String
        +getCost() double
    }

    Coffee <|.. SimpleCoffee
    Coffee <|.. CoffeeDecorator
    CoffeeDecorator o--> Coffee : wraps
    CoffeeDecorator <|-- MilkDecorator
    CoffeeDecorator <|-- SugarDecorator
    CoffeeDecorator <|-- WhipDecorator
```

## Roles
| Class | Role |
|---|---|
| `Coffee` | Component interface |
| `SimpleCoffee` | Concrete component (base object) |
| `CoffeeDecorator` | Abstract decorator — wraps a `Coffee` |
| `MilkDecorator`, `SugarDecorator`, `WhipDecorator` | Concrete decorators — add cost and description |
