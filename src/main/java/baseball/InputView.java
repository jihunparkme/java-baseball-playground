package baseball;

import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    public static int[] inputNumber() {

        System.out.print("숫자를 입력해 주세요 : ");
        int input = scanner.nextInt();
        int[] result = new int[3];
        for (int i = 2; i >= 0; i++) {
            result[i] = input % 10;
            input /= 10;
        }

        return result;
    }
}
