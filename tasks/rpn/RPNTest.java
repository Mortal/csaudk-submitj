// Version: 2017101901
import java.io.*;
import java.util.*;
public class RPNTest {
    public static void testAll() {
        clearTerminal();
        testPushGet1();
        testPushGet2();
        testPushGet3();
        testPushGet4();
        testPlus1();
        testTimes1();
        testMinus1();
        testMinus2();
        test1();
        test2();
        test3();
        test4();
    }

    public static void testPushGet1() {
        ReversePolishCalculator rpn = new ReversePolishCalculator();
        int correctAnswer = 123;
        rpn.push(123);
        int output = rpn.read();

        if (output != correctAnswer)
            outputFail("testPushGet1",
                       "Expected output " + correctAnswer +
                       " but got " + output);
        else
            outputPass("testPushGet1");
    }

    public static void testPushGet2() {
        ReversePolishCalculator rpn = new ReversePolishCalculator();
        int correctAnswer = 256;
        rpn.push(123);
        rpn.push(256);
        int output = rpn.read();

        if (output != correctAnswer)
            outputFail("testPushGet2",
                       "Expected output " + correctAnswer +
                       " but got " + output);
        else
            outputPass("testPushGet2");
    }

    public static void testPushGet3() {
        ReversePolishCalculator rpn = new ReversePolishCalculator();
        int correctAnswer = 256 + 256;
        rpn.push(123);
        rpn.push(256);
        int output = rpn.read() + rpn.read();

        if (output != correctAnswer)
            outputFail("testPushGet3",
                       "Expected output " + correctAnswer +
                       " but got " + output);
        else
            outputPass("testPushGet3");
    }

    public static void testPushGet4() {
        ReversePolishCalculator rpn = new ReversePolishCalculator();
        int correctAnswer = 256 + 123;
        rpn.push(123);
        int output = rpn.read();
        rpn.push(256);
        output += rpn.read();

        if (output != correctAnswer)
            outputFail("testPushGet4",
                       "Expected output " + correctAnswer +
                       " but got " + output);
        else
            outputPass("testPushGet4");
    }

    public static void testPlus1() {
        ReversePolishCalculator rpn = new ReversePolishCalculator();
        int correctAnswer = 123 + 256;
        rpn.push(123);
        rpn.push(256);
        rpn.plus();
        int output = rpn.read();

        if (output != correctAnswer)
            outputFail("testPlus1",
                       "Expected output " + correctAnswer +
                       " but got " + output);
        else
            outputPass("testPlus1");
    }

    public static void testTimes1() {
        ReversePolishCalculator rpn = new ReversePolishCalculator();
        int correctAnswer = 123 * 256;
        rpn.push(123);
        rpn.push(256);
        rpn.times();
        int output = rpn.read();

        if (output != correctAnswer)
            outputFail("testTimes1",
                       "Expected output " + correctAnswer +
                       " but got " + output);
        else
            outputPass("testTimes1");
    }

    public static void testMinus1() {
        ReversePolishCalculator rpn = new ReversePolishCalculator();
        int correctAnswer = 123 - 256;
        rpn.push(123);
        rpn.push(256);
        rpn.minus();
        int output = rpn.read();

        if (output != correctAnswer)
            outputFail("testMinus1",
                       "Expected output " + correctAnswer +
                       " but got " + output);
        else
            outputPass("testMinus1");
    }

    public static void testMinus2() {
        ReversePolishCalculator rpn = new ReversePolishCalculator();
        int correctAnswer = 256 - 123;
        rpn.push(256);
        rpn.push(123);
        rpn.minus();
        int output = rpn.read();

        if (output != correctAnswer)
            outputFail("testMinus2",
                       "Expected output " + correctAnswer +
                       " but got " + output);
        else
            outputPass("testMinus2");
    }

    private static final int PLUS = -1;
    private static final int MINUS = -2;
    private static final int TIMES = -3;

    public static void test1() {
        int[] input = { 20, 2, 3, 5, PLUS, TIMES, MINUS, 2, 4, MINUS, TIMES };
        int correctAnswer = (20 - (2 * (3 + 5))) * (2 - 4);

        ReversePolishCalculator rpn = new ReversePolishCalculator();
        for (int i : input)
            if (i == PLUS) rpn.plus();
            else if (i == MINUS) rpn.minus();
            else if (i == TIMES) rpn.times();
            else rpn.push(i);
        int output = rpn.read();

        if (output != correctAnswer)
            outputFail("test1",
                       "Expected output " + correctAnswer +
                       " but got " + output);
        else
            outputPass("test1");
    }

    public static void test2() {
        int[] input = { 1, 2, MINUS, 3, TIMES };
        int correctAnswer = (1 - 2) * 3;

        ReversePolishCalculator rpn = new ReversePolishCalculator();
        for (int i : input)
            if (i == PLUS) rpn.plus();
            else if (i == MINUS) rpn.minus();
            else if (i == TIMES) rpn.times();
            else rpn.push(i);
        int output = rpn.read();

        if (output != correctAnswer)
            outputFail("test2",
                       "Expected output " + correctAnswer +
                       " but got " + output);
        else
            outputPass("test2");
    }

    public static void test3() {
        int[] input = { 1, 2, 3, MINUS, TIMES };
        int correctAnswer = 1 * (2 - 3);

        ReversePolishCalculator rpn = new ReversePolishCalculator();
        for (int i : input)
            if (i == PLUS) rpn.plus();
            else if (i == MINUS) rpn.minus();
            else if (i == TIMES) rpn.times();
            else rpn.push(i);
        int output = rpn.read();

        if (output != correctAnswer)
            outputFail("test3",
                       "Expected output " + correctAnswer +
                       " but got " + output);
        else
            outputPass("test3");
    }

    public static void test4() {
        int[] input = { 2, 1, 1, 2, PLUS, PLUS, TIMES };
        int correctAnswer = 2 * (1 + (1 + 2));

        ReversePolishCalculator rpn = new ReversePolishCalculator();
        for (int i : input)
            if (i == PLUS) rpn.plus();
            else if (i == MINUS) rpn.minus();
            else if (i == TIMES) rpn.times();
            else rpn.push(i);
        int output = rpn.read();

        if (output != correctAnswer)
            outputFail("test4",
                       "Expected output " + correctAnswer +
                       " but got " + output);
        else
            outputPass("test4");
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
            ReversePolishCalculator rpn = new ReversePolishCalculator();
            for (int i = 0; i < n; i++) {
                String op = sc.next();
                if (op.equals("push")) {
                    rpn.push(sc.nextInt());
                    continue;
                }
                if (op.equals("plus")) rpn.plus();
                else if (op.equals("minus")) rpn.minus();
                else if (op.equals("times")) rpn.times();
            }
            System.out.println(rpn.read());
        }
    }
}
