// AUTHOR: Tony Lim
// DATE CREATED: 13/05/2023
// DATE LAST EDITED: 21/05/2023

package nz.ac.auckland.se281;

import java.util.List;

public class MediumAi extends Ai {

  public MediumAi(int roundNum, List<Integer> fingerHistory) {
    super(roundNum, fingerHistory);
  }

  @Override
  public int[] play() {
    Cpu cpu = new Cpu(null);
    // For the first 3 round, use default RandomStrategy
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
