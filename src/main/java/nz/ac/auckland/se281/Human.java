// AUTHOR: Tony Lim
// DATE CREATED: 06/05/2023
// DATE LAST EDITED: 06/05/2023

package nz.ac.auckland.se281;

public class Human {
    private String playerName;
    private int fingers;
    private int sum;

    public Human(String playerName) {
        this.playerName = playerName;
    }

    public void play() {
        MessageCli.ASK_INPUT.printMessage();
        String input = Utils.scanner.nextLine();
        String[] split = input.split(" ");

        while (!isInputValid(split)) {
            MessageCli.INVALID_INPUT.printMessage();
            MessageCli.ASK_INPUT.printMessage();
            input = Utils.scanner.nextLine();
            split = input.split(" ");
        }
        MessageCli.PRINT_INFO_HAND.printMessage(playerName, String.valueOf(fingers), String.valueOf(sum));
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

            fingers = Integer.parseInt(split[0]);
            sum = Integer.parseInt(split[1]);

            if ((fingers >= 1 && fingers <= 5) && (sum >= 1 && sum <= 10)) {
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
