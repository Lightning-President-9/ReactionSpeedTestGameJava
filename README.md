# ReactionSpeedTestGameJava
This Game is completely made in Java.
It has 3 Game Modes:
  1.One Shoot Mode
  2.One Min Mode
  3.Survival Mode

1.One Shoot Mode:
  In this mode there will be only a single target appearing.
  The time calculated will be based on when the target appered on screen.

2.One Min Mode:
  In this mode you will get 1 Min to hit as many as you can.

3.Survival Mode:
  In this mode there is no time restriction.
  the game loop will end either if you miss the target/hit a nottarget.

NOTE:Missing the target will cause instant lose in any of the modes.

Saving System:
  Sound Effect Volume and Game Music Volume are saved and loaded.
  Your record will be saved in txt file with their respective game mode.

NOTE:
  1.At first it will write 10 records.
  2.After 10 records , it will write only if it is better than the 10 records in the file.
  3.Also it will sort in ascending/descending order.
  4.One Shoot Mode - ascending order (Time).
  5.One Min and Survival Mode - descending order (Target Hit Count).
