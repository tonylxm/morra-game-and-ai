// AUTHOR: Tony Lim
// DATE CREATED: 14/05/2023
// DATE LAST EDITED: 14/05/2023

package nz.ac.auckland.se281;

import java.util.List;

public class HardAi implements Ai {

  @Override
  public int[] play(int roundNum, List<Integer> fingerHistory) {
    Cpu cpu = new Cpu(null);
    // For the first 3 round, use RandomStrategy
    if (roundNum <= 3) {
      cpu.setStrategy(new RandomStrategy());
      return cpu.process();
      // 4th round onward, change to TopStrategy
    } else {
      cpu.setStrategy(new TopStrategy(fingerHistory));
      return cpu.process();
    }
  }
}
