package org.example.codility;

public class DivCount {

    public static int solution(int a, int b, int k) {
        if (a == b ) {
            return (a % k == 0) ? 1 : 0;
        }
        int firstNum = a;
        while ((firstNum % k) != 0) {
            firstNum++;
        }
        int firstDiv = firstNum/k;
        int lastNum = b;
        while ((lastNum % k) != 0) {
            lastNum--;
        }
        int lastDiv = lastNum/k;
        return lastDiv - firstDiv + 1;
    }

    public int solutionSimple(int A, int B, int K) {
        double nStart = Math.ceil(A / (double) K);
        double nEnd = Math.floor(B / (double) K);
        return (int) (nEnd - nStart + 1);
    }

    public static void main(String[] args) {

        int[] niz = {5,6,7,8,9,10,11,12,13,14,15,16};
        System.out.println(solution(6,11,2));
    }
}
