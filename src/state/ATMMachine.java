package state;

/*
 * Context — the ATM machine. Delegates all state-specific behaviour to the
 * current ATMState object. State transitions happen inside the state classes.
 */
public class ATMMachine {

    private ATMState idleState;
    private ATMState hasCardState;
    private ATMState hasCorrectPinState;
    private ATMState transactionState;

    private ATMState currentState;
    private double balance;

    public ATMMachine(double initialBalance) {
        this.balance = initialBalance;

        idleState          = new IdleState(this);
        hasCardState       = new HasCardState(this);
        hasCorrectPinState = new HasCorrectPinState(this);
        transactionState   = new TransactionState(this);

        currentState = idleState;
    }

    public void insertCard()          { currentState.insertCard(); }
    public void ejectCard()           { currentState.ejectCard(); }
    public void enterPin(int pin)     { currentState.enterPin(pin); }
    public void requestCash(double amt) { currentState.requestCash(amt); }

    public void setState(ATMState state) {
        this.currentState = state;
    }

    public double getBalance() { return balance; }

    public void deductBalance(double amount) { balance -= amount; }

    // State accessors for use by concrete states
    public ATMState getIdleState()          { return idleState; }
    public ATMState getHasCardState()       { return hasCardState; }
    public ATMState getHasCorrectPinState() { return hasCorrectPinState; }
    public ATMState getTransactionState()   { return transactionState; }
}
