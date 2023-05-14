// AUTHOR: Tony Lim
// DATE CREATED: 07/05/2023
// DATE LAST EDITED: 09/05/2023

package nz.ac.auckland.se281;

// 'Brains' behind the AI - processes all the commands of the respective strategy based on which AI
// calls it
public class Cpu {
  private Strategy strategy;

  public Cpu(Strategy strategy) {
    this.strategy = strategy;
  }

  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  public int[] process() {
    strategy.calculateSum();
    strategy.printInfoHand();
    return strategy.getFingersAndSum();
  }
}
