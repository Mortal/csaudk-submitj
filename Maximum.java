import java.io.*;
import java.util.*;
public class Maximum {
    public int computeMaximum(ArrayList<Integer> input) {
        // Implement your code here to return the maximum!
        return 42;
    }

    public static void testAll() {
        test1();
        test2();
    }

    public static void test1() {
        int[] input = { 96, 66, 82, 63, 78, 37, 100, 96, 98, 17, 13, 7, 28, 74, 73, 77, 41, 25, 53, 93 };
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i : input) list.add(i);

        int output = new Maximum().computeMaximum(list);
        int correctAnswer = 100;

        assertEquals(output, correctAnswer, "test1");
    }

    public static void test2() {
        int[] input = { 90, 8, 38, 69, 82, 79, 67, 27, 17, 46, 78, 14, 47, 18, 36, 55, 55, 74, 12, 95 };
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i : input) list.add(i);

        int output = new Maximum().computeMaximum(list);
        int correctAnswer = 95;

        assertEquals(output, correctAnswer, "test2");
    }

    private static void assertEquals(int output, int correctAnswer, String functionName) {
        if (output != correctAnswer)
            throw new RuntimeException("Expected output " + correctAnswer +
                                       " but got " + output);
        else
            System.out.println(functionName + ": OK");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < n; ++i) list.add(sc.nextInt());
        System.out.println(new Maximum().computeMaximum(list));
    }
}
