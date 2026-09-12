package state;

// State: coin has been inserted, waiting for item selection
public class HasCoinState extends VendingMachineState {

    @Override
    public void insertCoin(VendingMachine machine, int coin) {
        machine.addBalance(coin);
        System.out.println("Additional coin inserted. Total balance: " + machine.getBalance());
    }

    @Override
    public void selectItem(VendingMachine machine) {
        System.out.println("Item selected. Dispensing...");
        machine.setState(new DispenseState());
        machine.dispense();
    }

    @Override
    public void dispense(VendingMachine machine) {
        System.out.println("Please select an item first.");
    }

    @Override
    public void returnCoin(VendingMachine machine) {
        System.out.println("Returning " + machine.getBalance() + " coins.");
        machine.resetBalance();
        machine.setState(new NoCoinState());
    }

    @Override
    public void refill(VendingMachine machine, int qty) {
        machine.addItemCount(qty);
        System.out.println("Refilled " + qty + " items. Total: " + machine.getItemCount());
    }
}
