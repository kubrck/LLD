package state;

public class IdleState implements ATMState {

    private final ATMMachine atm;

    public IdleState(ATMMachine atm) {
        this.atm = atm;
    }

    @Override
    public void insertCard() {
        System.out.println("[Idle] Card inserted. Please enter your PIN.");
        atm.setState(atm.getHasCardState());
    }

    @Override
    public void ejectCard() {
        System.out.println("[Idle] No card to eject.");
    }

    @Override
    public void enterPin(int pin) {
        System.out.println("[Idle] Insert card first.");
    }

    @Override
    public void requestCash(double amount) {
        System.out.println("[Idle] Insert card first.");
    }
}
