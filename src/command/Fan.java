package command;

// Receiver — the object that knows how to perform the work
public class Fan {

    private final String room;
    private int speed = 0; // 0 = off, 1 = low, 2 = medium, 3 = high

    public Fan(String room) {
        this.room = room;
    }

    public void high() {
        speed = 3;
        System.out.println(room + " fan on HIGH");
    }

    public void medium() {
        speed = 2;
        System.out.println(room + " fan on MEDIUM");
    }

    public void off() {
        speed = 0;
        System.out.println(room + " fan OFF");
    }

    public int getSpeed() {
        return speed;
    }
}
