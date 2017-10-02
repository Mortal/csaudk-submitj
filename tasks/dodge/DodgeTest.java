// Version: 2017100201
import java.io.*;
import java.util.*;
public class DodgeTest {
    public static void testAll() {
        clearTerminal();
        test1();
        test2();
    }

    public static void test1() {
        int[] input = { -1, -7, -10, -20, 10, 18, 5, -11, 8, 1, 8, 11, 18 };
        int[] correctAnswers = { 0, 2, 2, 3, 0, 0, 0, 0 };

        Dodgeball d = new Dodgeball();
        int j = 0;
        for (int i : input) {
            if (i < 0) d.addPlayer(-i);
            else {
                int output = d.throwBall(i);
                int correctAnswer = correctAnswers[j];
                j++;

                if (output != correctAnswer) {
                    outputFail("test1",
                               "Expected output " + correctAnswer +
                               " but got " + output);
                    return;
                }
            }
        }
        outputPass("test1");
    }

    public static void test2() {
        int[] input = { -3, -4, -6, 3, 5, 6, 6 };
        int[] correctAnswers = { 0, 1, 0, 1 };

        Dodgeball d = new Dodgeball();
        int j = 0;
        for (int i : input) {
            if (i < 0) d.addPlayer(-i);
            else {
                int output = d.throwBall(i);
                int correctAnswer = correctAnswers[j];
                j++;

                if (output != correctAnswer) {
                    outputFail("test2",
                               "Expected output " + correctAnswer +
                               " but got " + output);
                    return;
                }
            }
        }
        outputPass("test2");
    }

    private static void clearTerminal() {
        System.out.print('\u000C');
    }

    private static void outputPass(String testName) {
        System.out.println("[Pass " + testName + "]");
    }

    private static void outputFail(String testName, String message) {
        System.out.println("[FAIL " + testName + "] " + message);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();
        for (int t = 0; t < testcases; t++) {
            int n = sc.nextInt();
            Dodgeball d = new Dodgeball();
            for (int i = 0; i < n; i++) {
                String event = sc.next();
                int pos = sc.nextInt();
                if (event.equals("add")) d.addPlayer(pos);
                else if (event.equals("ball"))
                    System.out.println(d.throwBall(pos));
            }
        }
    }
}
