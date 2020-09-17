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

        ArrayList<Character> list = new ArrayList<>();
        for (char c : input) list.add(c);

        boolean output = new Dyck().checkParentheses(list);

        if (output != correctAnswer)
            outputFail("test1",
                       "Expected output " + correctAnswer +
                       " but got " + output);
        else
            outputPass("test1");
    }

    public static void test2() {
        char[] input = { '[', '(', '(', '(', ')', ')', '[', ']', ')', ']' };
        boolean correctAnswer = true;

        ArrayList<Character> list = new ArrayList<>();
        for (char c : input) list.add(c);

        boolean output = new Dyck().checkParentheses(list);

        if (output != correctAnswer)
            outputFail("test2",
                       "Expected output " + correctAnswer +
                       " but got " + output);
        else
            outputPass("test2");
    }

    public static void test3() {
        char[] input = { '[', '[', ']', ']', '(', ')' };
        boolean correctAnswer = true;

        ArrayList<Character> list = new ArrayList<>();
        for (char c : input) list.add(c);

        boolean output = new Dyck().checkParentheses(list);

        if (output != correctAnswer)
            outputFail("test3",
                       "Expected output " + correctAnswer +
                       " but got " + output);
        else
            outputPass("test3");
    }

    public static void test4() {
        char[] input = { '[', '[', ']', '[', '[', ']', ']', ']' };
        boolean correctAnswer = true;

        ArrayList<Character> list = new ArrayList<>();
        for (char c : input) list.add(c);

        boolean output = new Dyck().checkParentheses(list);

        if (output != correctAnswer)
            outputFail("test4",
                       "Expected output " + correctAnswer +
                       " but got " + output);
        else
            outputPass("test4");
    }

    public static void test5() {
        char[] input = { '(', ')', '[', '(', '[', ']', ')', ']', '[', ']' };
        boolean correctAnswer = true;

        ArrayList<Character> list = new ArrayList<>();
        for (char c : input) list.add(c);

        boolean output = new Dyck().checkParentheses(list);

        if (output != correctAnswer)
            outputFail("test5",
                       "Expected output " + correctAnswer +
                       " but got " + output);
        else
            outputPass("test5");
    }

    public static void test6() {
        char[] input = { '(', '[', ']', '(' };
        boolean correctAnswer = false;

        ArrayList<Character> list = new ArrayList<>();
        for (char c : input) list.add(c);

        boolean output = new Dyck().checkParentheses(list);

        if (output != correctAnswer)
            outputFail("test6",
                       "Expected output " + correctAnswer +
                       " but got " + output);
        else
            outputPass("test6");
    }

    public static void test7() {
        char[] input = { '(', ']', '[', ')' };
        boolean correctAnswer = false;

        ArrayList<Character> list = new ArrayList<>();
        for (char c : input) list.add(c);

        boolean output = new Dyck().checkParentheses(list);

        if (output != correctAnswer)
            outputFail("test7",
                       "Expected output " + correctAnswer +
                       " but got " + output);
        else
            outputPass("test7");
    }

    public static void test8() {
        char[] input = { '(', '[', ']', ']' };
        boolean correctAnswer = false;

        ArrayList<Character> list = new ArrayList<>();
        for (char c : input) list.add(c);

        boolean output = new Dyck().checkParentheses(list);

        if (output != correctAnswer)
            outputFail("test8",
                       "Expected output " + correctAnswer +
                       " but got " + output);
        else
            outputPass("test8");
    }

    public static void test9() {
        char[] input = { '(', '[', ')', ']' };
        boolean correctAnswer = false;

        ArrayList<Character> list = new ArrayList<>();
        for (char c : input) list.add(c);

        boolean output = new Dyck().checkParentheses(list);

        if (output != correctAnswer)
            outputFail("test9",
                       "Expected output " + correctAnswer +
                       " but got " + output);
        else
            outputPass("test9");
    }

    public static void test10() {
        char[] input = { '[', '(', '[', ']', '(', ']', '[', ']', '[', ']' };
        boolean correctAnswer = false;

        ArrayList<Character> list = new ArrayList<>();
        for (char c : input) list.add(c);

        boolean output = new Dyck().checkParentheses(list);

        if (output != correctAnswer)
            outputFail("test10",
                       "Expected output " + correctAnswer +
                       " but got " + output);
        else
            outputPass("test10");
    }

    public static void test11() {
        char[] input = { '[', '(', '(', '(', ')', ')', '[', ']', ')', ']' };
        boolean correctAnswer = true;

        ArrayList<Character> list = new ArrayList<>();
        for (char c : input) list.add(c);

        boolean output = new Dyck().checkParentheses(list);

        if (output != correctAnswer)
            outputFail("test11",
                       "Expected output " + correctAnswer +
                       " but got " + output);
        else
            outputPass("test11");
    }

    public static void test12() {
        char[] input = { '(', ')', '[', ']', '[', ')', '[', '(', ']', ']' };
        boolean correctAnswer = false;

        ArrayList<Character> list = new ArrayList<>();
        for (char c : input) list.add(c);

        boolean output = new Dyck().checkParentheses(list);

        if (output != correctAnswer)
            outputFail("test12",
                       "Expected output " + correctAnswer +
                       " but got " + output);
        else
            outputPass("test12");
    }

    public static void test13() {
        char[] input = { '(', ')', '[', '[', '[', '(', ')', ']', ']', ')' };
        boolean correctAnswer = false;

        ArrayList<Character> list = new ArrayList<>();
        for (char c : input) list.add(c);

        boolean output = new Dyck().checkParentheses(list);

        if (output != correctAnswer)
            outputFail("test13",
                       "Expected output " + correctAnswer +
                       " but got " + output);
        else
            outputPass("test13");
    }

    public static void test14() {
        char[] input = { ')', '(' };
        boolean correctAnswer = false;

        ArrayList<Character> list = new ArrayList<>();
        for (char c : input) list.add(c);

        try {
            boolean output = new Dyck().checkParentheses(list);

            if (output != correctAnswer)
                outputFail("test14",
                           "Expected output " + correctAnswer +
                           " but got " + output);
            else
                outputPass("test14");
        } catch (Exception e) {
                outputFail("test14",
                           "Exception: " + e);
        }
    }

    public static void test15() {
        char[] input = { '(', '[' };
        boolean correctAnswer = false;

        ArrayList<Character> list = new ArrayList<>();
        for (char c : input) list.add(c);

        boolean output = new Dyck().checkParentheses(list);

        if (output != correctAnswer)
            outputFail("test15",
                       "Expected output " + correctAnswer +
                       " but got " + output);
        else
            outputPass("test15");
    }

    public static void test16() {
        char[] input = { ']', '[' };
        boolean correctAnswer = false;

        ArrayList<Character> list = new ArrayList<>();
        for (char c : input) list.add(c);

        try {
            boolean output = new Dyck().checkParentheses(list);

            if (output != correctAnswer)
                outputFail("test16",
                           "Expected output " + correctAnswer +
                           " but got " + output);
            else
                outputPass("test16");
        } catch (Exception e) {
            outputFail("test16",
                       "Exception: " + e);
        }
    }

    public static void test17() {
        char[] input = { '(', '[', '(', ')', ')', '[', ']', ']' };
        boolean correctAnswer = false;

        ArrayList<Character> list = new ArrayList<>();
        for (char c : input) list.add(c);

        boolean output = new Dyck().checkParentheses(list);

        if (output != correctAnswer)
            outputFail("test17",
                       "Expected output " + correctAnswer +
                       " but got " + output);
        else
            outputPass("test17");
    }

    public static void test18() {
        char[] input = { '[', ')', ')', ']' };
        boolean correctAnswer = false;

        ArrayList<Character> list = new ArrayList<>();
        for (char c : input) list.add(c);

        try {
            boolean output = new Dyck().checkParentheses(list);

            if (output != correctAnswer)
                outputFail("test18",
                           "Expected output " + correctAnswer +
                           " but got " + output);
            else
                outputPass("test18");
        } catch (Exception e) {
            outputFail("test18",
                       "Exception: " + e);
        }
    }

    public static void test19() {
        char[] input = { ')', ')' };
        boolean correctAnswer = false;

        ArrayList<Character> list = new ArrayList<>();
        for (char c : input) list.add(c);

        try {
            boolean output = new Dyck().checkParentheses(list);

            if (output != correctAnswer)
                outputFail("test19",
                           "Expected output " + correctAnswer +
                           " but got " + output);
            else
                outputPass("test19");
        } catch (Exception e) {
            outputFail("test19",
                       "Exception: " + e);
        }
                   
    }

    public static void test20() {
        char[] input = { ']', ']' };
        boolean correctAnswer = false;

        ArrayList<Character> list = new ArrayList<>();
        for (char c : input) list.add(c);

        try {
            boolean output = new Dyck().checkParentheses(list);

            if (output != correctAnswer)
                outputFail("test20",
                           "Expected output " + correctAnswer +
                           " but got " + output);
            else
                outputPass("test20");
        } catch (Exception e) {
            outputFail("test20",
                       "Exception: " + e);
        }
    }

    public static void test21() {
        char[] input = { '(', ')', ']', '[', '(', ')' };
        boolean correctAnswer = false;

        ArrayList<Character> list = new ArrayList<>();
        for (char c : input) list.add(c);

        try {
            boolean output = new Dyck().checkParentheses(list);

            if (output != correctAnswer)
                outputFail("test21",
                           "Expected output " + correctAnswer +
                           " but got " + output);
            else
                outputPass("test21");
        } catch (Exception e) {
            outputFail("test21",
                       "Exception: " + e);
        }
    }

    public static void test22() {
        char[] input = { '(', ')', ')', ')' };
        boolean correctAnswer = false;

        ArrayList<Character> list = new ArrayList<>();
        for (char c : input) list.add(c);

        try {
            boolean output = new Dyck().checkParentheses(list);

            if (output != correctAnswer)
                outputFail("test22",
                           "Expected output " + correctAnswer +
                           " but got " + output);
            else
                outputPass("test22");
        } catch (Exception e) {
            outputFail("test22",
                       "Exception: " + e);
        }
    }

    public static void test23() {
        char[] input = { '[', '(', ')', ']', '(', ')' };
        boolean correctAnswer = true;

        ArrayList<Character> list = new ArrayList<>();
        for (char c : input) list.add(c);

        try {
            boolean output = new Dyck().checkParentheses(list);

            if (output != correctAnswer)
                outputFail("test23",
                           "Expected output " + correctAnswer +
                           " but got " + output);
            else
                outputPass("test23");
        } catch (Exception e) {
            outputFail("test23",
                       "Exception: " + e);
        }
    }

    public static void test24() {
        char[] input = { '(', '(', '(', ')' };
        boolean correctAnswer = false;

        ArrayList<Character> list = new ArrayList<>();
        for (char c : input) list.add(c);

        try {
            boolean output = new Dyck().checkParentheses(list);

            if (output != correctAnswer)
                outputFail("test24",
                           "Expected output " + correctAnswer +
                           " but got " + output);
            else
                outputPass("test24");
        } catch (Exception e) {
            outputFail("test24",
                       "Exception: " + e);
        }
    }

    public static void test25() {
        char[] input = { '(', '[', '[', '[', '[', '(', ')', ']', ']', ')' };
        boolean correctAnswer = false;

        ArrayList<Character> list = new ArrayList<>();
        for (char c : input) list.add(c);

        try {
            boolean output = new Dyck().checkParentheses(list);

            if (output != correctAnswer)
                outputFail("test25",
                           "Expected output " + correctAnswer +
                           " but got " + output);
            else
                outputPass("test25");
        } catch (Exception e) {
            outputFail("test25",
                       "Exception: " + e);
        }
    }

    public static void test26() {
        char[] input = { '(', '(', '[', '(', '[', ']', ')', ')', ']', ')' };
        boolean correctAnswer = false;

        ArrayList<Character> list = new ArrayList<>();
        for (char c : input) list.add(c);

        try {
            boolean output = new Dyck().checkParentheses(list);

            if (output != correctAnswer)
                outputFail("test26",
                           "Expected output " + correctAnswer +
                           " but got " + output);
            else
                outputPass("test26");
        } catch (Exception e) {
            outputFail("test26",
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
