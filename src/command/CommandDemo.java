package command;

/*
 * Command Pattern — Smart Home Remote Control
 *
 * Intent: Encapsulate a request as an object, thereby letting you parameterize
 * clients with different requests, queue or log requests, and support undoable operations.
 *
 * Real-world use: Smart home systems, text editor undo/redo, job queues, macros.
 */
public class CommandDemo {

    public static void main(String[] args) {
        Light livingRoomLight = new Light("Living Room");
        Light kitchenLight    = new Light("Kitchen");
        Fan   bedroomFan      = new Fan("Bedroom");

        RemoteControl remote = new RemoteControl();

        System.out.println("--- Pressing buttons ---");
        remote.pressButton(new LightOnCommand(livingRoomLight));
        remote.pressButton(new LightOnCommand(kitchenLight));
        remote.pressButton(new FanHighCommand(bedroomFan));
        remote.pressButton(new LightOffCommand(kitchenLight));

        System.out.println("\n--- Undo last 3 actions ---");
        remote.pressUndo();
        remote.pressUndo();
        remote.pressUndo();
    }
}
