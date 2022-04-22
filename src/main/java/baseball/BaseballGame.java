package baseball;

import java.util.HashSet;
import java.util.Set;

public class BaseballGame {

    public static void start() {

        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        Integer[] computerNumber = getComputerNumber();
        int[] ints = inputView.inputNumber();
    }

    public static Integer[] getComputerNumber() {
        Set<Integer> numbers = new HashSet<>();

        while (numbers.size() < 3) {
            double num = Math.random() * 9 + 1;
            numbers.add((int) num);
        }

        return numbers.toArray(new Integer[3]);
    }
}
