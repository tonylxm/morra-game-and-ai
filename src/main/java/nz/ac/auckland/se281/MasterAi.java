// AUTHOR: Tony Lim
// DATE CREATED: 14/05/2023
// DATE LAST EDITED: 14/05/2023

package nz.ac.auckland.se281;

import java.util.List;

public class MasterAi implements Ai {

  @Override
  public int[] play(int roundNum, List<Integer> fingerHistory) {
    CPU cpu = new CPU(null);
    if (roundNum <= 3) {
      cpu.setStrategy(new RandomStrategy());
      return cpu.process();
    } else {
      // Alternate between Average and Top Strategies:
      // Even roundNum = Average Strategy
      // Odd roundNum = Top Strategy
      if (roundNum % 2 == 0) {
        cpu.setStrategy(new AverageStrategy(fingerHistory));
        return cpu.process();
      } else {
        cpu.setStrategy(new TopStrategy(fingerHistory));
        return cpu.process();
      }
    }
  }
}
