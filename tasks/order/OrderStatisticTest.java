// Version: 2017103104
import java.util.*;
import java.io.*;

public class OrderStatisticTest {
    public static void testAll() {
        clearTerminal();
        testAugment1();
        testSelect1();
        testSelect2();
        testSelect3();
        testSelect4();
        testSelect5();
        testSelect6();
        testSelect7();
        testSelect8();
        testSelect9();
        testRank1();
        testRank2();
        testRank3();
        testRank4();
        testRank5();
        testRank6();
        testRank7();
        testRank8();
    }

    public static void testAugment1() {
        Augment a;
        try {
            a = Augment.combine(
                Augment.leaf(),
                Augment.leaf(),
                42);
        } catch (Exception e) {
            outputFail("testAugment1", "Exception: " + e);
            e.printStackTrace();
            return;
        }

        if (a.size != 1)
            outputFail("testAugment1",
                       "Expected augment size 1, got " + a.size);
        else
            outputPass("testAugment1");
    }

    public static void testSelect1() {
        int[] values = {10, 20, 30};
        int rank = 2;
        RedBlackTree tree = new RedBlackTree();
        Node res;
        try {
            tree.insert(values[0]);
            tree.insert(values[1]);
            tree.insert(values[2]);
            res = tree.select(rank);
        } catch (Exception e) {
            outputFail("testSelect1", "Exception: " + e);
            e.printStackTrace();
            return;
        }

        if (res.key != values[rank])
            outputFail("testSelect1",
                       "Expected key " + values[rank] + ", got " + res.key);
        else
            outputPass("testSelect1");
    }

    public static void testSelect2() {
        int[] values = {10, 20, 30, 40, 50, 60};
        int rank = 0;
        RedBlackTree tree = new RedBlackTree();
        Node res;
        try {
            for (int i = 0; i < values.length; i++)
                tree.insert(values[i]);
            res = tree.select(rank);
        } catch (Exception e) {
            outputFail("testSelect2", "Exception: " + e);
            e.printStackTrace();
            return;
        }

        if (res.key != values[rank])
            outputFail("testSelect2",
                       "Expected key " + values[rank] + ", got " + res.key);
        else
            outputPass("testSelect2");
    }

    public static void testSelect3() {
        int[] values = {10, 20, 30, 40, 50, 60};
        int rank = 1;
        RedBlackTree tree = new RedBlackTree();
        Node res;
        try {
            for (int i = 0; i < values.length; i++)
                tree.insert(values[i]);
            res = tree.select(rank);
        } catch (Exception e) {
            outputFail("testSelect3", "Exception: " + e);
            e.printStackTrace();
            return;
        }

        if (res.key != values[rank])
            outputFail("testSelect3",
                       "Expected key " + values[rank] + ", got " + res.key);
        else
            outputPass("testSelect3");
    }

    public static void testSelect4() {
        int[] values = {10, 20, 30, 40, 50, 60};
        int rank = 2;
        RedBlackTree tree = new RedBlackTree();
        Node res;
        try {
            for (int i = 0; i < values.length; i++)
                tree.insert(values[i]);
            res = tree.select(rank);
        } catch (Exception e) {
            outputFail("testSelect4", "Exception: " + e);
            e.printStackTrace();
            return;
        }

        if (res.key != values[rank])
            outputFail("testSelect4",
                       "Expected key " + values[rank] + ", got " + res.key);
        else
            outputPass("testSelect4");
    }

    public static void testSelect5() {
        int[] values = {10, 20, 30, 40, 50, 60};
        int rank = 3;
        RedBlackTree tree = new RedBlackTree();
        Node res;
        try {
            for (int i = 0; i < values.length; i++)
                tree.insert(values[i]);
            res = tree.select(rank);
        } catch (Exception e) {
            outputFail("testSelect5", "Exception: " + e);
            e.printStackTrace();
            return;
        }

        if (res.key != values[rank])
            outputFail("testSelect5",
                       "Expected key " + values[rank] + ", got " + res.key);
        else
            outputPass("testSelect5");
    }

