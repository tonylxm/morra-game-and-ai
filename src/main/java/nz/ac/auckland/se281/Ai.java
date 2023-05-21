// AUTHOR: Tony Lim
// DATE CREATED: 12/05/2023
// DATE LAST EDITED: 21/05/2023

package nz.ac.auckland.se281;

import java.util.List;

public abstract class Ai {
  int roundNum;
  List<Integer> fingerHistory;

  // Constructor for EasyAi
  public Ai(int roundNum) {
    this.roundNum = roundNum;
  }

  // Constructor for Medium, Hard and Master Ais
  public Ai(int roundNum, List<Integer> fingerHistory) {
    this.roundNum = roundNum;
    this.fingerHistory = fingerHistory;
  }

  public int[] play() {
    // default strategy
    Cpu cpu = new Cpu(new RandomStrategy());
    return cpu.process();
  }
}
