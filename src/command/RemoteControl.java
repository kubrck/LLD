package command;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * Invoker — stores commands and triggers them.
 * Keeps a history stack to support undo.
 */
public class RemoteControl {

    private final Deque<Command> history = new ArrayDeque<>();

    public void pressButton(Command command) {
        command.execute();
        history.push(command);
    }

    public void pressUndo() {
        if (history.isEmpty()) {
            System.out.println("Nothing to undo.");
            return;
        }
        Command last = history.pop();
        last.undo();
    }
}
