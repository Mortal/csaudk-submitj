// Version: 20200917
// Handin done by:
//   <id 1> <name 1>
//   <id 2> <name 2>
//   <id 3> <name 3>
// Contributions:
//   <name 1> <contribution>
//   <name 2> <contribution>
//   <name 3> <contribution>

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
        // testQuadraticTime();  // This is confusing, so don't run it by default
    }

    public static void testSingle() {
        int[] input = { 1 };
        int correctAnswer = 0;

        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i : input) list.add(i);

        int output = new Inversions().countInversions(list);

        if (output != correctAnswer)
            outputFail("testSingle",
                       "Expected output " + correctAnswer +
                       " but got " + output);
        else
            outputPass("testSingle");
    }

    public static void testTwoSorted() {
        int[] input = { 1, 2 };
        int correctAnswer = 0;

        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i : input) list.add(i);

        int output = new Inversions().countInversions(list);

        if (output != correctAnswer)
            outputFail("testTwoSorted",
                       "Expected output " + correctAnswer +
                       " but got " + output);
        else
            outputPass("testTwoSorted");
    }

    public static void testTwoInverted() {
        int[] input = { 2, 1 };
        int correctAnswer = 1;

        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i : input) list.add(i);

        int output = new Inversions().countInversions(list);

        if (output != correctAnswer)
            outputFail("testTwoInverted",
                       "Expected output " + correctAnswer +
                       " but got " + output);
        else
            outputPass("testTwoInverted");
    }

    public static void test1() {
        int[] input = { 2, 14, 6, 4, 15, 3, 7, 9, 11, 1, 10, 5, 8, 13, 12 };
        int correctAnswer = 42;

        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i : input) list.add(i);

        int output = new Inversions().countInversions(list);

        if (output != correctAnswer)
            outputFail("test1",
                       "Expected output " + correctAnswer +
                       " but got " + output);
        else
            outputPass("test1");
    }

    public static void test2() {
        int[] input = { 2, 11, 5, 9, 13, 4, 3, 15, 6, 8, 12, 10, 7, 1, 14 };
        int correctAnswer = 46;

        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i : input) list.add(i);

        int output = new Inversions().countInversions(list);

        if (output != correctAnswer)
            outputFail("test2",
                       "Expected output " + correctAnswer +
                       " but got " + output);
        else
            outputPass("test2");
    }

    public static void testQuadraticTime() {
        int n1 = 1000;
        int n2 = 3000;
        long t11 = timeTest(n1);
        long t12 = timeTest(n1);
        long t13 = timeTest(n1);
        long t14 = timeTest(n1);
        long t15 = timeTest(n1);
        long t1 = Math.min(Math.min(Math.min(Math.min(t11, t12), t13), t14), t15);
        System.out.println("");
        System.out.println("Testing time complexity.");
        System.out.println("Elapsed time on input size n1 = " + n1 + ": t1 = " + t1);
        long t21 = timeTest(n2);
        long t22 = timeTest(n2);
        long t23 = timeTest(n2);
        long t2 = Math.min(Math.min(t21, t22), t23);
        System.out.println("Elapsed time on input size n2 = " + n2 + ": t2 = " + t2);
        double slowdown = ((double) t2) / t1;
        double linearSlowdown = ((double) n2) / n1;
        System.out.println("Expected slowdown (for linear time): n2 / n1 = " + linearSlowdown);
        System.out.println("Measured slowdown: t2 / t1 = " + slowdown);
        if (slowdown > Math.pow(linearSlowdown, 1.2))
            System.out.println("That's not linear time!");
        else
            System.out.println("OK.");
    }

    private static long timeTest(int n) {
        ArrayList<Integer> list = new ArrayList<Integer>(n);
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        Random rnd = new Random(42);
        Collections.shuffle(list, rnd);
        
        long t1 = System.nanoTime();
        new Inversions().countInversions(list);
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
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < n; ++i) list.add(sc.nextInt());
            System.out.println(new Inversions().countInversions(list));
        }
    }
}
