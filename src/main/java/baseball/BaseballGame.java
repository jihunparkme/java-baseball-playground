package baseball;

import java.util.HashSet;
import java.util.Set;

public class BaseballGame {

    private static InputView inputView = new InputView();
    private static ResultView resultView = new ResultView();

    public static void start() {
        while (true) {
            Integer[] computerNumber = getComputerNumber();
            if (inGame(computerNumber) == 2) {
                System.out.println("종료되었습니다.");
                break;
            }
        }
    }

    private static int inGame(Integer[] computerNumber) {
        while (true) {
            int[] input = inputView.inputNumber();
            boolean success = resultView.printResult(computerNumber, input);
            if (success) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                return InputView.inputOper();
            }
        }
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
