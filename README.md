# ReactionSpeedTestGameJava

ReactionSpeedTestGame is a game made in Java , designed to test and improve your reaction speed. It features three exciting game modes that challenge your reflexes in different ways.

### Prerequisites

You will need the following software installed on your system:

- Java Development Kit (JDK)
- Eclipse IDE (recommended)

### Installing

A step-by-step guide to set up the development environment:

1. **Clone the repository:**
   ```sh
   git clone https://github.com/Lightning-President-9/ReactionSpeedTestGameJava.git
   ```
   
2. **Open Eclipse IDE and import the project:**
   - Go to `File > Import > General > Existing Projects into Workspace`.
   - Select the cloned repository directory.
   - Finish the import process.

3. **Run the main class:**
   - Locate the main class in the project.
   - Right-click and select `Run As > Java Application`.

## Built With

* [Eclipse](https://www.eclipse.org/) - The IDE used for development.
* [Java](https://www.java.com/) - The programming language used.

## Notes

Description of 3 game modes:

1. **One Shoot Mode:**
   - In this mode, a single target will appear.
   - The time calculated will be based on when the target appeared on screen.

2. **One Min Mode:**
   - In this mode, you will get 1 minute to hit as many targets as you can.

3. **Survival Mode:**
   - In this mode, there is no time restriction.
   - The game loop will end either if you miss the target or hit a non-target.

**NOTE:** Missing the target will cause an instant loss in any of the modes.

### Saving System

- Sound effect volume and game music volume are saved and loaded.
- Your record will be saved in a text file with the respective game mode.

**Record Saving Rules:**
1. Initially, 10 records are saved.
2. After 10 records, a new record will be saved only if it is better than the existing 10 records.
3. Records are sorted as follows:
   - One Shoot Mode: Ascending order by time (less time is better).
   - One Min and Survival Mode: Descending order by target hit count (more hits are better).

## Author

* **Lightning-President-9** - *Initial work* - [Lightning-President-9](https://github.com/Lightning-President-9)

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE) file for details.
