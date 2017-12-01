// Version: 2017091401
import java.io.*;
import java.util.*;

public class Inversions {
    public int countInversions(ArrayList<Integer> input) {
        // Implement your code here to return the number of inversions in input!
        return 42;
    }

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
        int correctAnswer = 0;
        runTest("testSingle", input, correctAnswer);
    }

    public static void testTwoSorted() {
        int[] input = { 1, 2 };
        int correctAnswer = 0;
        runTest("testTwoSorted", input, correctAnswer);
    }

    public static void testTwoInverted() {
        int[] input = { 2, 1 };
        int correctAnswer = 1;
        runTest("testTwoInverted", input, correctAnswer);
    }

    public static void test1() {
        int[] input = { 2, 14, 6, 4, 15, 3, 7, 9, 11, 1, 10, 5, 8, 13, 12 };
        int correctAnswer = 42;
        runTest("test1", input, correctAnswer);
    }

    public static void test2() {
        int[] input = { 2, 11, 5, 9, 13, 4, 3, 15, 6, 8, 12, 10, 7, 1, 14 };
        int correctAnswer = 46;
        runTest("test2", input, correctAnswer);
    }

    private static void runTest(String testName, int[] input, int correctAnswer) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i : input) list.add(i);

        try {
            int output = new Inversions().countInversions(list);

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
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < n; ++i) list.add(sc.nextInt());
            System.out.println(new Inversions().countInversions(list));
        }
    }
}
