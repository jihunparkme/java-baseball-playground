package calculator;

public class Calculator {

    public Calculator() {
    }

    public static int calculate(String value) {

        String[] values = value.split(" ");
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
