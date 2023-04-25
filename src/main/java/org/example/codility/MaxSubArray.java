package org.example.codility;

public class MaxSubArray {

    public static int solution(int[] a) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < a.length ; i++) {
            currSum += a[i];
            if (currSum > maxSum) {
                maxSum = currSum;
            }
            if (currSum < 0) {
                currSum = 0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {

        int[] niz = {7, -8, 4, -5, 20, -2, 3, -6, 5};
        int[] niz2 = {-2, -3, 4, -1, -2, 1, 5, -3};
        int[] niz3 = {-3, 1, -8, 4, -1, 2, 1, -5, 5};
        int[] niz4 = {-3, -4, 5, -1, 2, -4, 6, -1};
        int[] niz5 = {2, -3, 6, -5, 4, 2};
        int[] niz6 = {-1, -2};
        System.out.println(solution(niz5));
    }
}
