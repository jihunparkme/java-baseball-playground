package baseball;

import java.util.Scanner;

public class InputView {

    public static int inputNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("숫자를 입력해 주세요 : ");

        return scanner.nextInt();
    }
}
