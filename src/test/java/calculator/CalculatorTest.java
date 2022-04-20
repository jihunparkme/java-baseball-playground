package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void init() {
        calculator = new Calculator();
    }

    @Test
    void plus() {
        String value = "2 + 3";
        int calculate = calculator.calculate(value);

        assertThat(calculate).isEqualTo(5);
    }

    @Test
    void minus() {
        String value = "2 - 3";
        int calculate = calculator.calculate(value);

        assertThat(calculate).isEqualTo(-1);
    }

    @Test
    void multiplication() {
        String value = "6 / 2";
        int calculate = calculator.calculate(value);

        assertThat(calculate).isEqualTo(3);
    }

    @Test
    void division() {
        String value = "2 * 3";
        int calculate = calculator.calculate(value);

        assertThat(calculate).isEqualTo(6);
    }

    @Test
    void stringCalculation() {
        String value = "2 + 3 * 4 / 2";
        int calculate = calculator.calculate(value);

        assertThat(calculate).isEqualTo(10);
    }
}