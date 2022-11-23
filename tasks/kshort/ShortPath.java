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
        test11();
        test12();
        test13();
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

        try {
            int output = new ShortPath().shortestPath(edges, nodeCount, maxEdges, sourceNode, targetNode);

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

        try {
            int output = new ShortPath().shortestPath(edges, nodeCount, maxEdges, sourceNode, targetNode);

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

        try {
            int output = new ShortPath().shortestPath(edges, nodeCount, maxEdges, sourceNode, targetNode);

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

        try {
            int output = new ShortPath().shortestPath(edges, nodeCount, maxEdges, sourceNode, targetNode);

            if (output != correctAnswer)
                outputFail("test4",
                           "Expected output " + correctAnswer +
                           " but got " + output);
            else
                outputPass("test4");
        } catch (Exception e) {
            e.printStackTrace();
            outputFail("test4", "Exception: " + e);
        }
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

        try {
            int output = new ShortPath().shortestPath(edges, nodeCount, maxEdges, sourceNode, targetNode);

            if (output != correctAnswer)
                outputFail("test5",
                           "Expected output " + correctAnswer +
                           " but got " + output);
            else
                outputPass("test5");
        } catch (Exception e) {
            e.printStackTrace();
            outputFail("test5", "Exception: " + e);
        }
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

        try {
            int output = new ShortPath().shortestPath(edges, nodeCount, maxEdges, sourceNode, targetNode);

            if (output != correctAnswer)
                outputFail("test6",
                           "Expected output " + correctAnswer +
                           " but got " + output);
            else
                outputPass("test6");
        } catch (Exception e) {
            e.printStackTrace();
            outputFail("test6", "Exception: " + e);
        }
    }

    public static void test7() {
        // CLRS4 Fig. 22.4
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

        try {
            int output = new ShortPath().shortestPath(edges, nodeCount, maxEdges, sourceNode, targetNode);

            if (output != correctAnswer)
                outputFail("test7",
                           "Expected output " + correctAnswer +
                           " but got " + output);
            else
                outputPass("test7");
        } catch (Exception e) {
            e.printStackTrace();
            outputFail("test7", "Exception: " + e);
        }
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

        try {
            int output = new ShortPath().shortestPath(edges, nodeCount, maxEdges, sourceNode, targetNode);

            if (output != correctAnswer)
                outputFail("test8",
                    "Expected output " + correctAnswer +
                    " but got " + output);
            else
                outputPass("test8");
        } catch (Exception e) {
            e.printStackTrace();
            outputFail("test8", "Exception: " + e);
        }
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

        try {
            int output = new ShortPath().shortestPath(edges, nodeCount, maxEdges, sourceNode, targetNode);

            if (output != correctAnswer)
                outputFail("test9",
                    "Expected output " + correctAnswer +
                    " but got " + output);
            else
                outputPass("test9");
        } catch (Exception e) {
            e.printStackTrace();
            outputFail("test9", "Exception: " + e);
        }
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

        try {
            int output = new ShortPath().shortestPath(edges, nodeCount, maxEdges, sourceNode, targetNode);

            if (output != correctAnswer)
                outputFail("test10",
                    "Expected output " + correctAnswer +
                    " but got " + output);
            else
                outputPass("test10");
        } catch (Exception e) {
            e.printStackTrace();
            outputFail("test10", "Exception: " + e);
        }
    }

    public static void test11() {
        Edge[] edges = {
            new Edge(0, 1, 1),
            new Edge(1, 2, 1),
            new Edge(0, 2, 3),
            new Edge(2, 3, 1),
            new Edge(3, 4, 1),
        };
        int nodeCount = 5;
        int maxEdges = 3;
        int sourceNode = 0;
        int targetNode = 4;
        int correctAnswer = 3+1+1;

        try {
            int output = new ShortPath().shortestPath(edges, nodeCount, maxEdges, sourceNode, targetNode);

            if (output != correctAnswer)
                outputFail("test11",
                    "Expected output " + correctAnswer +
                    " but got " + output);
            else
                outputPass("test11");
        } catch (Exception e) {
            e.printStackTrace();
            outputFail("test11", "Exception: " + e);
        }
    }

    public static void test12() {
        Edge[] edges = {
            new Edge(0, 1, 5),
            new Edge(0, 2, 10),
        };
        int nodeCount = 3;
        int maxEdges = 1;
        int sourceNode = 0;
        int targetNode = 1;
        int correctAnswer = 5;

        try {
            int output = new ShortPath().shortestPath(edges, nodeCount, maxEdges, sourceNode, targetNode);

            if (output != correctAnswer)
                outputFail("test12",
                           "Expected output " + correctAnswer +
                           " but got " + output);
            else
                outputPass("test12");
        } catch (Exception e) {
            e.printStackTrace();
            outputFail("test12", "Exception: " + e);
        }
    }

    public static void test13() {
        Edge[] edges = {
            new Edge(0, 2, 10),
            new Edge(1, 2, 5),
        };
        int nodeCount = 3;
        int maxEdges = 1;
        int sourceNode = 1;
        int targetNode = 2;
        int correctAnswer = 5;

        try {
            int output = new ShortPath().shortestPath(edges, nodeCount, maxEdges, sourceNode, targetNode);

            if (output != correctAnswer)
                outputFail("test13",
                           "Expected output " + correctAnswer +
                           " but got " + output);
            else
                outputPass("test13");
        } catch (Exception e) {
            e.printStackTrace();
            outputFail("test13", "Exception: " + e);
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
