// AUTHOR: Tony Lim
// DATE CREATED: 13/05/2023
// DATE LAST EDITED: 13/05/2023

package nz.ac.auckland.se281;

import java.util.List;

public class MediumAi implements Ai {

  @Override
  public int[] play(int roundNum, List<Integer> fingerHistory) {
    Cpu cpu = new Cpu(null);
    // For the first 3 round, use RandomStrategy
    if (roundNum <= 3) {
      cpu.setStrategy(new RandomStrategy());
      return cpu.process();
      // 4th round onward, change to AverageStrategy
    } else {
      cpu.setStrategy(new AverageStrategy(fingerHistory));
      return cpu.process();
    }
  }
}
