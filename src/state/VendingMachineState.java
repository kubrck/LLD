package state;

/*
 * Abstract State — defines the operations every state must handle.
 * Machine is passed as a parameter so states don't need to hold a back-reference;
 * they use it only to read data or trigger a transition via machine.setState().
 */
public abstract class VendingMachineState {

    public abstract void insertCoin(VendingMachine machine, int coin);

    public abstract void selectItem(VendingMachine machine);

    public abstract void dispense(VendingMachine machine);

    public abstract void returnCoin(VendingMachine machine);

    public abstract void refill(VendingMachine machine, int qty);
}
