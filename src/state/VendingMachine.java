package state;

/*
 * Context — holds the current state and delegates every operation to it.
 * Passes `this` into each state method so states can read machine data
 * and call setState() to trigger transitions.
 */
public class VendingMachine {

    private VendingMachineState state;
    private int itemCount;
    private int balance; // coins inserted so far

    public VendingMachine(int itemCount) {
        this.itemCount = itemCount;
        this.state = itemCount > 0 ? new NoCoinState() : new SoldOutState();
    }

    public void insertCoin(int coin)  { state.insertCoin(this, coin); }
    public void selectItem()          { state.selectItem(this); }
    public void dispense()            { state.dispense(this); }
    public void returnCoin()          { state.returnCoin(this); }
    public void refill(int qty)       { state.refill(this, qty); }

    public void setState(VendingMachineState state) {
        this.state = state;
    }

    public int getItemCount()  { return itemCount; }
    public int getBalance()    { return balance; }

    public void addBalance(int coin)    { this.balance += coin; }
    public void resetBalance()          { this.balance = 0; }
    public void decrementItemCount()    { this.itemCount--; }
    public void addItemCount(int qty)   { this.itemCount += qty; }

    public String getCurrentState() { return state.getClass().getSimpleName(); }
}
