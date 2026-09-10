package state;

public class TransactionState implements ATMState {

    private final ATMMachine atm;

    public TransactionState(ATMMachine atm) {
        this.atm = atm;
    }

    @Override
    public void insertCard() {
        System.out.println("[Transaction] Transaction in progress.");
    }

    @Override
    public void ejectCard() {
        System.out.println("[Transaction] Please wait for transaction to complete.");
    }

    @Override
    public void enterPin(int pin) {
        System.out.println("[Transaction] Transaction in progress.");
    }

    @Override
    public void requestCash(double amount) {
        atm.deductBalance(amount);
        System.out.printf("[Transaction] $%.2f dispensed. Remaining balance: $%.2f%n",
            amount, atm.getBalance());
        System.out.println("[Transaction] Please take your card.");
        atm.setState(atm.getIdleState());
    }
}
