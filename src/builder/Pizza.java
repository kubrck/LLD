package builder;

import java.util.List;

/*
 * Product — the complex object being constructed.
 * Instantiated only through PizzaBuilder to enforce a valid state.
 */
public class Pizza {

    private final String size;
    private final String crust;
    private final String sauce;
    private final List<String> toppings;
    private final boolean extraCheese;
    private final boolean isVegan;

    // Private constructor — only the builder can create a Pizza
    private Pizza(PizzaBuilder builder) {
        this.size = builder.size;
        this.crust = builder.crust;
        this.sauce = builder.sauce;
        this.toppings = builder.toppings;
        this.extraCheese = builder.extraCheese;
        this.isVegan = builder.isVegan;
    }

    @Override
    public String toString() {
        return String.format(
            "Pizza{size='%s', crust='%s', sauce='%s', toppings=%s, extraCheese=%s, vegan=%s}",
            size, crust, sauce, toppings, extraCheese, isVegan
        );
    }

    // ----- Static Builder -----
    public static class PizzaBuilder {

        private final String size;          // required
        private String crust = "thin";      // optional with default
        private String sauce = "tomato";
        private List<String> toppings = List.of();
        private boolean extraCheese = false;
        private boolean isVegan = false;

        public PizzaBuilder(String size) {
            if (size == null || size.isBlank()) {
                throw new IllegalArgumentException("Pizza size is required");
            }
            this.size = size;
        }

        public PizzaBuilder crust(String crust) {
            this.crust = crust;
            return this;
        }

        public PizzaBuilder sauce(String sauce) {
            this.sauce = sauce;
            return this;
        }

        public PizzaBuilder toppings(List<String> toppings) {
            this.toppings = toppings;
            return this;
        }

        public PizzaBuilder extraCheese(boolean extraCheese) {
            this.extraCheese = extraCheese;
            return this;
        }

        public PizzaBuilder vegan(boolean isVegan) {
            this.isVegan = isVegan;
            return this;
        }

        public Pizza build() {
            return new Pizza(this);
        }
    }
}
