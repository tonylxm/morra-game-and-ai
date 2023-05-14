// AUTHOR: Tony Lim
// DATE CREATED: 06/05/2023
// DATE LAST EDITED: 13/05/2023

package nz.ac.auckland.se281;

import java.util.List;

// Optted for abstract class over interface as such to promote inheritance and code reuse
public abstract class Strategy {
  protected int[] fingersAndSum = new int[2];
  protected List<Integer> fingerHistory;

  // Constructor for RandomStrategy
  public Strategy() {
    fingersAndSum[0] = Utils.getRandomNumber(1, 5);
  }

  // Constructor for Average and Top Strategies that need fingerHistory data
  public Strategy(List<Integer> fingerHistory) {
    fingersAndSum[0] = Utils.getRandomNumber(1, 5);
    this.fingerHistory = fingerHistory;
  }

  public void calculateSum() {}

  // All Strategies print Jarvis' hand the same way
  public void printInfoHand() {
    MessageCli.PRINT_INFO_HAND.printMessage(
        "Jarvis", String.valueOf(fingersAndSum[0]), String.valueOf(fingersAndSum[1]));
  }

  public int[] getFingersAndSum() {
    return fingersAndSum;
  }
}
