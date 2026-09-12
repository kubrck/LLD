# Builder Pattern — Pizza Builder

**Intent:** Separate the construction of a complex object from its representation so the same construction process can create different representations.

## UML

```mermaid
classDiagram
    class Pizza {
        -size: String
        -crust: String
        -sauce: String
        -toppings: List~String~
        -extraCheese: boolean
        -isVegan: boolean
        -Pizza(builder: PizzaBuilder)
        +toString() String
    }

    class PizzaBuilder {
        +size: String
        +crust: String
        +sauce: String
        +toppings: List~String~
        +extraCheese: boolean
        +isVegan: boolean
        +PizzaBuilder(size: String)
        +crust(crust: String) PizzaBuilder
        +sauce(sauce: String) PizzaBuilder
        +toppings(toppings: List~String~) PizzaBuilder
        +extraCheese(extraCheese: boolean) PizzaBuilder
        +vegan(isVegan: boolean) PizzaBuilder
        +build() Pizza
    }

    Pizza *-- PizzaBuilder
```

## Roles
| Class | Role |
|---|---|
| `Pizza` | Product — immutable, private constructor |
| `PizzaBuilder` | Builder — fluent API, enforces required fields, calls `new Pizza(this)` |

## Why Builder here?
`Pizza` has 1 required field (`size`) and 5 optional ones. Without Builder this leads to telescoping constructors or mutable setters. Builder gives a readable, safe, immutable construction.
