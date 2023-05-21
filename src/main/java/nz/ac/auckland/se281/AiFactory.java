// AUTHOR: Tony Lim
// DATE CREATED: 12/05/2023
// DATE LAST EDITED: 21/05/2023

package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Difficulty;

// Fix
public class AiFactory {
  public static Ai createAi(Difficulty difficulty, int roundNum, List<Integer> fingerHistory) {
    switch (difficulty) {
      case EASY:
        return new EasyAi(roundNum);
      case MEDIUM:
        return new MediumAi(roundNum, fingerHistory);
      case HARD:
        return new HardAi(roundNum, fingerHistory);
      case MASTER:
        return new MasterAi(roundNum, fingerHistory);
      default:
        // error (should never happen)
        return null;
    }
  }
}