    public static void testSelect6() {
        int[] values = {10, 20, 30, 40, 50, 60};
        int rank = 4;
        RedBlackTree tree = new RedBlackTree();
        Node res;
        try {
            for (int i = 0; i < values.length; i++)
                tree.insert(values[i]);
            res = tree.select(rank);
        } catch (Exception e) {
            outputFail("testSelect6", "Exception: " + e);
            e.printStackTrace();
            return;
        }

        if (res.key != values[rank])
            outputFail("testSelect6",
                       "Expected key " + values[rank] + ", got " + res.key);
        else
            outputPass("testSelect6");
    }

    public static void testSelect7() {
        int[] values = {10, 20, 30, 40, 50, 60};
        int rank = 5;
        RedBlackTree tree = new RedBlackTree();
        Node res;
        try {
            for (int i = 0; i < values.length; i++)
                tree.insert(values[i]);
            res = tree.select(rank);
        } catch (Exception e) {
            outputFail("testSelect7", "Exception: " + e);
            e.printStackTrace();
            return;
        }

        if (res.key != values[rank])
            outputFail("testSelect7",
                       "Expected key " + values[rank] + ", got " + res.key);
        else
            outputPass("testSelect7");
    }

    public static void testSelect8() {
        int[] values = {4, 2, 3, 0, 1};
        int rank = 2;
        RedBlackTree tree = new RedBlackTree();
        Node res;
        try {
            tree.insert(4);
            tree.insert(2);
            tree.insert(3);
            tree.insert(0);
            tree.insert(1);
            tree.erase(1);
            res = tree.select(2);
        } catch (Exception e) {
            outputFail("testSelect8", "Exception: " + e);
            e.printStackTrace();
            return;
        }

        if (res.key != 3)
            outputFail("testSelect8",
                       "Expected key 2, got " + res.key);
        else
            outputPass("testSelect8");
    }

    public static void testSelect9() {
        int[] values = {10, 20, 30, 40, 50, 60, 70};
        int rank = 0;
        RedBlackTree tree = new RedBlackTree();
        Node res;
        try {
            tree.insert(values[3]);
            tree.insert(values[1]);
            tree.insert(values[5]);
            tree.insert(values[0]);
            tree.insert(values[2]);
            tree.insert(values[4]);
            tree.insert(values[6]);
            res = tree.select(rank);
        } catch (Exception e) {
            outputFail("testSelect9", "Exception: " + e);
            e.printStackTrace();
            return;
        }

        if (res.key != values[rank])
            outputFail("testSelect9",
                       "Expected key " + values[rank] + ", got " + res.key);
        else
            outputPass("testSelect9");
    }

    public static void testRank1() {
        int[] values = {10, 20, 30};
        int expectedRank = 2;
        int rank;
        RedBlackTree tree = new RedBlackTree();
        try {
            tree.insert(values[0]);
            tree.insert(values[1]);
            tree.insert(values[2]);
            rank = tree.rank(tree.find(values[expectedRank]));
        } catch (Exception e) {
            outputFail("testRank1", "Exception: " + e);
            e.printStackTrace();
            return;
        }

        if (rank != expectedRank)
            outputFail("testRank1",
                       "Expected rank " + expectedRank + ", got " + rank);
        else
            outputPass("testRank1");
    }

    public static void testRank2() {
        int[] values = {10, 20, 30, 40, 50, 60};
        int expectedRank = 0;
        int rank;
        RedBlackTree tree = new RedBlackTree();
        try {
            for (int i = 0; i < values.length; i++)
                tree.insert(values[i]);
            rank = tree.rank(tree.find(values[expectedRank]));
        } catch (Exception e) {
            outputFail("testRank2", "Exception: " + e);
            e.printStackTrace();
            return;
        }

        if (rank != expectedRank)
            outputFail("testRank2",
                       "Expected rank " + expectedRank + ", got " + rank);
        else
            outputPass("testRank2");
    }

    public static void testRank3() {
        int[] values = {10, 20, 30, 40, 50, 60};
        int expectedRank = 1;
        int rank;
        RedBlackTree tree = new RedBlackTree();
        try {
            for (int i = 0; i < values.length; i++)
                tree.insert(values[i]);
            rank = tree.rank(tree.find(values[expectedRank]));
        } catch (Exception e) {
            outputFail("testRank3", "Exception: " + e);
            e.printStackTrace();
            return;
        }

        if (rank != expectedRank)
            outputFail("testRank3",
                       "Expected rank " + expectedRank + ", got " + rank);
        else
            outputPass("testRank3");
    }

