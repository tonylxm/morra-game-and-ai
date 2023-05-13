// AUTHOR: Tony Lim
// DATE CREATED: 09/05/2023
// DATE LAST EDITED: 13/05/2023

package nz.ac.auckland.se281;

import java.lang.Math;
import java.util.List;

public class AverageStrategy extends Strategy {
    private List<Integer> fingerHistory;
    private double avg = 0;
    private int i;

    public AverageStrategy(List<Integer> fingerHistory) {
        this.fingerHistory = fingerHistory;
    }

    @Override
    public int[] decideFingerAndSum() {
        fingersAndSum[0] = Utils.getRandomNumber(1, 5);

        for (i = 0; i < fingerHistory.size(); i++) {
            avg += fingerHistory.get(i);
        }
        avg = avg / i;

        fingersAndSum[1] = fingersAndSum[0] + (int) Math.round(avg);
        MessageCli.PRINT_INFO_HAND.printMessage("Jarvis", String.valueOf(fingersAndSum[0]),
                String.valueOf(fingersAndSum[1]));
        return fingersAndSum;
    }

}
