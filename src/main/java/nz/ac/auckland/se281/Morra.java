// AUTHOR: Tony Lim
// DATE CREATED: 04/05/2023
// DATE LAST EDITED: 04/05/2023

package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class Morra {

  private String playerName;
  private int roundNum = 0;

  public Morra() {
  }

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    playerName = options[0];
    MessageCli.WELCOME_PLAYER.printMessage(playerName);
    // Keep track of number of rounds in this game
    roundNum = 1;
  }

  public void play() {

    // Check if a newGame has started
    if (roundNum == 0) {
      MessageCli.GAME_NOT_STARTED.printMessage();
    } else {
      // Specify which round of play
      MessageCli.START_ROUND.printMessage(String.valueOf(roundNum));
      roundNum += 1;

      CPU cpu = new CPU(new EasyStrategy());
      Human player = new Human(playerName);
      player.play();
      cpu.play();
    }
  }

  public void showStats() {
  }
}