    public static void testRank4() {
        int[] values = {10, 20, 30, 40, 50, 60};
        int expectedRank = 2;
        int rank;
        RedBlackTree tree = new RedBlackTree();
        try {
            for (int i = 0; i < values.length; i++)
                tree.insert(values[i]);
            rank = tree.rank(tree.find(values[expectedRank]));
        } catch (Exception e) {
            outputFail("testRank4", "Exception: " + e);
            e.printStackTrace();
            return;
        }

        if (rank != expectedRank)
            outputFail("testRank4",
                       "Expected rank " + expectedRank + ", got " + rank);
        else
            outputPass("testRank4");
    }

    public static void testRank5() {
        int[] values = {10, 20, 30, 40, 50, 60};
        int expectedRank = 3;
        int rank;
        RedBlackTree tree = new RedBlackTree();
        try {
            for (int i = 0; i < values.length; i++)
                tree.insert(values[i]);
            rank = tree.rank(tree.find(values[expectedRank]));
        } catch (Exception e) {
            outputFail("testRank5", "Exception: " + e);
            e.printStackTrace();
            return;
        }

        if (rank != expectedRank)
            outputFail("testRank5",
                       "Expected rank " + expectedRank + ", got " + rank);
        else
            outputPass("testRank5");
    }

    public static void testRank6() {
        int[] values = {10, 20, 30, 40, 50, 60};
        int expectedRank = 4;
        int rank;
        RedBlackTree tree = new RedBlackTree();
        try {
            for (int i = 0; i < values.length; i++)
                tree.insert(values[i]);
            rank = tree.rank(tree.find(values[expectedRank]));
        } catch (Exception e) {
            outputFail("testRank6", "Exception: " + e);
            e.printStackTrace();
            return;
        }

        if (rank != expectedRank)
            outputFail("testRank6",
                       "Expected rank " + expectedRank + ", got " + rank);
        else
            outputPass("testRank6");
    }

    public static void testRank7() {
        int[] values = {10, 20, 30, 40, 50, 60};
        int expectedRank = 5;
        int rank;
        RedBlackTree tree = new RedBlackTree();
        try {
            for (int i = 0; i < values.length; i++)
                tree.insert(values[i]);
            rank = tree.rank(tree.find(values[expectedRank]));
        } catch (Exception e) {
            outputFail("testRank7", "Exception: " + e);
            e.printStackTrace();
            return;
        }

        if (rank != expectedRank)
            outputFail("testRank7",
                       "Expected rank " + expectedRank + ", got " + rank);
        else
            outputPass("testRank7");
    }

    public static void testRank8() {
        int[] values = {10, 20, 30, 40, 50, 60};
        int expectedRank = 4;
        int rank;
        RedBlackTree tree = new RedBlackTree();
        try {
            tree.insert(values[0]);
            tree.insert(values[1]);
            tree.insert(values[2]);
            tree.insert(values[3]);
            tree.insert(values[4]);
            tree.insert(values[5]);
            tree.erase(values[0]);
            rank = tree.key_rank(values[5]);
        } catch (Exception e) {
            outputFail("testRank8", "Exception: " + e);
            e.printStackTrace();
            return;
        }

        if (rank != expectedRank)
            outputFail("testRank8",
                       "Expected rank " + expectedRank + ", got " + rank);
        else
            outputPass("testRank8");
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
        for (int t = 0; t < testcases; t++) {
            int n = sc.nextInt();
            RedBlackTree tree = new RedBlackTree();
            for (int i = 0; i < n; i++) {
                String op = sc.next();
                int arg = sc.nextInt();
                if (op.equals("insert")) tree.insert(arg);
                else if (op.equals("erase")) tree.erase(arg);
                else if (op.equals("select"))
                    System.out.println(tree.select(arg).key);
                else if (op.equals("rank"))
                    System.out.println(tree.key_rank(arg));
            }
        }
    }
}
