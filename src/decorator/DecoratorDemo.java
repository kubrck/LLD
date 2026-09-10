package decorator;

/*
 * Decorator Pattern — Coffee Shop
 *
 * Intent: Attach additional responsibilities to an object dynamically.
 * Decorators provide a flexible alternative to subclassing for extending functionality.
 *
 * Real-world use: Starbucks-style drink customisation, I/O streams in Java,
 * middleware pipelines.
 */
public class DecoratorDemo {

    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        printOrder(coffee);

        // Add milk
        coffee = new MilkDecorator(coffee);
        printOrder(coffee);

        // Add sugar on top
        coffee = new SugarDecorator(coffee);
        printOrder(coffee);

        // Add whip cream on top
        coffee = new WhipDecorator(coffee);
        printOrder(coffee);

        // A different combo: double sugar, no milk
        System.out.println("\n--- New Order ---");
        Coffee order2 = new SugarDecorator(new SugarDecorator(new SimpleCoffee()));
        printOrder(order2);
    }

    private static void printOrder(Coffee coffee) {
        System.out.printf("%-50s $%.2f%n", coffee.getDescription(), coffee.getCost());
    }
}
