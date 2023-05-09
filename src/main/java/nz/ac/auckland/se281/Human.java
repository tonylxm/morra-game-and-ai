// AUTHOR: Tony Lim
// DATE CREATED: 06/05/2023
// DATE LAST EDITED: 09/05/2023

package nz.ac.auckland.se281;

public class Human {
    private String playerName;
    private int[] fingersAndSum = new int[2]; // index 0 = fingers, index 1 = sum

    public Human(String playerName) {
        this.playerName = playerName;
    }

    public int[] play() {
        MessageCli.ASK_INPUT.printMessage();
        String input = Utils.scanner.nextLine();
        String[] split = input.split(" ");

        while (!isInputValid(split)) {
            MessageCli.INVALID_INPUT.printMessage();
            MessageCli.ASK_INPUT.printMessage();
            input = Utils.scanner.nextLine();
            split = input.split(" ");
        }
        MessageCli.PRINT_INFO_HAND.printMessage(playerName, String.valueOf(fingersAndSum[0]),
                String.valueOf(fingersAndSum[1]));
        return fingersAndSum;
    }

    public boolean isInputValid(String[] split) {
        // Try process input is a valid integer, otherwise throw error
        try {
            // Check if inputs are integers
            Utils.isInteger(split[0]);
            Utils.isInteger(split[1]);

            // Check there are only two inputs entered
            if (split.length != 2) {
                return false;
            }

            fingersAndSum[0] = Integer.parseInt(split[0]); // fingers
            fingersAndSum[1] = Integer.parseInt(split[1]); // sum

            if ((fingersAndSum[0] >= 1 && fingersAndSum[0] <= 5) && (fingersAndSum[1] >= 1 && fingersAndSum[1] <= 10)) {
                // inputs are valid
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            return false;
        }
    }
}
