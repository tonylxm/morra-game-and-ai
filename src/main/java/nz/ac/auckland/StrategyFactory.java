package nz.ac.auckland;

import nz.ac.auckland.se281.RandomStrategy;
import nz.ac.auckland.se281.Strategy;
import nz.ac.auckland.se281.Main.Difficulty;

public class StrategyFactory {
    public static Strategy chooseStrategy(Difficulty level) {
        switch (level) {
            case EASY:
                return new RandomStrategy();
            case MEDIUM:
            case HARD:
            case MASTER:
            default:
                // error
                return null;

        }
    }
}
