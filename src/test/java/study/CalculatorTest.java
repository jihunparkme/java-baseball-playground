package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    private static class Calculator {

        private static int calculate(String[] values) {
            int result = Integer.parseInt(values[0]);

            for (int i = 1; i < values.length - 1; i+=2) {
                String operate = values[i];
                int number = Integer.parseInt(values[i + 1]);

                if ("+".equals(operate)) result = plus(result, number);
                else if ("-".equals(operate)) result = minus(result, number);
                else if ("*".equals(operate)) result = multiplication(result, number);
                else result = division(result, number);
            }

            return result;
        }

        private static int plus(int a, int b) {
            return a + b;
        }

        private static int minus(int a, int b) {
            return a - b;
        }

        private static int multiplication(int a, int b) {
            return a * b;
        }

        private static int division(int a, int b) {
            return a / b;
        }
    }

    @Test
    void plus() {
        String value = "2 + 3";
        String[] values = value.split(" ");
        int calculate = Calculator.calculate(values);

        assertThat(calculate).isEqualTo(5);
    }

    @Test
    void minus() {
        String value = "2 - 3";
        String[] values = value.split(" ");
        int calculate = Calculator.calculate(values);

        assertThat(calculate).isEqualTo(-1);
    }

    @Test
    void multiplication() {
        String value = "6 / 2";
        String[] values = value.split(" ");
        int calculate = Calculator.calculate(values);

        assertThat(calculate).isEqualTo(3);
    }

    @Test
    void division() {
        String value = "2 * 3";
        String[] values = value.split(" ");
        int calculate = Calculator.calculate(values);

        assertThat(calculate).isEqualTo(6);
    }

    @Test
    void stringCalculation() {
        String value = "2 + 3 * 4 / 2";
        String[] values = value.split(" ");
        int calculate = Calculator.calculate(values);

        assertThat(calculate).isEqualTo(10);
    }
}
