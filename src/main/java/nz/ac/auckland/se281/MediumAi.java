// AUTHOR: Tony Lim
// DATE CREATED: 13/05/2023
// DATE LAST EDITED: 13/05/2023

package nz.ac.auckland.se281;

import java.util.List;

public class MediumAi implements Ai {

  @Override
  public int[] play(int roundNum, List<Integer> fingerHistory) {
    CPU cpu = new CPU(null);
    if (roundNum <= 3) {
      cpu.setStrategy(new RandomStrategy());
      return cpu.process();
    } else {
      cpu.setStrategy(new AverageStrategy(fingerHistory));
      return cpu.process();
    }
  }
}
