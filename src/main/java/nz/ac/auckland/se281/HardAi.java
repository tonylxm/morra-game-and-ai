package nz.ac.auckland.se281;

import java.util.List;

public class HardAi implements Ai {

  @Override
  public int[] play(int roundNum, List<Integer> fingerHistory) {
    CPU cpu = new CPU(null);
    if (roundNum <= 3) {
      cpu.setStrategy(new RandomStrategy());
      return cpu.process();
    } else {
      cpu.setStrategy(new TopStrategy(fingerHistory));
      return cpu.process();
    }
  }
}
