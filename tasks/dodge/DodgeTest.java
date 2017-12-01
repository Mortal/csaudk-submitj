// Version: 2017102301
import java.io.*;
import java.util.*;
public class DodgeTest {
    public static void testAll() {
        clearTerminal();
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();
    }

    public static void test1() {
        int[] input = { -1, -7, -10, -20, 10, 18, 5, -11, 8, 1, 8, 11, 18 };
        int[] correctAnswers = { 0, 2, 2, 3, 0, 0, 0, 0 };
        runTest("test1", input, correctAnswers);
    }

    public static void test2() {
        int[] input = { -3, -4, -6, 3, 5, 6, 6 };
        int[] correctAnswers = { 0, 1, 0, 1 };
        runTest("test2", input, correctAnswers);
    }

    public static void test3() {
        int[] input = { -2, 3, -1, 6, -5, 2 };
        int[] correctAnswers = { 1, 3, 1 };
        runTest("test3", input, correctAnswers);
    }

    public static void test4() {
        int[] input = { -4, 3, -1, 2, 3 };
        int[] correctAnswers = { 1, 1, 0 };
        runTest("test4", input, correctAnswers);
    }

    public static void test5() {
        int[] input = { -50000000, 1};
        int[] correctAnswers = { 49999999 };
        runTest("test5", input, correctAnswers);
    }

    public static void test6() {
        int[] input = { -3000000, 5000000, -2000001, 1 };
        int[] correctAnswers = { 2000000, 2000000 };
        runTest("test6", input, correctAnswers);
    }

    public static void test7() {
        int[] input = { -4, -3, -2, 1, 1, 1, 1, 1, 1 };
        int[] correctAnswers = { 1, 0, 2, 0, 3, 0 };
        runTest("test7", input, correctAnswers);
    }

    public static void test8() {
        int[] input = { -5, -4, -3, 1, 1, 1, 1, 1, 1 };
        int[] correctAnswers = { 2, 0, 3, 0, 4, 0 };
        runTest("test8", input, correctAnswers);
    }

    public static void runTest(String testName, int[] input, int[] correctAnswers) {
        try {
            Dodgeball d = new Dodgeball();
            int j = 0;
            for (int i : input) {
                if (i < 0) d.addPlayer(-i);
                else {
                    int output = d.throwBall(i);
                    int correctAnswer = correctAnswers[j];
                    j++;

                    if (output != correctAnswer) {
                        outputFail(testName,
                                   "Expected output " + correctAnswer +
                                   " but got " + output);
                        return;
                    }
                }
            }
            outputPass(testName);
        } catch (Exception e) {
            e.printStackTrace();
            outputFail(testName,
                       "Exception: " + e);
        }
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
