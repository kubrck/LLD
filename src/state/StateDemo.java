package state;

/*
 * State Pattern — ATM Machine
 *
 * Intent: Allow an object to alter its behaviour when its internal state changes.
 * The object will appear to change its class.
 *
 * Real-world use: ATM workflow, order lifecycle (Pending -> Shipped -> Delivered),
 * vending machines, traffic lights, game character states.
 */
public class StateDemo {

    public static void main(String[] args) {
        ATMMachine atm = new ATMMachine(500.00);

        System.out.println("--- Scenario 1: Successful withdrawal ---");
        atm.insertCard();
        atm.enterPin(1234);
        atm.requestCash(200.00);

        System.out.println("\n--- Scenario 2: Wrong PIN ---");
        atm.insertCard();
        atm.enterPin(9999);
        atm.requestCash(100.00); // should fail — no card

        System.out.println("\n--- Scenario 3: Insufficient funds ---");
        atm.insertCard();
        atm.enterPin(1234);
        atm.requestCash(10000.00);

        System.out.println("\n--- Scenario 4: Eject before PIN ---");
        atm.insertCard();
        atm.ejectCard();
        atm.requestCash(50.00); // should fail — no card
    }
}
