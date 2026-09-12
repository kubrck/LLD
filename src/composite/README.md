# Composite Pattern — File System

**Intent:** Compose objects into tree structures to represent part-whole hierarchies. Lets clients treat individual objects and compositions uniformly.

## UML

```mermaid
classDiagram
    class FileSystemComponent {
        <<interface>>
        +getName() String
        +getSize() long
        +display(indent: String) void
    }

    class File {
        -name: String
        -size: long
        +getName() String
        +getSize() long
        +display(indent: String) void
    }

    class Directory {
        -name: String
        -children: List~FileSystemComponent~
        +add(component: FileSystemComponent) void
        +remove(component: FileSystemComponent) void
        +getName() String
        +getSize() long
        +display(indent: String) void
    }

    FileSystemComponent <|.. File
    FileSystemComponent <|.. Directory
    Directory o--> "many" FileSystemComponent : contains
```

## Roles
| Class | Role |
|---|---|
| `FileSystemComponent` | Component — uniform interface for leaf and composite |
| `File` | Leaf — no children, holds actual size |
| `Directory` | Composite — holds children, delegates `getSize()` recursively |
