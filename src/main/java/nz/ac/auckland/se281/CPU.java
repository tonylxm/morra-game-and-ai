// AUTHOR: Tony Lim
// DATE CREATED: 07/05/2023
// DATE LAST EDITED: 07/05/2023

package nz.ac.auckland.se281;

public class CPU {
    private Strategy strategy;

    public CPU(Strategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void play() {
        strategy.decideStrategy();
    }

}
