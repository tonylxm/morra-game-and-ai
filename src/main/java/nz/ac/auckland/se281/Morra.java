// AUTHOR: Tony Lim
// DATE CREATED: 04/05/2023
// DATE LAST EDITED: 13/05/2023

package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.List;
import nz.ac.auckland.se281.Main.Difficulty;

public class Morra {

  private String playerName;
  private int roundNum = 0;
  private Difficulty level;
  private List<Integer> fingerHistory;

  public Morra() {}

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    playerName = options[0];
    MessageCli.WELCOME_PLAYER.printMessage(playerName);
    // Keep track of number of rounds in this game
    roundNum = 1;
    level = difficulty;
    fingerHistory = new ArrayList<Integer>();
  }

  // Main game loop
  public void play() {

    // Check if a newGame has started
    if (roundNum == 0) {
      MessageCli.GAME_NOT_STARTED.printMessage();
    } else {

      // Specify which round of play
      MessageCli.START_ROUND.printMessage(String.valueOf(roundNum));

      // Instantiate AI and Human
      Ai ai = AiFactory.createAi(level);
      Human player = new Human(playerName);

      // Player and AI play the game and save both answers as respective variables
      int[] choicesHuman = player.play();
      int[] choicesAi = ai.play(roundNum, fingerHistory);

      // Calculate and display outcome
      fingerHistory.add(choicesHuman[0]);
      int result = calculateResult(choicesHuman, choicesAi);

      roundNum += 1;
    }
  }

  public void showStats() {}

  private int calculateResult(int[] human, int[] cpu) {
    // HUMAN_WINS = 0
    // CPU_WINS = 1
    // DRAW = 2

    int totalSum = human[0] + cpu[0];

    if (totalSum == human[1]) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("HUMAN_WINS");
      return 0;
    } else if (totalSum == cpu[1]) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("AI_WINS");
      return 1;
    } else {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");
      return 2;
    }
  }
}
