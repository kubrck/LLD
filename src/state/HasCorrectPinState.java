package state;

public class HasCorrectPinState implements ATMState {

    private final ATMMachine atm;

    public HasCorrectPinState(ATMMachine atm) {
        this.atm = atm;
    }

    @Override
    public void insertCard() {
        System.out.println("[HasCorrectPin] Card already inserted.");
    }

    @Override
    public void ejectCard() {
        System.out.println("[HasCorrectPin] Card ejected.");
        atm.setState(atm.getIdleState());
    }

    @Override
    public void enterPin(int pin) {
        System.out.println("[HasCorrectPin] PIN already verified.");
    }

    @Override
    public void requestCash(double amount) {
        if (amount <= 0) {
            System.out.println("[HasCorrectPin] Invalid amount.");
            return;
        }
        if (amount > atm.getBalance()) {
            System.out.printf("[HasCorrectPin] Insufficient funds. Available: $%.2f%n", atm.getBalance());
            return;
        }
        System.out.printf("[HasCorrectPin] Dispensing $%.2f...%n", amount);
        atm.setState(atm.getTransactionState());
        atm.requestCash(amount);
    }
}
