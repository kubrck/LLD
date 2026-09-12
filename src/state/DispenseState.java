package state;

// State: item is being dispensed
public class DispenseState extends VendingMachineState {

    @Override
    public void insertCoin(VendingMachine machine, int coin) {
        System.out.println("Please wait, dispensing in progress.");
    }

    @Override
    public void selectItem(VendingMachine machine) {
        System.out.println("Already dispensing an item.");
    }

    @Override
    public void dispense(VendingMachine machine) {
        machine.decrementItemCount();
        machine.resetBalance();
        System.out.println("Item dispensed! Remaining items: " + machine.getItemCount());

        if (machine.getItemCount() == 0) {
            System.out.println("Machine is now sold out.");
            machine.setState(new SoldOutState());
        } else {
            machine.setState(new NoCoinState());
        }
    }

    @Override
    public void returnCoin(VendingMachine machine) {
        System.out.println("Cannot return coin, dispensing in progress.");
    }

    @Override
    public void refill(VendingMachine machine, int qty) {
        System.out.println("Cannot refill during dispensing.");
    }
}
