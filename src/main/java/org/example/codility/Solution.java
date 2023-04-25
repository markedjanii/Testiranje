package org.example.codility;

public class Solution {

    public static int solution(int[] A) {
        int n = A.length;
        boolean[] seen = new boolean[n+1]; // initialize a boolean array to keep track of seen values

        for (int i = 0; i < n; i++) {
            if (A[i] > 0 && A[i] <= n) {
                seen[A[i]] = true; // mark the value as seen
            }
        }

        for (int i = 1; i <= n; i++) {
            if (!seen[i]) {
                return i; // return the first missing positive integer
            }
        }

        return n+1; // all positive integers from 1 to n are present, return the next one
    }

    public static void main(String[] args) {

        int[] niz = {1, 3, 6, 4, 11, 2};
        System.out.println(solution(niz));
    }
}
