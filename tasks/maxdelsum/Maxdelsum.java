// Version: 2017091401
import java.io.*;
import java.util.*;
public class Maxdelsum {
    public int maxdelsum(ArrayList<Integer> input) {
        // Implement your code here to return the maximal subarray sum!
        return 0;
    }

    public static void testAll() {
        clearTerminal();
        testSinglePositive();
        testSingleNegative();
        testAllPositive();
        testAllNegative();
        test1();
        test2();
        test3();
        test4();
    }

    public static void testSinglePositive() {
        int[] input = { 42 };
        int correctAnswer = 42;
        runTest("testSinglePositive", input, correctAnswer);
    }

    public static void testSingleNegative() {
        int[] input = { -123 };
        int correctAnswer = 0;
        runTest("testSingleNegative", input, correctAnswer);
    }

    public static void testAllPositive() {
        int[] input = { 1, 2, 3, 4, 5, 6 };
        int correctAnswer = 21;
        runTest("testAllPositive", input, correctAnswer);
    }

    public static void testAllNegative() {
        int[] input = { -10, -5, -2, -1 };
        int correctAnswer = 0;
        runTest("testAllNegative", input, correctAnswer);
    }

    public static void test1() {
        int[] input = { 31, -41, 59, 26, -53, 58, 97, -93, -23, 84 };
        int correctAnswer = 59 + 26 + -53 + 58 + 97;
        runTest("test1", input, correctAnswer);
    }

    public static void test2() {
        int[] input = { 59, 26, -53, 58, 97, -93, -23, 84 };
        int correctAnswer = 59 + 26 + -53 + 58 + 97;
        runTest("test2", input, correctAnswer);
    }

    public static void test3() {
        int[] input = { 31, -41, 59, 26, -53, 58, 97 };
        int correctAnswer = 59 + 26 + -53 + 58 + 97;
        runTest("test3", input, correctAnswer);
    }

    public static void test4() {
        int[] input = { -1, -2, -1, 10, -1, -2 };
        int correctAnswer = 10;
        runTest("test4", input, correctAnswer);
    }

    private static void runTest(String testName, int[] input, int correctAnswer) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i : input) list.add(i);

        try {
            int output = new Maxdelsum().maxdelsum(list);

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
            System.out.println(new Maxdelsum().maxdelsum(list));
        }
    }
}
