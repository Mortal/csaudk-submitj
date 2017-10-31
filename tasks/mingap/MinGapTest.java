// Version: 2017103101
import java.util.*;
import java.io.*;

public class MinGapTest {
    public static void testAll() {
        clearTerminal();
        testAugment1();
        testAugment2();
        testAugment3();
        test1();
    }

    public static void testAugment1() {
        Augment a;
        int k1 = 12;
        int k2 = 22;
        try {
            a = Augment.combine(
                Augment.combine(
                    Augment.leaf(),
                    Augment.leaf(),
                    k1),
                Augment.leaf(),
                k2);
        } catch (Exception e) {
            outputFail("testAugment1", "Exception: " + e);
            e.printStackTrace();
            return;
        }

        if (a.minGap != k2 - k1)
            outputFail("testAugment1",
                       "Expected min gap " + (k2-k1) + ", got " + a.minGap);
        else
            outputPass("testAugment1");
    }

    public static void testAugment2() {
        Augment a;
        int k1 = 12;
        int k2 = 22;
        try {
            a = Augment.combine(
                Augment.leaf(),
                Augment.combine(
                    Augment.leaf(),
                    Augment.leaf(),
                    k2),
                k1);
        } catch (Exception e) {
            outputFail("testAugment2", "Exception: " + e);
            e.printStackTrace();
            return;
        }

        if (a.minGap != k2 - k1)
            outputFail("testAugment2",
                       "Expected min gap " + (k2-k1) + ", got " + a.minGap);
        else
            outputPass("testAugment2");
    }

    public static void testAugment3() {
        Augment a;
        int k1 = 8;
        int k2 = 12;
        int k3 = 22;
        int minGap = Math.min(k2 - k1, k3 - k2);
        try {
            a = Augment.combine(
                Augment.combine(
                    Augment.leaf(),
                    Augment.leaf(),
                    k1),
                Augment.combine(
                    Augment.leaf(),
                    Augment.leaf(),
                    k3),
                k2);
        } catch (Exception e) {
            outputFail("testAugment3", "Exception: " + e);
            e.printStackTrace();
            return;
        }

        if (a.minGap != minGap)
            outputFail("testAugment3",
                       "Expected min gap " + minGap + ", got " + a.minGap);
        else
            outputPass("testAugment3");
    }

    public static void test1() {
        int[] values = {0, 11, 23, 33, 49};
        int expectedResult = 33 - 23;
        RedBlackTree tree = new RedBlackTree();
        int res;
        try {
            tree.insert(values[4]);
            tree.insert(values[2]);
            tree.insert(values[3]);
            tree.insert(values[0]);
            tree.insert(values[1]);
            tree.erase(values[1]);
            res = tree.minGap();
        } catch (Exception e) {
            outputFail("test1", "Exception: " + e);
            e.printStackTrace();
            return;
        }

        if (res != expectedResult)
            outputFail("test1",
                       "Expected min gap " + expectedResult + ", got " + res);
        else
            outputPass("test1");
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
                if (op.equals("insert")) tree.insert(sc.nextInt());
                else if (op.equals("erase")) tree.erase(sc.nextInt());
                else if (op.equals("query"))
                    System.out.println(tree.minGap());
            }
        }
    }
}
