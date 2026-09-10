package builder;

import java.util.List;

/*
 * Builder Pattern — Pizza Builder
 *
 * Intent: Separate the construction of a complex object from its representation
 * so that the same construction process can create different representations.
 *
 * Real-world use: Constructing complex objects with many optional fields,
 * HTTP request builders, SQL query builders, test data builders.
 */
public class BuilderDemo {

    public static void main(String[] args) {
        // All options configured
        Pizza margherita = new Pizza.PizzaBuilder("Large")
            .crust("thin")
            .sauce("tomato")
            .toppings(List.of("mozzarella", "basil", "olive oil"))
            .extraCheese(true)
            .build();

        System.out.println("Order 1: " + margherita);

        // Minimal build — only required field
        Pizza plain = new Pizza.PizzaBuilder("Small")
            .build();

        System.out.println("Order 2: " + plain);

        // Vegan pizza
        Pizza vegan = new Pizza.PizzaBuilder("Medium")
            .crust("whole-wheat")
            .sauce("pesto")
            .toppings(List.of("mushrooms", "bell peppers", "onions", "spinach"))
            .vegan(true)
            .build();

        System.out.println("Order 3: " + vegan);
    }
}
