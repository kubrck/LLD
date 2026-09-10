package state;

// State interface — each concrete state implements these operations
public interface ATMState {
    void insertCard();
    void ejectCard();
    void enterPin(int pin);
    void requestCash(double amount);
}
