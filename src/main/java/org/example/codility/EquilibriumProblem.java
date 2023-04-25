package org.example.codility;

public class EquilibriumProblem {

    public static int solution(int[] A) {
        int left = A[0];
        int right = 0;
        for (int i = 1; i < A.length; i++) {
            right += A[i];
        }
        int min = Math.abs(left - right);
        int sub;
        for (int p = 2; p < A.length; p++) {
            left += A[p-1];
            right -= A[p-1];
            sub = Math.abs(left - right);
            if (sub < min) {
                min = sub;
            }
        }
        return min;
    }

    public static void main(String[] args) {

        int[] niz = {2,5,2,1};
        System.out.println(solution(niz));
    }
}
