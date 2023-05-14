// AUTHOR: Tony Lim
// DATE CREATED: 12/05/2023
// DATE LAST EDITED: 13/05/2023

package nz.ac.auckland.se281;

import java.util.List;

public class EasyAi implements Ai {

  @Override
  public int[] play(int roundNum, List<Integer> fingerHistory) {
    Cpu cpu = new Cpu(new RandomStrategy()); // EasyAi only uses a Random Strategy
    return cpu.process();
  }
}
