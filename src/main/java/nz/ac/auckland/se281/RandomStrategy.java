// AUTHOR: Tony Lim
// DATE CREATED: 07/05/2023
// DATE LAST EDITED: 09/05/2023

package nz.ac.auckland.se281;

public class RandomStrategy extends Strategy {

  @Override
  public int[] decideFingerAndSum() {
    fingersAndSum[0] = Utils.getRandomNumber(1, 5);
    fingersAndSum[1] = Utils.getRandomNumber(fingersAndSum[0] + 1, fingersAndSum[0] + 5);
    MessageCli.PRINT_INFO_HAND.printMessage(
        "Jarvis", String.valueOf(fingersAndSum[0]), String.valueOf(fingersAndSum[1]));
    return fingersAndSum;
  }
}
