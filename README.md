# String List
This project involves creating two different classes, `ArrayStringList` and `LinkedStringList`, which implement the same interface via a common abstract parent class `BaseStringList`. The classes are part of a string list data structure, allowing users to store and manipulate a list of strings dynamically. The specific requirements for each class are outlined below, including details about their implementations and relationships.

## Design Overview
The project follows a hierarchical structure where `BaseStringList` serves as the abstract parent class for `ArrayStringList` and `LinkedStringList`. Both child classes implement the same interface `StringList`, which defines common operations for managing string lists. The diagram below illustrates the relationship between the classes and the interface.

## Functionality
`BaseStringList`:
- Creates an abstract class `BaseStringList` implementing a subset of methods defined in the `StringList` interface.
- The class should not rely on specific underlying data structures and must be implemented in a general manner to work with both `ArrayStringList` and `LinkedStringList`.
- Ensures proper initialization and management of the `size` instance variable.
- Implements methods as specified in the UML diagram for `BaseStringList`.

`ArrayStringList`:
- Extends `BaseStringList` to implement the `StringList` interface.
- Defines and documents a default constructor for initializing the list.
- Implements resizing of internal storage to accommodate more list elements efficiently.

`LinkedStringList`:
- Extends `BaseStringList` to implement the `StringList` interface.
- Defines and documents a default constructor for initializing the list.
- Implements necessary methods to manage a linked list-based storage structure efficiently.

## File Structure and Content
```
string-list/
├── compile.sh
├── img
│   ├── GamePhase.NEW.png
│   ├── GamePhase.NEW.svg
│   ├── GamePhase.OVER.POST.png
│   ├── GamePhase.OVER.POST.svg
│   ├── GamePhase.OVER.PRE-1.png
│   ├── GamePhase.OVER.PRE.png
│   ├── GamePhase.OVER.PRE.svg
│   ├── GamePhase.PLAYABLE.1.png
│   ├── GamePhase.PLAYABLE.1.svg
│   ├── GamePhase.PLAYABLE.2.png
│   ├── GamePhase.PLAYABLE.2.svg
│   ├── GamePhase.PLAYABLE.3.png
│   ├── GamePhase.PLAYABLE.3.svg
│   ├── GamePhase.PLAYABLE.4.png
│   ├── GamePhase.PLAYABLE.4.svg
│   ├── GamePhase.READY.png
│   ├── GamePhase.READY.svg
│   ├── phases.png
│   └── phases.svg
├── lib
│   └── gameutil.jar
├── README.md
├── resources
│   ├── connectfour.txt
│   ├── gameover.txt
│   └── welcome.txt
└── src
    ├── ConnectFourCLI.java
    ├── ConnectFour.java
    └── ConnectFourTester.java
```
