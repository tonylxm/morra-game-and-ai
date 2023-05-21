// AUTHOR: Tony Lim
// DATE CREATED: 14/05/2023
// DATE LAST EDITED: 21/05/2023

package nz.ac.auckland.se281;

import java.util.List;

public class MasterAi extends Ai {

  public MasterAi(int roundNum, List<Integer> fingerHistory) {
    super(roundNum, fingerHistory);
  }

  @Override
  public int[] play() {
    Cpu cpu = new Cpu(null);
    // For the first 3 round, use default RandomStrategy
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
