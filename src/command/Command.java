package command;

// Command interface — encapsulates an action and its undo
public interface Command {
    void execute();
    void undo();
}
