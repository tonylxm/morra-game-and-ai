// AUTHOR: Tony Lim
// DATE CREATED: 12/05/2023
// DATE LAST EDITED: 13/05/2023

package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class AiFactory {
  public static Ai createAi(Difficulty difficulty) {
    switch (difficulty) {
      case EASY:
        return new EasyAi();
      case MEDIUM:
        return new MediumAi();
      case HARD:
        return new HardAi();
      case MASTER:
        return new MasterAi();
      default:
        // error (should never happen)
        return null;
    }
  }
}
