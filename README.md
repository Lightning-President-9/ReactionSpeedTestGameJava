# ReactionSpeedTestGameJava
ReactionSpeedTestGame is a Java-made game that tests and enhances your reaction speed. It has three thrilling game modes that test your reflexes in various ways.

## Prerequisites
You will require the following software to be installed on your system:

- [Java Development Kit (JDK)](https://www.java.com/)
- [Eclipse IDE (optional)](https://www.eclipse.org/)

## Installing
Step-by-step instructions to install the development environment:

### Clone the repository:
```sh
git clone https://github.com/Lightning-President-9/ReactionSpeedTestGameJava.git
```

### Open Eclipse IDE and import the project:
- Go to **File > Import > General > Existing Projects into Workspace**.
- Choose the cloned repository directory.
- Complete the import process.

### Run the main class:
- Find the main class in the project.
- Right-click and choose **Run As > Java Application**.

## Built With
- [Eclipse](https://www.eclipse.org/) - The development IDE.
- [Java](https://www.java.com/) - The language used.

## Notes
### Explanation of 3 game modes:

#### One Shoot Mode:
- In this mode, there will be a single target.
- The time will be calculated from the moment the target was on the screen.

#### One Min Mode:
- You will be given 1 minute to get as many of the targets you can.

#### Survival Mode:
- There is no time limit for this mode.
- The game cycle will terminate in case you lose the target or hit a wrong target.
- **Note:** Losing the target will mean an immediate failure in any mode.

## Saving System
- Sound effect volume and game music volume are stored and retrieved.
- Your record will be stored in a text file with the corresponding game mode.

### Rules for Saving Records:
- In the beginning, 10 records are stored.
- Once 10 records have been made, a new record will be stored only if it is faster than the current 10 records.
- **Records are ordered in the following manner:**
  - **One Shoot Mode:** Order by ascending time (lower time is better).
  - **One Min and Survival Mode:** Target hit count in descending order (more hits are preferable).

## ReactionSpeedTestGame-v1.1
- Fixed the Time bug and included an alternate game music.

## Author
- [Lightning-President-9](https://github.com/Lightning-President-9) - Original work

## License
This project is licensed under the [MIT License](https://github.com/Lightning-President-9/ReactionSpeedTestGameJava/blob/main/LICENSE) - see the LICENSE file for details.
