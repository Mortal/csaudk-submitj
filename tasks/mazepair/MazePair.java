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

public class MazePair {
    public int shortestPath(char[][] maze) {
        int height = maze.length;
        int width = maze[0].length;

        // Implement your path-finding algorithm here!
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
        char[][] maze = {
            "oooooo".toCharArray(),
            "or..bo".toCharArray(),
            "or..bo".toCharArray(),
            "or..bo".toCharArray(),
            "oooooo".toCharArray(),
        };
        int correctAnswer = 3;

        try {
            int output = new MazePair().shortestPath(maze);

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
        char[][] maze = {
            "ooooo".toCharArray(),
            "orooo".toCharArray(),
            "ooooo".toCharArray(),
            "ooobo".toCharArray(),
            "ooooo".toCharArray(),
        };
        int correctAnswer = Integer.MAX_VALUE;

        try {
            int output = new MazePair().shortestPath(maze);

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
        char[][] maze = {
            "oooooooo".toCharArray(),
            "o..r...o".toCharArray(),
            "oooooo.o".toCharArray(),
            "o......o".toCharArray(),
            "o.oooooo".toCharArray(),
            "o..b...o".toCharArray(),
            "oooooooo".toCharArray(),
        };
        int correctAnswer = 14;

        try {
            int output = new MazePair().shortestPath(maze);

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
        char[][] maze = {
            "ooooooooo".toCharArray(),
            "o.o...o.o".toCharArray(),
            "oro.o.o.o".toCharArray(),
            "obo.o.o.o".toCharArray(),
            "o.o.o.o.o".toCharArray(),
            "o...o...o".toCharArray(),
            "ooooooooo".toCharArray(),
        };
        int correctAnswer = 1;

        try {
            int output = new MazePair().shortestPath(maze);

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
        char[][] maze = {
            "ooooooooooooo".toCharArray(),
            "ob..o.......o".toCharArray(),
            "o.o.o.ooo.ooo".toCharArray(),
            "o.o...o...o.o".toCharArray(),
            "o.ooooooooo.o".toCharArray(),
            "o.ooo.o...o.o".toCharArray(),
            "o.o...o.o...o".toCharArray(),
            "o.o.o.o.ooo.o".toCharArray(),
            "o...o.....o.o".toCharArray(),
            "ooooo...oooro".toCharArray(),
            "ooooooooooooo".toCharArray(),
        };
        int correctAnswer = 28;

        try {
            int output = new MazePair().shortestPath(maze);

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
        char[][] maze = {
            "ooooooooooooo".toCharArray(),
            "o...........o".toCharArray(),
            "ooooo.ooobo.o".toCharArray(),
            "o.....o.o...o".toCharArray(),
            "oooro.o.ooo.o".toCharArray(),
            "obo.o.r.....o".toCharArray(),
            "o.o.o.o.o.o.o".toCharArray(),
            "o.o.....o...o".toCharArray(),
            "o.o.ooo.o.o.o".toCharArray(),
            "o...o...o.o.o".toCharArray(),
            "ooooooooooooo".toCharArray(),
        };
        int correctAnswer = 10;

        try {
            int output = new MazePair().shortestPath(maze);

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
        char[][] maze = {
            "ooooooooooooo".toCharArray(),
            "or..o.......o".toCharArray(),
            "ooo.o.o.ooo.o".toCharArray(),
            "o...o.o.....o".toCharArray(),
            "o.o.o.ooooo.o".toCharArray(),
            "oro.o.....obo".toCharArray(),
            "o.o.o.ooo.ooo".toCharArray(),
            "o.o...o...o.o".toCharArray(),
            "o.o.o.obo.o.o".toCharArray(),
            "o...o.o.....o".toCharArray(),
            "ooooooooooooo".toCharArray(),
        };
        int correctAnswer = 21;

        try {
            int output = new MazePair().shortestPath(maze);

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
        char[][] maze = {
            "ooooooooooooo".toCharArray(),
            "or..........o".toCharArray(),
            "ooo.oo.oo.ooo".toCharArray(),
            "ooo.oo.oo.ooo".toCharArray(),
            "o...........o".toCharArray(),
            "oo.oo.oo.oo.o".toCharArray(),
            "oo.oo.oo.oo.o".toCharArray(),
            "oo.........bo".toCharArray(),
            "ooooooooooooo".toCharArray(),
        };
        int correctAnswer = 16;

        try {
            int output = new MazePair().shortestPath(maze);

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
        char[][] maze = {
            "oooooooooooooo".toCharArray(),
            "or.o.........o".toCharArray(),
            "o.o..........o".toCharArray(),
            "o..o.........o".toCharArray(),
            "o.oo...o.ooo.o".toCharArray(),
            "o.o...o.o....o".toCharArray(),
            "o.o.ooo...oooo".toCharArray(),
            "o...ooo.....bo".toCharArray(),
            "oooooooooooooo".toCharArray(),
        };
        int correctAnswer = 31;

        try {
            int output = new MazePair().shortestPath(maze);

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
        char[][] maze = {
            "ooooooooooooo".toCharArray(),
            "o.o.o.....obo".toCharArray(),
            "o.o.ooo.ooo.o".toCharArray(),
            "o...r...o...o".toCharArray(),
            "ooooo.o.o.ooo".toCharArray(),
            "o.....o.....o".toCharArray(),
            "o.ooooooo.o.o".toCharArray(),
            "o.ooo.oboro.o".toCharArray(),
            "o...o.ooooo.o".toCharArray(),
            "ooo.o.......o".toCharArray(),
            "o.....b.ooo.o".toCharArray(),
            "ooooooooooooo".toCharArray(),
        };
        int correctAnswer = 8;

        try {
            int output = new MazePair().shortestPath(maze);

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
        char[][] maze = {
            "oooooooo".toCharArray(),
            "obo....o".toCharArray(),
            "obo.o..o".toCharArray(),
            "o.o.orro".toCharArray(),
            "o.o.o..o".toCharArray(),
            "o...o..o".toCharArray(),
            "oooooooo".toCharArray(),
        };
        int correctAnswer = 13;

        try {
            int output = new MazePair().shortestPath(maze);

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
        char[][] maze = {
            "oooooooo".toCharArray(),
            "o..bo.oo".toCharArray(),
            "ooo.oboo".toCharArray(),
            "o.....oo".toCharArray(),
            "ooo.o.oo".toCharArray(),
            "orr....o".toCharArray(),
            "oooooooo".toCharArray(),
        };
        int correctAnswer = 5;

        try {
            int output = new MazePair().shortestPath(maze);

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
        char[][] maze = {
            "ooooooooooooooo".toCharArray(),
            "o.......or..o.o".toCharArray(),
            "o.ooo.o.oro.o.o".toCharArray(),
            "o...o.o...o...o".toCharArray(),
            "o.o.ooooooooo.o".toCharArray(),
            "o.ob.....bo...o".toCharArray(),
            "o.ooooooo.o.o.o".toCharArray(),
            "o.......o...o.o".toCharArray(),
            "o.o.o.o.ooo.o.o".toCharArray(),
            "o.o.o.....o...o".toCharArray(),
            "o.o.o.ooo.o.ooo".toCharArray(),
            "o.o.o.o.......o".toCharArray(),
            "ooooooooooooooo".toCharArray(),
        };
        int correctAnswer = 16;

        try {
            int output = new MazePair().shortestPath(maze);

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
            int n = sc.nextInt();
            int m = sc.nextInt();
            char[][] maze = new char[n][];
            for (int i = 0; i < n; ++i) {
                maze[i] = sc.next().toCharArray();
                if (maze[i].length != m) {
                    System.out.println("Wrong length of line "+(i+1)+": "+maze[i].length+" != "+m);
                    return;
                }
            }
            System.out.println(new MazePair().shortestPath(maze));
        }
    }
}
