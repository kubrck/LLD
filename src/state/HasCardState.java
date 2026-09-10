package state;

public class HasCardState implements ATMState {

    private static final int CORRECT_PIN = 1234;
    private final ATMMachine atm;

    public HasCardState(ATMMachine atm) {
        this.atm = atm;
    }

    @Override
    public void insertCard() {
        System.out.println("[HasCard] Card already inserted.");
    }

    @Override
    public void ejectCard() {
        System.out.println("[HasCard] Card ejected.");
        atm.setState(atm.getIdleState());
    }

    @Override
    public void enterPin(int pin) {
        if (pin == CORRECT_PIN) {
            System.out.println("[HasCard] PIN correct. Select transaction.");
            atm.setState(atm.getHasCorrectPinState());
        } else {
            System.out.println("[HasCard] Incorrect PIN. Card ejected.");
            atm.setState(atm.getIdleState());
        }
    }

    @Override
    public void requestCash(double amount) {
        System.out.println("[HasCard] Enter PIN before requesting cash.");
    }
}
