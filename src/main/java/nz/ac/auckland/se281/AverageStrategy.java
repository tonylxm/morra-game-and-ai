// AUTHOR: Tony Lim
// DATE CREATED: 09/05/2023
// DATE LAST EDITED: 09/05/2023

package nz.ac.auckland.se281;

import java.lang.Math;

public class AverageStrategy implements Strategy {

    private int[] fingersAndSum = new int[2];

    @Override
    public int[] decideStrategy() {
        fingersAndSum[0] = Utils.getRandomNumber(1, 5);

        return fingersAndSum;
    }

}
