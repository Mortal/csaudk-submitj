// Version: 2018010101

import java.io.*;
import java.util.*;

public class ShortPath {
    public int shortestPath(Edge[] edges, int nodeCount, int maxEdges, int sourceNode, int targetNode) {
        return 0;
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
    }

    public static void test1() {
        Edge[] edges = {
            new Edge(0, 1, 1),
            new Edge(1, 2, 1),
            new Edge(2, 3, 1),
            new Edge(3, 4, 1),
            new Edge(2, 4, 10),
            new Edge(1, 4, 100),
            new Edge(0, 4, 1000),
        };
        int nodeCount = 5;
        int maxEdges = 3;
        int sourceNode = 0;
        int targetNode = 4;
        int correctAnswer = 12;
        runTest("test1", edges, nodeCount, maxEdges, sourceNode, targetNode, correctAnswer);
    }

    public static void test2() {
        Edge[] edges = {
            new Edge(0, 1, 1),
            new Edge(1, 2, 1),
            new Edge(2, 3, 1),
            new Edge(3, 4, 1),
            new Edge(3, 1, -5),
        };
        int nodeCount = 5;
        int maxEdges = 4;
        int sourceNode = 0;
        int targetNode = 4;
        int correctAnswer = 4;
        runTest("test2", edges, nodeCount, maxEdges, sourceNode, targetNode, correctAnswer);
    }

    public static void test3() {
        Edge[] edges = {
            new Edge(0, 1, 1),
            new Edge(1, 2, 1),
            new Edge(2, 3, 1),
            new Edge(3, 4, 1),
            new Edge(3, 1, -5),
        };
        int nodeCount = 5;
        int maxEdges = 8;
        int sourceNode = 0;
        int targetNode = 4;
        int correctAnswer = 1;
        runTest("test3", edges, nodeCount, maxEdges, sourceNode, targetNode, correctAnswer);
    }

    public static void test4() {
        Edge[] edges = {
            new Edge(0, 1, 1),
            new Edge(1, 2, 1),
            new Edge(2, 3, 1),
            new Edge(3, 4, 1),
            new Edge(3, 1, -5),
        };
        int nodeCount = 5;
        int maxEdges = 19;
        int sourceNode = 0;
        int targetNode = 4;
        int correctAnswer = -11;
        runTest("test4", edges, nodeCount, maxEdges, sourceNode, targetNode, correctAnswer);
    }

    public static void test5() {
        Edge[] edges = {
            new Edge(0, 1, 0),
            new Edge(1, 0, -1),
        };
        int nodeCount = 2;
        int maxEdges = 5;
        int sourceNode = 0;
        int targetNode = 1;
        int correctAnswer = -2;
        runTest("test5", edges, nodeCount, maxEdges, sourceNode, targetNode, correctAnswer);
    }

    public static void test6() {
        Edge[] edges = {
            new Edge(0, 1, -1),
            new Edge(1, 0, 0),
        };
        int nodeCount = 2;
        int maxEdges = 5;
        int sourceNode = 0;
        int targetNode = 1;
        int correctAnswer = -3;
        runTest("test6", edges, nodeCount, maxEdges, sourceNode, targetNode, correctAnswer);
    }

    public static void test7() {
        // CLRS Fig. 24.4
        Edge[] edges = {
            new Edge(0, 4, 6),
            new Edge(0, 2, 7),
            new Edge(1, 4, -2),
            new Edge(2, 1, -3),
            new Edge(2, 3, 9),
            new Edge(3, 0, 2),
            new Edge(3, 1, 7),
            new Edge(4, 1, 5),
            new Edge(4, 2, 8),
            new Edge(4, 3, -4),
        };
        int nodeCount = 5;
        int maxEdges = 5;
        int sourceNode = 0;
        int targetNode = 4;
        int correctAnswer = 2;
        runTest("test7", edges, nodeCount, maxEdges, sourceNode, targetNode, correctAnswer);
    }

    public static void test8() {
        Edge[] edges = {
            new Edge(2, 0, -3),
            new Edge(1, 2, 3),
            new Edge(0, 2, -4),
            new Edge(1, 0, -2),
            new Edge(2, 1, 4),
            new Edge(0, 1, -2),
        };
        int nodeCount = 3;
        int maxEdges = 3;
        int sourceNode = 0;
        int targetNode = 2;
        int correctAnswer = -4-3-4;
        runTest("test8", edges, nodeCount, maxEdges, sourceNode, targetNode, correctAnswer);
    }

    public static void test9() {
        Edge[] edges = {
            new Edge(0, 1, -1),
            new Edge(1, 0, -1),
            new Edge(0, 2, 1),
        };
        int nodeCount = 3;
        int maxEdges = 2;
        int sourceNode = 0;
        int targetNode = 2;
        int correctAnswer = 1;
        runTest("test9", edges, nodeCount, maxEdges, sourceNode, targetNode, correctAnswer);
    }

    public static void test10() {
        Edge[] edges = {
            new Edge(0, 1, 1),
            new Edge(1, 2, 1),
            new Edge(0, 2, 3),
            new Edge(2, 3, 1),
        };
        int nodeCount = 4;
        int maxEdges = 2;
        int sourceNode = 0;
        int targetNode = 3;
        int correctAnswer = 3+1;
        runTest("test10", edges, nodeCount, maxEdges, sourceNode, targetNode, correctAnswer);
    }

    private static void runTest(String testName, Edge[] edges, int nodeCount, int maxEdges, int sourceNode, int targetNode, int correctAnswer) {
        try {
            int output = new ShortPath().shortestPath(edges, nodeCount, maxEdges, sourceNode, targetNode);

            if (output != correctAnswer)
                outputFail(testName,
                           "Expected output " + correctAnswer +
                           " but got " + output);
            else
                outputPass(testName);
        } catch (Exception e) {
            e.printStackTrace();
            outputFail(testName, "Exception: " + e);
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
            int nodeCount = sc.nextInt();
            int edgeCount = sc.nextInt();
            int maxEdges = sc.nextInt();
            int sourceNode = sc.nextInt();
            int targetNode = sc.nextInt();
            Edge[] edges = new Edge[edgeCount];
            for (int i = 0; i < edgeCount; ++i)
                edges[i] = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
            System.out.println(new ShortPath().shortestPath(edges, nodeCount, maxEdges, sourceNode, targetNode));
        }
    }
}
