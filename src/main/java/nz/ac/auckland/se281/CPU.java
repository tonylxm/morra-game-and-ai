// AUTHOR: Tony Lim
// DATE CREATED: 07/05/2023
// DATE LAST EDITED: 09/05/2023

package nz.ac.auckland.se281;

public class CPU {
    private Strategy strategy;

    // Use Factory design pattern to implement EASY, MEDIUM, HARD instances of CPU
    public CPU(Strategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public int[] process() {
        return strategy.decideFingerAndSum();
    }

}
