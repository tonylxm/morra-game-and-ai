package nz.ac.auckland.se281;

import java.util.List;

public class EasyAi implements Ai {

    @Override
    public int[] play(int roundNum, List<Integer> fingerHistory) {
        CPU cpu = new CPU(new RandomStrategy());
        return cpu.process();
    }

}
