package org.example.codility;

public class MaxCounters {

    public static int[] solution(int n, int[] a) {
        int [] result = new int[n];
        int currMax = 0;
        int startLine = 0;
        for (int i = 0; i < a.length; i++) {
            int instruction = a[i];
            if (instruction <= n) {
                if (instruction < startLine) {
                    result[instruction-1] = startLine + 1;
                } else {
                    result[instruction-1] += 1;
                }
                if (result[instruction-1] > currMax) currMax = result[instruction-1];
            } else {
                startLine = currMax;
            }
        }
        for (int i = 0; i < n; i++) {
            if (result[i] < startLine) result[i] = startLine;
        }

        return result;
    }

    public static void main(String[] args) {

        int[] niz = {3, 4, 4, 6, 1, 4, 4, 3, 6, 1, 3};
        int[] solution = solution(5, niz);
        for (int elem : solution) {
            System.out.println(elem);
        }
    }
}
