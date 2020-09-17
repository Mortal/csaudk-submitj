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

public class Travel {
    public int shortestPath(int[] nodeWeights, Edge[][] edgeLists) {
        int n = nodeWeights.length;
        int[] bestCost = new int[n];
        bestCost[0] = nodeWeights[0];
        for (int i = 1; i < n; i++) bestCost[i] = Integer.MAX_VALUE;

        // Implement your shortest path algorithm here!
        return bestCost[n-1];
    }

    public static void testAll() {
        clearTerminal();
        test1();
        test2();
        test3();
    }

    public static void test1() {
        int[] nodeWeights = {
            -1, -1, -1, -5, -4, -1
        };
        Edge[][] edgeLists = {
            { new Edge(0, 1, 5), new Edge(0, 2, 3) },
            { new Edge(1, 2, 2), new Edge(1, 3, 2) },
            { new Edge(2, 3, 7), new Edge(2, 4, 4), new Edge(2, 5, 2) },
            { new Edge(3, 4, 1), new Edge(3, 5, 1) },
            { new Edge(4, 5, 2) },
            {},
        };

        int correctAnswer = -2;

        try {
            int output = new Travel().shortestPath(nodeWeights, edgeLists);

            if (output != correctAnswer)
                outputFail("test1",
                           "Expected output " + correctAnswer +
                           " but got " + output);
            else
                outputPass("test1");
        } catch (Exception e) {
            e.printStackTrace();
            outputFail("test1", "Exception: " + e);
        }
    }

    public static void test2() {
        int[] nodeWeights = {
            -1, -10
        };
        Edge[][] edgeLists = {
            { new Edge(0, 1, 100) },
            {},
        };

        int correctAnswer = -1 + 100 - 10;

        try {
            int output = new Travel().shortestPath(nodeWeights, edgeLists);

            if (output != correctAnswer)
                outputFail("test2",
                           "Expected output " + correctAnswer +
                           " but got " + output);
            else
                outputPass("test2");
        } catch (Exception e) {
            e.printStackTrace();
            outputFail("test2", "Exception: " + e);
        }
    }

    public static void test3() {
        int[] nodeWeights = {
            -10, -51, -60
        };
        Edge[][] edgeLists = {
            { new Edge(0, 1, 40), new Edge(0, 2, 30) },
            { new Edge(1, 2, 20) },
            {},
        };

        int correctAnswer = -10 + 40 - 51 + 20 - 60;

        try {
            int output = new Travel().shortestPath(nodeWeights, edgeLists);

            if (output != correctAnswer)
                outputFail("test3",
                           "Expected output " + correctAnswer +
                           " but got " + output);
            else
                outputPass("test3");
        } catch (Exception e) {
            e.printStackTrace();
            outputFail("test3", "Exception: " + e);
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
        if (testcases == 0) testAll();
        for (int t = 0; t < testcases; ++t) {
            int n = sc.nextInt();
            int[] nodeWeights = new int[n];
            Edge[][] edgeLists = new Edge[n][];
            for (int i = 0; i < n; i++) {
                nodeWeights[i] = sc.nextInt();
                int m = sc.nextInt();
                edgeLists[i] = new Edge[m];
                for (int j = 0; j < m; j++)
                    edgeLists[i][j] = new Edge(i, sc.nextInt(), sc.nextInt());
            }
            System.out.println(new Travel().shortestPath(nodeWeights, edgeLists));
        }
    }
}
