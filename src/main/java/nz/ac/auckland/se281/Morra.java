// AUTHOR: Tony Lim
// DATE CREATED: 04/05/2023
// DATE LAST EDITED: 04/05/2023


package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class Morra {

  private int roundNum;
  private int fingers;
  private int sum;

  public Morra() {}

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    // Keep track of number of rounds in this game
    roundNum = 1;
  }

  public void play() {
    // Specify which round of play
    MessageCli.START_ROUND.printMessage(String.valueOf(roundNum));
    roundNum += 1;

    while (true) {
      MessageCli.ASK_INPUT.printMessage();

      // Process, check and assign inputs to variables
      String input = Utils.scanner.nextLine();
      String[] split = input.split(" ");
      // Check if input is a valid integer, otherwise throw error
      try {
        fingers = Integer.parseInt(split[0]);
        sum = Integer.parseInt(split[1]);
        if ((fingers >= 1 && fingers <= 5) && (sum >= 1 && sum <= 10)) {
          break;
        } else {
          MessageCli.INVALID_INPUT.printMessage();
        }
      } catch (NumberFormatException ex) {
        MessageCli.INVALID_INPUT.printMessage();
      }
    }

    
    


  }

  public void showStats() {}
}
