package command;

// Receiver — the object that knows how to perform the work
public class Light {

    private final String room;
    private boolean isOn = false;

    public Light(String room) {
        this.room = room;
    }

    public void turnOn() {
        isOn = true;
        System.out.println(room + " light is ON");
    }

    public void turnOff() {
        isOn = false;
        System.out.println(room + " light is OFF");
    }
}
