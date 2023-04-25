package org.example.codility;

public class PermMissingElem {

    public static int solution(int[] A) {
        int n = A.length;
        int sum = (n+1)*(n+2)/2;
        int currentSum = 0;
        for (int i = 0; i < A.length; i++) {
            currentSum += A[i];
        }
        return sum - currentSum;
    }

    public static void main(String[] args) {

        int[] niz = {2,3,1,5,4};
        System.out.println(solution(niz));
    }
}
