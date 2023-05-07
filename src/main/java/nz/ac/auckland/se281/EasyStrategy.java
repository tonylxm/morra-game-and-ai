// AUTHOR: Tony Lim
// DATE CREATED: 07/05/2023
// DATE LAST EDITED: 07/05/2023

package nz.ac.auckland.se281;

public class EasyStrategy implements Strategy {
    // RANDOM STRATEGY

    private int fingers = Utils.getRandomNumber(1, 5);
    private int sum = Utils.getRandomNumber(fingers + 1, fingers + 5);

    @Override
    public void decideStrategy() {
        MessageCli.PRINT_INFO_HAND.printMessage("Jarvis", String.valueOf(fingers), String.valueOf(sum));
    }

}
