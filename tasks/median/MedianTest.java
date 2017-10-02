// Version: 2017100201
import java.io.*;
import java.util.*;

public class MedianTest {
    public static void testAll() {
        clearTerminal();
        testSingle();
        testTwoSorted();
        testTwoInverted();
        test1();
        test2();
    }

    public static void testSingle() {
        int[] input = { 1 };
        int correctAnswer = 1;

        Median m = new Median();
        for (int i : input) m.add(i);

        int output = m.median();

        if (output != correctAnswer)
            outputFail("testSingle",
                       "Expected output " + correctAnswer +
                       " but got " + output);
        else
            outputPass("testSingle");
    }

    public static void test1() {
        int[] input = { 2, 5, 3, 7 };
        int correctAnswer = 5;

        Median m = new Median();
        for (int i : input) m.add(i);

        int output = m.median();

        if (output != correctAnswer)
            outputFail("test1",
                       "Expected output " + correctAnswer +
                       " but got " + output);
        else
            outputPass("test1");
    }

    public static void test2() {
        int[] input = { 1, 7, 2, 3, 5 };
        int correctAnswer = 3;

        Median m = new Median();
        for (int i : input) m.add(i);

        int output = m.median();

        if (output != correctAnswer)
            outputFail("test2",
                       "Expected output " + correctAnswer +
                       " but got " + output);
        else
            outputPass("test2");
    }

    public static void test3() {
        int[] input = { 4, 4, 7, 9, 4 };
        int correctAnswer = 4;

        Median m = new Median();
        for (int i : input) m.add(i);

        int output = m.median();

        if (output != correctAnswer)
            outputFail("test3",
                       "Expected output " + correctAnswer +
                       " but got " + output);
        else
            outputPass("test3");
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
