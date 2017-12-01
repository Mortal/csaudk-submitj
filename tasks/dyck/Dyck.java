// Version: 2018010101
import java.io.*;
import java.util.*;
public class Dyck {
    public boolean checkParentheses(ArrayList<Character> input) {
        // Implement your code here to check if the parentheses are properly matched!
        return true;
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
        test9();
        test10();
        test11();
        test12();
        test13();
        test14();
        test15();
        test16();
        test17();
        test18();
        test19();
        test20();
        test21();
        test22();
        test23();
        test24();
        test25();
        test26();
    }

    public static void test1() {
        char[] input = { '(', '(', ')', '(', ')', ')', '[', ']' };
        boolean correctAnswer = true;
        runTest("test1", input, correctAnswer);
    }

    public static void test2() {
        char[] input = { '[', '(', '(', '(', ')', ')', '[', ']', ')', ']' };
        boolean correctAnswer = true;
        runTest("test2", input, correctAnswer);
    }

    public static void test3() {
        char[] input = { '[', '[', ']', ']', '(', ')' };
        boolean correctAnswer = true;
        runTest("test3", input, correctAnswer);
    }

    public static void test4() {
        char[] input = { '[', '[', ']', '[', '[', ']', ']', ']' };
        boolean correctAnswer = true;
        runTest("test4", input, correctAnswer);
    }

    public static void test5() {
        char[] input = { '(', ')', '[', '(', '[', ']', ')', ']', '[', ']' };
        boolean correctAnswer = true;
        runTest("test5", input, correctAnswer);
    }

    public static void test6() {
        char[] input = { '(', '[', ']', '(' };
        boolean correctAnswer = false;
        runTest("test6", input, correctAnswer);
    }

    public static void test7() {
        char[] input = { '(', ']', '[', ')' };
        boolean correctAnswer = false;
        runTest("test7", input, correctAnswer);
    }

    public static void test8() {
        char[] input = { '(', '[', ']', ']' };
        boolean correctAnswer = false;
        runTest("test8", input, correctAnswer);
    }

    public static void test9() {
        char[] input = { '(', '[', ')', ']' };
        boolean correctAnswer = false;
        runTest("test9", input, correctAnswer);
    }

    public static void test10() {
        char[] input = { '[', '(', '[', ']', '(', ']', '[', ']', '[', ']' };
        boolean correctAnswer = false;
        runTest("test10", input, correctAnswer);
    }

    public static void test11() {
        char[] input = { '[', '(', '(', '(', ')', ')', '[', ']', ')', ']' };
        boolean correctAnswer = true;
        runTest("test11", input, correctAnswer);
    }

    public static void test12() {
        char[] input = { '(', ')', '[', ']', '[', ')', '[', '(', ']', ']' };
        boolean correctAnswer = false;
        runTest("test12", input, correctAnswer);
    }

    public static void test13() {
        char[] input = { '(', ')', '[', '[', '[', '(', ')', ']', ']', ')' };
        boolean correctAnswer = false;
        runTest("test13", input, correctAnswer);
    }

    public static void test14() {
        char[] input = { ')', '(' };
        boolean correctAnswer = false;
        runTest("test14", input, correctAnswer);
    }

    public static void test15() {
        char[] input = { '(', '[' };
        boolean correctAnswer = false;
        runTest("test15", input, correctAnswer);
    }

    public static void test16() {
        char[] input = { ']', '[' };
        boolean correctAnswer = false;
        runTest("test16", input, correctAnswer);
    }

    public static void test17() {
        char[] input = { '(', '[', '(', ')', ')', '[', ']', ']' };
        boolean correctAnswer = false;
        runTest("test17", input, correctAnswer);
    }

    public static void test18() {
        char[] input = { '[', ')', ')', ']' };
        boolean correctAnswer = false;
        runTest("test18", input, correctAnswer);
    }

    public static void test19() {
        char[] input = { ')', ')' };
        boolean correctAnswer = false;
        runTest("test19", input, correctAnswer);
    }

    public static void test20() {
        char[] input = { ']', ']' };
        boolean correctAnswer = false;
        runTest("test20", input, correctAnswer);
    }

    public static void test21() {
        char[] input = { '(', ')', ']', '[', '(', ')' };
        boolean correctAnswer = false;
        runTest("test21", input, correctAnswer);
    }

    public static void test22() {
        char[] input = { '(', ')', ')', ')' };
        boolean correctAnswer = false;
        runTest("test22", input, correctAnswer);
    }

    public static void test23() {
        char[] input = { '[', '(', ')', ']', '(', ')' };
        boolean correctAnswer = true;
        runTest("test23", input, correctAnswer);
    }

    public static void test24() {
        char[] input = { '(', '(', '(', ')' };
        boolean correctAnswer = false;
        runTest("test24", input, correctAnswer);
    }

    public static void test25() {
        char[] input = { '(', '[', '[', '[', '[', '(', ')', ']', ']', ')' };
        boolean correctAnswer = false;
        runTest("test25", input, correctAnswer);
    }

    public static void test26() {
        char[] input = { '(', '(', '[', '(', '[', ']', ')', ')', ']', ')' };
        boolean correctAnswer = false;
        runTest("test26", input, correctAnswer);
    }

    private static void runTest(String testName, char[] input, boolean correctAnswer) {
        ArrayList<Character> list = new ArrayList<>();
        for (char c : input) list.add(c);

        try {
            boolean output = new Dyck().checkParentheses(list);

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
            ArrayList<Character> list = new ArrayList<>();
            for (int i = 0; i < n; ++i) list.add(sc.next().charAt(0));
            System.out.println(new Dyck().checkParentheses(list));
        }
    }
}
