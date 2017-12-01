// Version: 2018010101
import java.io.*;
import java.util.*;

public class MedianTest {
    public static void testAll() {
        clearTerminal();
        testSingle();
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();
        test9();
        test10();
        test11();
        test12();
        test13();
        test14();
    }

    public static void testSingle() {
        int[] input = { 1 };
        int correctAnswer = 1;
        runTest("testSingle", input, correctAnswer);
    }

    public static void test1() {
        int[] input = { 2, 5, 3, 7 };
        int correctAnswer = 5;
        runTest("test1", input, correctAnswer);
    }

    public static void test2() {
        int[] input = { 1, 7, 2, 3, 5 };
        int correctAnswer = 3;
        runTest("test2", input, correctAnswer);
    }

    public static void test3() {
        int[] input = { 2, 4, 7, 9, 3 };
        int correctAnswer = 4;
        runTest("test3", input, correctAnswer);
    }

    public static void test4() {
        int[] input = { 32, 59, 32673, 58586, 14162, 288, 411 };
        int correctAnswer = 411;
        runTest("test4", input, correctAnswer);
    }

    public static void test5() {
        int[] input = { 3, 7, 2, 1, 5 };
        int correctAnswer = 3;
        runTest("test5", input, correctAnswer);
    }

    public static void test6() {
        int[] input = { 3, 2 };
        int correctAnswer = 3;
        runTest("test6", input, correctAnswer);
    }

    public static void test7() {
        int correctAnswer = 4;
        Median m = new Median();
        m.add(1);
        m.add(2);
        m.add(3);
        m.add(4);
        m.add(5);
        m.add(6);
        m.add(7);

        // Try calling median() many times
        for (int i = 1; i <= 10; i++) {
            int output = m.median();
            if (output != correctAnswer) {
                outputFail("test7",
                           "Expected output " + correctAnswer +
                           " in iteration " + i +
                           " but got " + output);
                return;
            }
        }
        outputPass("test7");
    }

    public static void test8() {
        int[] input = { 3, 1, 2 };
        int correctAnswer = 2;
        runTest("test8", input, correctAnswer);
    }

    public static void test9() {
        int[] input = { 3, 1, 2 };
        int[] correctAnswers = { 3, 3, 2 };
        runTestMulti("test9", input, correctAnswers);
    }

    public static void test10() {
        int[] input = { 1, 3, 2 };
        int[] correctAnswers = { 1, 3, 2 };
        runTestMulti("test10", input, correctAnswers);
    }

    public static void test11() {
        int[] input = { 2, 3, 4, 5, 15, 7, 9, 11, 6, 14, 8, 10, 12, 13, 1 };
        int[] correctAnswers = { 2, 3, 3, 4, 4, 5, 5, 7, 6, 7, 7, 8, 8, 9, 8 };
        runTestMulti("test11", input, correctAnswers);
    }

    public static void test12() {
        int[] input = { 1, 5, 7, 3, 9, 4, 6, 8 };
        int[] correctAnswers = { 1, 5, 5, 5, 5, 5, 5, 6 };
        runTestMulti("test12", input, correctAnswers);
    }

    public static void test13() {
        int[] input = { 10, 1, 2, 3, 4 };
        int[] correctAnswers = { 10, 10, 2, 3, 3 };
        runTestMulti("test13", input, correctAnswers);
    }

    public static void test14() {
        int[] input = { 98, 5, 9, 10, 20, 39, 29 };
        int[] correctAnswers = { 98, 98, 9, 10, 10, 20, 20 };
        runTestMulti("test14", input, correctAnswers);
    }

    private static long timeTest(int n) {
        long t1 = System.nanoTime();
        Median m = new Median();
        for (int i = 0; i < n; ++i) {
            m.add((int) (i * 982451653L % 413158511L));
        }
        long t2 = System.nanoTime();
        // For debugging, output the individual times:
        // System.out.println(n + " " + (t2 - t1));
        return t2 - t1;
    }

    private static void runTest(String testName, int[] input, int correctAnswer) {
        try {
            Median m = new Median();
            for (int i : input) m.add(i);

            int output = m.median();

            if (output != correctAnswer)
                outputFail(testName,
                           "Expected output " + correctAnswer +
                           " but got " + output);
            else
                outputPass(testName);
        } catch (Exception e) {
            e.printStackTrace();
            outputFail(testName,
                       "Exception: " + e);
        }
    }

    private static void runTestMulti(String testName, int[] input, int[] correctAnswers) {
        try {
            Median m = new Median();
            for (int i = 0; i < input.length; i++) {
                m.add(input[i]);

                int output = m.median();
                int correctAnswer = correctAnswers[i];

                if (output != correctAnswer) {
                    outputFail(testName,
                               "After inserting " + (i+1) + " element(s): " +
                               "Expected output " + correctAnswer +
                               " but got " + output);
                    return;
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
        for (int t = 0; t < testcases; ++t) {
            int n = sc.nextInt();
            Median median = new Median();
            for (int i = 0; i < n; ++i) {
                median.add(sc.nextInt());
                System.out.println(median.median());
            }
        }
    }
}
