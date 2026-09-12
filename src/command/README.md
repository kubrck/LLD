# Command Pattern — Smart Home Remote Control

**Intent:** Encapsulate a request as an object, letting you parameterise clients, queue requests, and support undoable operations.

## UML

```mermaid
classDiagram
    class Command {
        <<interface>>
        +execute() void
        +undo() void
    }

    class LightOnCommand {
        -light: Light
        +execute() void
        +undo() void
    }

    class LightOffCommand {
        -light: Light
        +execute() void
        +undo() void
    }

    class FanHighCommand {
        -fan: Fan
        -prevSpeed: int
        +execute() void
        +undo() void
    }

    class Light {
        -room: String
        -isOn: boolean
        +turnOn() void
        +turnOff() void
    }

    class Fan {
        -room: String
        -speed: int
        +high() void
        +medium() void
        +off() void
        +getSpeed() int
    }

    class RemoteControl {
        -history: Deque~Command~
        +pressButton(command: Command) void
        +pressUndo() void
    }

    Command <|.. LightOnCommand
    Command <|.. LightOffCommand
    Command <|.. FanHighCommand
    LightOnCommand o--> Light
    LightOffCommand o--> Light
    FanHighCommand o--> Fan
    RemoteControl o--> Command
```

## Roles
| Class | Role |
|---|---|
| `Command` | Command interface |
| `LightOnCommand`, `LightOffCommand`, `FanHighCommand` | Concrete commands |
| `Light`, `Fan` | Receivers — perform the actual work |
| `RemoteControl` | Invoker — triggers commands, maintains undo history |
