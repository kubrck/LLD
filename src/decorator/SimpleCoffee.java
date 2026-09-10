package decorator;

// Concrete Component — base coffee without any add-ons
public class SimpleCoffee implements Coffee {

    @Override
    public String getDescription() {
        return "Simple Coffee";
    }

    @Override
    public double getCost() {
        return 1.00;
    }
}
