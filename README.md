# Snake Game

**Snake Game** is a classic arcade **snake game implemented in Java**. Move the snake, eat the food, grow longer, and avoid colliding with yourself or obstacles. This project demonstrates fundamentals of Java GUI programming, basic game logic, and handling sprite graphics.

## Features

- Classic snake gameplay mechanics  
- Java-based GUI using Swing
- Custom graphics for snake and enemies (provided as PNG images)
- Modular codebase for easy understanding
- Pre-built runnable JAR file for instant play

## Getting Started

### Prerequisites

- **Java Development Kit (JDK 8+)** is required to run and modify the source code.
- (Optional) **IntelliJ IDEA** or any Java IDE for development.

### Running the Game

You can run the game in one of two ways:

#### 1. Using the provided JAR


#### 2. Running from source

1. Compile all `.java` files:

    ```
    javac *.java
    ```

2. Run the game with:

    ```
    java Main
    ```

### File Structure

| File/Folder          | Description                                 |
|----------------------|---------------------------------------------|
| Main.java            | Game launcher and entry point               |
| GameFrame.java       | Main game window (JFrame)                   |
| GamePanel.java       | Core game logic, rendering, and input       |
| HeadingPanel.java    | Top heading/banners                         |
| GameConstants.java   | Game configuration constants                |
| *.png                | Game graphics (snake, enemy, directions)    |
| SnakeGame.jar        | Pre-built executable JAR                    |
| .idea/, *.iml, out/  | IDE/project build files (for IntelliJ)      |
| manifest.txt         | JAR manifest                                |

## Controls

- **Arrow Keys**: Change snake direction (Up, Down, Left, Right)
- **Esc / Close Window**: Exit game

## Customization

- To update snake or enemy sprites, replace the relevant `.png` image files.
- Constants like speed, grid size, and initial length can be tweaked in `GameConstants.java`.

## Contribution

Pull requests, issues, and suggestions are welcome to improve the game or codebase.

---

*Project maintained by [psanywal](https://github.com/psanywal). Contributions welcome!*
git add README.md
git commit -m "Added project README"
git push

