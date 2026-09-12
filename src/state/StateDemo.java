package state;

/*
 * State Pattern — Vending Machine
 *
 * Intent: Allow an object to alter its behaviour when its internal state changes.
 * The object will appear to change its class.
 *
 * Real-world use: Vending machines, order lifecycle, traffic lights, ATM workflow.
 */
public class StateDemo {

    public static void main(String[] args) {
        VendingMachine machine = new VendingMachine(2);

        System.out.println("--- Scenario 1: Normal purchase ---");
        machine.insertCoin(5);
        machine.selectItem();

        System.out.println("\n--- Scenario 2: Return coin ---");
        machine.insertCoin(5);
        machine.returnCoin();

        System.out.println("\n--- Scenario 3: Last item — machine goes sold out ---");
        machine.insertCoin(5);
        machine.selectItem();

        System.out.println("\n--- Scenario 4: Machine sold out ---");
        machine.insertCoin(5);
        machine.selectItem();

        System.out.println("\n--- Scenario 5: Refill and purchase ---");
        machine.refill(3);
        machine.insertCoin(5);
        machine.selectItem();
    }
}
