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
public class LongestIncreasingSubsequence {
    public ArrayList<Integer> longestIncreasingSubsequence(ArrayList<Integer> input) {
        ArrayList<Integer> result = new ArrayList<>();

        // Implement your code here to compute
        // the longest increasing subsequence of the input!
        // You can use the following code to insert a dummy "-infinity" element:
        //input.add(0, Integer.MIN_VALUE);
        // Remember to not include -infinity in the result list!

        // After backtracking, you can use Collections.reverse()
        // to reverse the result in O(n) time:
        //Collections.reverse(result);

        return result;
    }

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
        int[] input = { 4, 8, 11, 14 };
        int[] correctAnswer = { 4, 8, 11, 14 };

        try {
            checkLis("test1", input, correctAnswer);
        } catch (Exception e) {
            e.printStackTrace();
            outputFail("test1", "Exception: " + e);
            return;
        }
    }

    public static void test2() {
        int[] input = { 12, 8, 11, 14 };
        int[] correctAnswer = { 8, 11, 14 };

        try {
            checkLis("test2", input, correctAnswer);
        } catch (Exception e) {
            e.printStackTrace();
            outputFail("test2", "Exception: " + e);
            return;
        }
    }

    public static void test3() {
        int[] input = { 1, 8, 11, 7 };
        int[] correctAnswer = { 1, 8, 11 };

        try {
            checkLis("test3", input, correctAnswer);
        } catch (Exception e) {
            e.printStackTrace();
            outputFail("test3", "Exception: " + e);
            return;
        }
    }

    public static void test4() {
        int[] input = { 14, 8, 11, 13, 7 };
        int[] correctAnswer = { 8, 11, 13 };

        try {
            checkLis("test4", input, correctAnswer);
        } catch (Exception e) {
            e.printStackTrace();
            outputFail("test4", "Exception: " + e);
            return;
        }
    }

    public static void test5() {
        int[] input = { 95, 66, 82, 63, 78, 37, 100, 96, 98, 17, 13, 7, 28, 74, 73, 77, 41, 25, 53, 93 };
        int[] correctAnswer = { 13, 28, 41, 53, 93 };

        try {
            checkLis("test5", input, correctAnswer);
        } catch (Exception e) {
            e.printStackTrace();
            outputFail("test5", "Exception: " + e);
            return;
        }
    }

    public static void test6() {
        int[] input = { 2, 3, 1 };
        int[] correctAnswer = { 2, 3 };

        try {
            checkLis("test6", input, correctAnswer);
        } catch (Exception e) {
            e.printStackTrace();
            outputFail("test6", "Exception: " + e);
            return;
        }
    }

    public static void test7() {
        int[] input = { 1, 4, 2, 3 };
        int[] correctAnswer = { 1, 2, 3 };

        try {
            checkLis("test7", input, correctAnswer);
        } catch (Exception e) {
            e.printStackTrace();
            outputFail("test7", "Exception: " + e);
            return;
        }
    }

    public static void test8() {
        int[] input = { 3, 4, 5, 1, 2, 6 };
        int[] correctAnswer = { 3, 4, 5, 6 };

        try {
            checkLis("test8", input, correctAnswer);
        } catch (Exception e) {
            e.printStackTrace();
            outputFail("test8", "Exception: " + e);
            return;
        }
    }

    private static void checkLis(String testName, int[] input, int[] correctAnswer) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i : input) list.add(i);

        ArrayList<Integer> answer = (
            new LongestIncreasingSubsequence().longestIncreasingSubsequence(list));

        if (answer.size() != correctAnswer.length) {
            outputFail(testName,
                       "Expected list of length " + correctAnswer.length + ", got " + answer);
            return;
        }

        int j = 0;
        for (int i : input) {
            if (j < answer.size() && answer.get(j) == i) j++;
        }
        if (j < answer.size()) {
            outputFail(testName, "Not a subsequence of the input: " + answer);
            return;
        }

        for (int i = 1; i < answer.size(); i++)
            if (answer.get(i-1) >= answer.get(i)) {
                outputFail(testName, "Not increasing: " +
                           answer.get(i-1) + " >= " + answer.get(i) + " in " + answer);
                return;
            }

        outputPass(testName);
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
        if (testcases == 0) testAll();
        for (int t = 0; t < testcases; ++t) {
            int n = sc.nextInt();
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < n; ++i) list.add(sc.nextInt());
            LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
            ArrayList<Integer> backtrack = lis.longestIncreasingSubsequence(list);
            System.out.println(backtrack.size());
            for (int i = 0; i < backtrack.size(); i++)
                System.out.println(backtrack.get(i));
        }
    }
}
