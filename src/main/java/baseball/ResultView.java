package baseball;

public class ResultView {

    public boolean printResult(Integer[] computerNumber, int[] input) {

        StringBuilder sb = new StringBuilder();
        int ball = checkBall(computerNumber, input);
        if (ball > 0) {
            sb.append(ball).append("볼 ");
        }
        int strike = checkStrike(computerNumber, input);
        if (strike > 0) {
            sb.append(strike).append("스트라이크");
        }
        if (ball > 0 && strike < 3) {
            System.out.println(sb.toString());
            return false;
        }

        if (strike == 0 && ball == 0) {
            System.out.println("포볼");
            return false;
        }

        return true;
    }

    public int checkBall(Integer[] computer, int[] me) {
        int result = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) continue;
                if (computer[i] == me[j]) result++;
            }
        }

        return result;
    }

    public int checkStrike(Integer[] computer, int[] me) {
        int result = 0;
        if (computer[0] == me[0]) {
            result++;
        }
        if (computer[1] == me[1]) {
            result++;
        }
        if (computer[2] == me[2]) {
            result++;
        }

        return result;
    }
}
