package command;

public class FanHighCommand implements Command {

    private final Fan fan;
    private int prevSpeed;

    public FanHighCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        prevSpeed = fan.getSpeed();
        fan.high();
    }

    @Override
    public void undo() {
        // Restore previous speed on undo
        switch (prevSpeed) {
            case 0 -> fan.off();
            case 2 -> fan.medium();
            default -> fan.high();
        }
    }
}
