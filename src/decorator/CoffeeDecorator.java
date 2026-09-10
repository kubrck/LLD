package decorator;

/*
 * Abstract Decorator — wraps a Coffee component and delegates to it.
 * Subclasses add their own behaviour on top.
 */
public abstract class CoffeeDecorator implements Coffee {

    protected final Coffee decoratedCoffee;

    protected CoffeeDecorator(Coffee coffee) {
        this.decoratedCoffee = coffee;
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription();
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost();
    }
}
