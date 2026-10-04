# Tower Defense 

A simple 2D tower defense game written in Java. Survive wave after wave of monsters
by upgrading your tower and recruiting heroes. Created as a university term project.

<img width="1741" height="1011" alt="image" src="https://github.com/user-attachments/assets/64a4b043-7d76-4040-9b1e-40b2eb9912fd" />


## Features
- Endless waves of monsters that get bigger with every round
- Three enemy types: Skeleton, Zombie and Slime (a big slime splits into two smaller ones when killed)
- Two types of heroes: Warrior and Knight, bought with coins earned for kills
- Tower upgrades that level up all your heroes at once
- "Super hit" ability: a 60-second power-up for your heroes
- Graphical interface built with Java Swing

## Tech Stack
Java 25, Swing (Java 2D), Checkstyle, OOP

## Getting Started

1. Install [JDK 25](https://www.oracle.com/java/technologies/downloads/#java25) or newer.
2. Download the latest `.jar` file from the [Releases](../../releases) page.
3. Double-click the file, or run it from a terminal:
```bash
java -jar tower-defense.jar
```

**Run from source:** clone the repository, open it in IntelliJ IDEA, mark `src` as
*Sources Root* and `res` as *Resources Root*, then run `main.Main`.

## How to Play
1. Press **Start wave** to send the monsters.
2. Heroes patrol in front of the tower and attack enemies on their way.
3. Spend coins on **Add warrior**, **Add knight** or **Tower lvl up**.
4. Use **Super hit** to boost your heroes for 60 seconds (available once per wave).
5. If the tower's HP drops to zero, the wave is lost. Try again!

## Project Structure
- `main/` - `Main` (entry point) and `Game` (game loop, UI and economy)
- `player/` - `Tower`, abstract `Hero`, `Warrior`, `Knight`
- `monsters/` - abstract `Enemy`, `Skeleton`, `Zombie`, `Slime`
- `res/` - images and other resources

## Roadmap
- Unique ability for the Knight
- Unit tests for combat logic
