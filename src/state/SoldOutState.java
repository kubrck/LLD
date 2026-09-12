package state;

// State: machine has no items left
public class SoldOutState extends VendingMachineState {

    @Override
    public void insertCoin(VendingMachine machine, int coin) {
        System.out.println("Machine is sold out. Cannot accept coins.");
    }

    @Override
    public void selectItem(VendingMachine machine) {
        System.out.println("Machine is sold out.");
    }

    @Override
    public void dispense(VendingMachine machine) {
        System.out.println("Machine is sold out. Nothing to dispense.");
    }

    @Override
    public void returnCoin(VendingMachine machine) {
        System.out.println("No coin inserted.");
    }

    @Override
    public void refill(VendingMachine machine, int qty) {
        machine.addItemCount(qty);
        System.out.println("Refilled " + qty + " items. Machine ready.");
        machine.setState(new NoCoinState());
    }
}
