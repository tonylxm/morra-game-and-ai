// AUTHOR: Tony Lim
// DATE CREATED: 09/05/2023
// DATE LAST EDITED: 13/05/2023

package nz.ac.auckland.se281;

import java.util.List;

public class AverageStrategy extends Strategy {

  private double avg = 0;
  private int i;

  public AverageStrategy(List<Integer> fingerHistory) {
    super(fingerHistory);
  }

  @Override
  public void calculateSum() {
    for (i = 0; i < fingerHistory.size(); i++) {
      avg += fingerHistory.get(i);
    }

    avg = avg / i;
    fingersAndSum[1] = fingersAndSum[0] + (int) Math.round(avg);
  }
}
