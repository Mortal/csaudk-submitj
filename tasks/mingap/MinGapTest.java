// Version: 2017120801
import java.util.*;
import java.io.*;

public class MinGapTest {
    public static void testAll() {
        clearTerminal();
        testAugment1();
        testAugment2();
        testAugment3();
        testAugment4();
        testAugment5();
        testAugment6();
        testAugment7();
        testAugment8();
        testAugment9();
        testAugment10();
        testAugment11();
        testAugment12();
        testAugment13();
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

    public static void testAugment4() {
        Augment a;
        int k1 = 1;
        int k2 = 10;
        int k3 = 20;
        int k4 = 28;
        int k5 = 42;
        int minGap = 28 - 20;
        //          k4
        //         /  \
        //       k2    k5
        //      /  \
        //    k1    k3
        try {
            a = Augment.combine(
                    Augment.combine(
                        Augment.combine(
                            Augment.leaf(),
                            Augment.leaf(),
                            k1),
                        Augment.combine(
                            Augment.leaf(),
                            Augment.leaf(),
                            k3),
                        k2),
                    Augment.combine(
                        Augment.leaf(),
                        Augment.leaf(),
                        k5),
                    k4);
        } catch (Exception e) {
            outputFail("testAugment4", "Exception: " + e);
            e.printStackTrace();
            return;
        }

        if (a.minGap != minGap)
            outputFail("testAugment4",
                       "Expected min gap " + minGap + ", got " + a.minGap);
        else
            outputPass("testAugment4");
    }

    public static void testAugment5() {
        Augment a;
        int k1 = 18;
        int k2 = 26;
        int k3 = 34;
        int k4 = 36;
        int k5 = 65;
        int minGap = 36 - 34;
        //          k3
        //         /  \
        //       k2    k4
        //      /        \
        //    k1          k5
        try {
            a = Augment.combine(
                    Augment.combine(
                        Augment.combine(Augment.leaf(), Augment.leaf(), k1),
                        Augment.leaf(),
                        k2),
                    Augment.combine(
                        Augment.leaf(),
                        Augment.combine(Augment.leaf(), Augment.leaf(), k5),
                        k4),
                    k3);
        } catch (Exception e) {
            outputFail("testAugment5", "Exception: " + e);
            e.printStackTrace();
            return;
        }

        if (a.minGap != minGap)
            outputFail("testAugment5",
                       "Expected min gap " + minGap + ", got " + a.minGap);
        else
            outputPass("testAugment5");
    }

    public static void testAugment6() {
        Augment a;
        int k1 = 11;
        int k2 = 48;
        int minGap = 48 - 11;
        //  k1
        //    \
        //     k2
        try {
            a = Augment.combine(
                    Augment.leaf(),
                    Augment.combine(Augment.leaf(), Augment.leaf(), k2),
                    k1);
        } catch (Exception e) {
            outputFail("testAugment6", "Exception: " + e);
            e.printStackTrace();
            return;
        }

        if (a.minGap != minGap)
            outputFail("testAugment6",
                       "Expected min gap " + minGap + ", got " + a.minGap);
        else
            outputPass("testAugment6");
    }

    public static void testAugment7() {
        Augment a;
        int k1 = 19;
        int k2 = 36;
        int k3 = 63;
        int minGap = 36 - 19;
        //          k3
        //         /
        //       k1
        //         \
        //          k2
        try {
            a = Augment.combine(
                    Augment.combine(
                        Augment.leaf(),
                        Augment.combine(Augment.leaf(), Augment.leaf(), k2),
                        k1),
                    Augment.leaf(),
                    k3);
        } catch (Exception e) {
            outputFail("testAugment7", "Exception: " + e);
            e.printStackTrace();
            return;
        }

        if (a.minGap != minGap)
            outputFail("testAugment7",
                       "Expected min gap " + minGap + ", got " + a.minGap);
        else
            outputPass("testAugment7");
    }

    public static void testAugment8() {
        Augment a;
        int k1 = 1;
        int k2 = 1000000000;
        int minGap = k2 - k1;
        //       k1
        //         \
        //          k2
        try {
            a = Augment.combine(
                    Augment.leaf(),
                    Augment.combine(Augment.leaf(), Augment.leaf(), k2),
                    k1);
        } catch (Exception e) {
            outputFail("testAugment8", "Exception: " + e);
            e.printStackTrace();
            return;
        }

        if (a.minGap != minGap)
            outputFail("testAugment8",
                       "Expected min gap " + minGap + ", got " + a.minGap);
        else
            outputPass("testAugment8");
    }

    public static void testAugment9() {
        Augment a;
        int k1 = 1;
        int k2 = 4;
        int k3 = 20;
        int k4 = 28;
        int k5 = 42;
        int minGap = 4 - 1;
        //          k4
        //         /  \
        //       k2    k5
        //      /  \
        //    k1    k3
        try {
            a = Augment.combine(
                    Augment.combine(
                            Augment.combine(
                                    Augment.leaf(),
                                    Augment.leaf(),
                                    k1),
                            Augment.combine(
                                    Augment.leaf(),
                                    Augment.leaf(),
                                    k3),
                            k2),
                    Augment.combine(
                            Augment.leaf(),
                            Augment.leaf(),
                            k5),
                    k4);
        } catch (Exception e) {
            outputFail("testAugment9", "Exception: " + e);
            e.printStackTrace();
            return;
        }

        if (a.minGap != minGap)
            outputFail("testAugment9",
                       "Expected min gap " + minGap + ", got " + a.minGap);
        else
            outputPass("testAugment9");
    }

    public static void testAugment10() {
        Augment a;
        int k1 = 1;
        int k2 = 3;
        int k3 = 4;
        int minGap = 4 - 3;
        try {
            a = Augment.combine(
                    Augment.combine(
                            Augment.leaf(),
                            Augment.combine(
                                    Augment.leaf(),
                                    Augment.leaf(),
                                    k2),
                            k1),
                    Augment.leaf(),
                    k3);
        } catch (Exception e) {
            outputFail("testAugment10", "Exception: " + e);
            e.printStackTrace();
            return;
        }

        if (a.minGap != minGap)
            outputFail("testAugment10",
                       "Expected min gap " + minGap + ", got " + a.minGap);
        else
            outputPass("testAugment10");
    }

    public static void testAugment11() {
        Augment a;
        int k1 = 13;
        int k2 = 30;
        int k3 = 31;
        int k4 = 32;

        int minGap = 31 - 30;
        try {
            a = Augment.combine(
                    Augment.combine(
                            Augment.leaf(),
                            Augment.combine(
                                    Augment.leaf(),
                                    Augment.leaf(),
                                    k2),
                            k1),
                    Augment.combine(
                            Augment.leaf(),
                            Augment.leaf(),
                            k4),
                    k3);
        } catch (Exception e) {
            outputFail("testAugment11", "Exception: " + e);
            e.printStackTrace();
            return;
        }

        if (a.minGap != minGap)
            outputFail("testAugment11",
                       "Expected min gap " + minGap + ", got " + a.minGap);
        else
            outputPass("testAugment11");
    }
    
    public static void testAugment12() {
        Augment a;
        int k0 = 1;
        int k1 = 2;
        int k2 = 10;
        int k3 = 15;
        int k4 = 17;

        int minGap = 2 - 1;
        try {
            a = Augment.combine(
                    Augment.leaf(),
                    Augment.combine(
                        Augment.combine(
                            Augment.combine(
                                Augment.leaf(),
                                Augment.leaf(),
                                k1
                            ),
                            Augment.combine(
                                Augment.leaf(),
                                Augment.leaf(),
                                k3
                            ),
                            k2
                        ),
                        Augment.leaf(),
                        k4),
                    k0
                 );
        } catch (Exception e) {
            outputFail("testAugment12", "Exception: " + e);
            e.printStackTrace();
            return;
        }

        if (a.minGap != minGap)
            outputFail("testAugment12",
                       "Expected min gap " + minGap + ", got " + a.minGap);
        else
            outputPass("testAugment12");
    }
    
    public static void testAugment13() {
        Augment a;
        int k0 = 1;
        int k1 = 2;
        int k2 = 10;
        int k3 = 12;
        int k4 = 15;
        int k5 = 17;

        int minGap = 2 - 1;
        try {
            Augment a2 = Augment.combine(Augment.leaf(), Augment.leaf(), k1);
            Augment a12 = Augment.combine(Augment.leaf(), Augment.leaf(), k3);
            Augment a10 = Augment.combine(a2, a12, k2);
            Augment a17 = Augment.combine(Augment.leaf(), Augment.leaf(), k5);
            Augment a15 = Augment.combine(a10, a17, k4);
            Augment a1 = Augment.combine(Augment.leaf(), a15, k0);
            a = a1;
        } catch (Exception e) {
            outputFail("testAugment13", "Exception: " + e);
            e.printStackTrace();
            return;
        }

        if (a.minGap != minGap)
            outputFail("testAugment13",
                       "Expected min gap " + minGap + ", got " + a.minGap);
        else
            outputPass("testAugment13");
    }

    public static void test1() {
        int[] values = {1, 12, 23, 33, 49};
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
