// Version: 2017100901
import java.io.*;
import java.util.*;

public class ClosestBall {
    public int computeClosest(ArrayList<Integer> players, ArrayList<Integer> balls) {
        // Implement your code here to return the shortest distance between two numbers!
        return Math.abs(players.get(0) - balls.get(0));
    }

    public static void testAll() {
        clearTerminal();
        testSinglePair();
        testSinglePairInv();
        test1();
        test2();
        test3();
        test4();
    }

    public static void testSinglePair() {
        int[][] input = { { 3 }, { 5 } };
        int correctAnswer = 2;

        ArrayList<Integer> players = new ArrayList<Integer>();
        ArrayList<Integer> balls = new ArrayList<Integer>();
        for (int i : input[0]) players.add(i);
        for (int i : input[1]) balls.add(i);

        int output = new ClosestBall().computeClosest(players, balls);

        if (output != correctAnswer)
            outputFail("testSinglePair",
                       "Expected output " + correctAnswer +
                       " but got " + output);
        else
            outputPass("testSinglePair");
    }

    public static void testSinglePairInv() {
        int[][] input = { { 7 }, { 4 } };
        int correctAnswer = 3;

        ArrayList<Integer> players = new ArrayList<Integer>();
        ArrayList<Integer> balls = new ArrayList<Integer>();
        for (int i : input[0]) players.add(i);
        for (int i : input[1]) balls.add(i);

        int output = new ClosestBall().computeClosest(players, balls);

        if (output != correctAnswer)
            outputFail("testSinglePairInv",
                       "Expected output " + correctAnswer +
                       " but got " + output);
        else
            outputPass("testSinglePairInv");
    }

    public static void test1() {
        int[][] input = {
            { 95, 66, 82, 63, 78, 37, 100, 96, 98, 17, 13, 7, 28, 74, 73, 78, 41, 25, 53, 93 },
            { 275, 938, 8, 77, 649, 803, 500, 823, 519, 711, 422, 227, 235, 655, 373 }
        };
        int correctAnswer = 8 - 7;

        ArrayList<Integer> players = new ArrayList<Integer>();
        ArrayList<Integer> balls = new ArrayList<Integer>();
        for (int i : input[0]) players.add(i);
        for (int i : input[1]) balls.add(i);

        int output = new ClosestBall().computeClosest(players, balls);

        if (output != correctAnswer)
            outputFail("test1",
                       "Expected output " + correctAnswer +
                       " but got " + output);
        else
            outputPass("test1");
    }

    public static void test2() {
        int[][] input = {
            { 750, 927, 16, 324, 667, 196, 693, 551, 561, 100 },
            { 30, 27, 2, 96, 82, 41, 24, 55, 19, 33, 52, 61, 58, 23, 27, 34, 76, 39, 28, 96 }
        };
        int correctAnswer = 19 - 16;

        ArrayList<Integer> players = new ArrayList<Integer>();
        ArrayList<Integer> balls = new ArrayList<Integer>();
        for (int i : input[0]) players.add(i);
        for (int i : input[1]) balls.add(i);

        int output = new ClosestBall().computeClosest(players, balls);

        if (output != correctAnswer)
            outputFail("test2",
                       "Expected output " + correctAnswer +
                       " but got " + output);
        else
            outputPass("test2");
    }

    public static void test3() {
        int[][] input = {
            { 95, 66, 82, 63, 17 },
            { 75, 38, 25, 77 }
        };
        int correctAnswer = 82 - 77;

        ArrayList<Integer> players = new ArrayList<Integer>();
        ArrayList<Integer> balls = new ArrayList<Integer>();
        for (int i : input[0]) players.add(i);
        for (int i : input[1]) balls.add(i);

        int output = new ClosestBall().computeClosest(players, balls);

        if (output != correctAnswer)
            outputFail("test3",
                       "Expected output " + correctAnswer +
                       " but got " + output);
        else
            outputPass("test3");
    }

    public static void test4() {
        int[][] input = {
                { 1, 2 },
                { 2, 3 }
            };
        int correctAnswer = 0;

        ArrayList<Integer> players = new ArrayList<Integer>();
        ArrayList<Integer> balls = new ArrayList<Integer>();
        for (int i : input[0]) players.add(i);
        for (int i : input[1]) balls.add(i);

        int output = new ClosestBall().computeClosest(players, balls);

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
        for (int t = 0; t < testcases; ++t) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            ArrayList<Integer> players = new ArrayList<Integer>();
            ArrayList<Integer> balls = new ArrayList<Integer>();
            for (int i = 0; i < n; ++i) players.add(sc.nextInt());
            for (int i = 0; i < m; ++i) balls.add(sc.nextInt());
            System.out.println(new ClosestBall().computeClosest(players, balls));
        }
    }
}
