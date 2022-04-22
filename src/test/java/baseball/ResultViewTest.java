package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ResultViewTest {

    private ResultView resultView;

    @BeforeEach
    void init() {
        resultView = new ResultView();
    }

    @Test
    @DisplayName("2볼")
    void ballTest() {
        Integer[] computer = new Integer[]{3,2,1};
        int[] me = new int[]{1,2,3};

        int ball = resultView.checkBall(computer, me);
        assertThat(ball).isEqualTo(2);
    }

    @Test
    @DisplayName("1스트라이크")
    void strikeTest() {
        Integer[] computer = new Integer[]{3,2,1};
        int[] me = new int[]{1,2,3};

        int strike = resultView.checkStrike(computer, me);
        assertThat(strike).isEqualTo(1);
    }

}