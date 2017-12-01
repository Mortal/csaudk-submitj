// Version: 2017102001
import java.io.*;
import java.util.*;
public class QueueSimulation {
    public int simulate(ArrayList<Integer> input) {
        // Implement your code here to simulate the queue operations!
        return 42;
    }

    public static void testAll() {
        clearTerminal();
        test1();
        test2();
        test3();
        test1024();
        test513();
        test100();
    }

    public static void test1() {
        int[] input = { 1, 2, 3, 4, 5 };
        int correctAnswer = 2;
        runTest("test1", input, correctAnswer);
    }

    public static void test2() {
        int[] input = { 123 };
        int correctAnswer = 123;
        runTest("test2", input, correctAnswer);
    }

    public static void test3() {
        int[] input = { 4, 3, 2, 1 };
        int correctAnswer = 1;
        runTest("test3", input, correctAnswer);
    }

    public static void test1024() {
        int N = 1024;
        int correctAnswer = 1024;
        runTestMany("test1024", N, correctAnswer);
    }

    public static void test513() {
        int N = 513;
        int correctAnswer = 2;
        runTestMany("test513", N, correctAnswer);
    }

    public static void test100() {
        int N = 100;
        int correctAnswer = 72;
        runTestMany("test100", N, correctAnswer);
    }

    private static void runTest(String testName, int[] input, int correctAnswer) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i : input) list.add(i);

        int output;
        try {
            output = new QueueSimulation().simulate(list);
        } catch (Exception e) {
            outputFail(testName,
                       "Exception: " + e);
            return;
        }

        if (output != correctAnswer)
            outputFail(testName,
                       "Expected output " + correctAnswer +
                       " but got " + output);
        else
            outputPass(testName);
    }

    private static void runTestMany(String testName, int N, int correctAnswer) {
        // Run test on input = { 1, 2, 3, ..., N }
        int[] input = new int[N];
        for (int i = 0; i < n; i++) input[i] = i + 1;
        runTest(testName, input, correctAnswer);
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
            System.out.println(new QueueSimulation().simulate(list));
        }
    }
}
