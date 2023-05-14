// AUTHOR: Tony Lim
// DATE CREATED: 07/05/2023
// DATE LAST EDITED: 09/05/2023

package nz.ac.auckland.se281;

public class RandomStrategy extends Strategy {

  @Override
  public void calculateSum() {
    fingersAndSum[1] = Utils.getRandomNumber(fingersAndSum[0] + 1, fingersAndSum[0] + 5);
  }
}
