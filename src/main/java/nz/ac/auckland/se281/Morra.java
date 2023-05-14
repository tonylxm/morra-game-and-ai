// AUTHOR: Tony Lim
// DATE CREATED: 04/05/2023
// DATE LAST EDITED: 13/05/2023

package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.List;
import nz.ac.auckland.se281.Main.Difficulty;

public class Morra {

  private String playerName;
  private String aiName = "Jarvis";
  private int roundNum = 0; // when roundNum = 0, this indicates no game is currently active
  private int winPoints;
  private int humanWins;
  private int aiWins;
  private Difficulty level;
  private List<Integer> fingerHistory;

  public Morra() {}

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    playerName = options[0];
    MessageCli.WELCOME_PLAYER.printMessage(playerName);
    // Keep track of number of rounds in this game and points to win
    roundNum = 1;
    winPoints = pointsToWin;
    // Reset score tally both to 0
    humanWins = 0;
    aiWins = 0;
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

      // Calculate and display results of round
      fingerHistory.add(choicesHuman[0]);
      calculateResult(choicesHuman, choicesAi);

      // After the current round of play is over, check if there is a winner
      isThereAWinner();
      roundNum += 1;
    }
  }

  public void showStats() {
    // Only show stats if a game is currently being played
    if (roundNum == 0) {
      MessageCli.GAME_NOT_STARTED.printMessage();
    } else {
      MessageCli.PRINT_PLAYER_WINS.printMessage(
          playerName, String.valueOf(humanWins), String.valueOf(winPoints - humanWins));
      MessageCli.PRINT_PLAYER_WINS.printMessage(
          aiName, String.valueOf(aiWins), String.valueOf(winPoints - aiWins));
    }
  }

  private void calculateResult(int[] human, int[] cpu) {
    // HUMAN_WINS = 0
    // CPU_WINS = 1
    // DRAW = 2

    int totalSum = human[0] + cpu[0];

    // If both guess correctly or no one guesses correctly, then it is a DRAW
    if (totalSum == human[1] && totalSum == cpu[1]) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");
    } else if (totalSum == human[1]) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("HUMAN_WINS");
      humanWins += 1;
    } else if (totalSum == cpu[1]) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("AI_WINS");
      aiWins += 1;
    } else {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");
    }
  }

  private void isThereAWinner() {
    if (humanWins == winPoints) {
      MessageCli.END_GAME.printMessage(playerName, String.valueOf(roundNum));
      roundNum =
          -1; // Game over, so reset roundNum to end current game (roundNum = 0 at the end of play
      // function)
    } else if (aiWins == winPoints) {
      MessageCli.END_GAME.printMessage(aiName, String.valueOf(roundNum));
      roundNum =
          -1; // Game over, so reset roundNum to end current game (roundNum = 0 at the end of play
      // function)
    }
  }
}
