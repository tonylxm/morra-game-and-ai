// AUTHOR: Tony Lim
// DATE CREATED: 12/05/2023
// DATE LAST EDITED: 13/05/2023

package nz.ac.auckland.se281;

import java.util.List;

public interface Ai {
  public int[] play(int roundNum, List<Integer> fingerHistory);
}
