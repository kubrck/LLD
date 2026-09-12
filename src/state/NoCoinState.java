package state;

// State: machine is idle, waiting for a coin to be inserted
public class NoCoinState extends VendingMachineState {

    @Override
    public void insertCoin(VendingMachine machine, int coin) {
        machine.addBalance(coin);
        System.out.println("Coin inserted: " + coin + ". Balance: " + machine.getBalance());
        machine.setState(new HasCoinState());
    }

    @Override
    public void selectItem(VendingMachine machine) {
        System.out.println("Please insert a coin first.");
    }

    @Override
    public void dispense(VendingMachine machine) {
        System.out.println("Please insert a coin and select an item first.");
    }

    @Override
    public void returnCoin(VendingMachine machine) {
        System.out.println("No coin to return.");
    }

    @Override
    public void refill(VendingMachine machine, int qty) {
        machine.addItemCount(qty);
        System.out.println("Refilled " + qty + " items. Total: " + machine.getItemCount());
    }
}
