// AUTHOR: Tony Lim
// DATE CREATED: 09/05/2023
// DATE LAST EDITED: 09/05/2023

package nz.ac.auckland.se281;

import java.util.Collections;
import java.util.List;

public class TopStrategy extends Strategy {

  public TopStrategy(List<Integer> fingerHistory) {
    super(fingerHistory);
  }

  @Override
  public void calculateSum() {
    int top = fingerHistory.get(0);

    // Calculate most frequent element in fingerHistory:
    // 1. First sort the List
    Collections.sort(fingerHistory);

    // 2. Now linearly tranverse the list finding the most common element
    int maxCount = 1;
    int currentCount = 1;

    for (int i = 1; i < fingerHistory.size(); i++) {
      if (fingerHistory.get(i) == fingerHistory.get(i - 1)) {
        currentCount += 1;
      } else {
        currentCount = 1;
      }

      if (currentCount > maxCount) {
        maxCount = currentCount;
        top = fingerHistory.get(i - 1);
      }
    }
    fingersAndSum[1] = fingersAndSum[0] + top;
  }
}
