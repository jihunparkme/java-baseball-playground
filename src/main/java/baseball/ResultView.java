package baseball;

public class ResultView {

    public static void result(PlayResult play) {
        StringBuilder sb = new StringBuilder();
        int ball = play.getBall();
        int strike = play.getStrike();
        if (ball > 0) {
            sb.append(ball).append("볼 ");
        }
        if (strike > 0) {
            sb.append(strike).append("스트라이크");
        }

        System.out.println(sb.toString());
    }
}
