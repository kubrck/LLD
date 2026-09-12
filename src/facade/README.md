# Facade Pattern — Home Theater System

**Intent:** Provide a unified, simplified interface to a complex subsystem.

## UML

```mermaid
classDiagram
    class HomeTheaterFacade {
        -projector: Projector
        -amplifier: Amplifier
        -player: StreamingPlayer
        -lights: TheaterLights
        -popper: PopcornPopper
        +watchMovie(movie: String) void
        +endMovie() void
    }

    class Projector {
        +on() void
        +off() void
        +wideScreenMode() void
    }

    class Amplifier {
        +on() void
        +off() void
        +setVolume(vol: int) void
    }

    class StreamingPlayer {
        +on() void
        +off() void
        +play(movie: String) void
        +stop() void
    }

    class TheaterLights {
        +on() void
        +dim(level: int) void
    }

    class PopcornPopper {
        +on() void
        +off() void
        +pop() void
    }

    HomeTheaterFacade *--> Projector
    HomeTheaterFacade *--> Amplifier
    HomeTheaterFacade *--> StreamingPlayer
    HomeTheaterFacade *--> TheaterLights
    HomeTheaterFacade *--> PopcornPopper
```

## Roles
| Class | Role |
|---|---|
| `HomeTheaterFacade` | Facade — exposes `watchMovie()` / `endMovie()` hiding 10+ subsystem calls |
| `Projector`, `Amplifier`, `StreamingPlayer`, `TheaterLights`, `PopcornPopper` | Subsystem classes |
