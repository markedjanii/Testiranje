package org.example.codility;

public class MaxProfit {

    public static int solutionLose(int[] a) {
        // ne radi za slucaj kada je maxProfit posle max-a, a pre min-a
        // {7,8,9,2,5,6,1,3}
        int minI = 0;
        int maxI = 0;
        int min = Integer.MAX_VALUE;
        int max = 0;
        if (a.length == 0) {
            return 0;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
                maxI = i;
            }
            if (a[i] < min) {
                min = a[i];
                minI = i;
            }
        }
        if (minI < maxI) {
            return a[maxI] - a[minI];
        }
        int leftMin = Integer.MAX_VALUE;
        for (int i = 0; i < maxI; i++) {
            if (a[i] < leftMin) {
                leftMin = a[i];
            }
        }
        int rightMax = 0;
        for (int i = minI; i < a.length; i++) {
            if (a[i] > rightMax) {
                rightMax = a[i];
            }
        }
        return Math.max((a[maxI] - leftMin), (rightMax - a[minI]));
    }

    public static int solution(int[] a) {
        int globalMaxSum = 0;
        int localMaxSum = 0;
        for (int i = 1; i <a.length ; i++) {
            int delta = a[i] - a[i-1];
            localMaxSum = Math.max(delta, localMaxSum + delta);
            globalMaxSum = Math.max(localMaxSum, globalMaxSum);
        }
        return globalMaxSum;
    }

    public static int solutionGPT(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        int minPrice = A[0];
        int maxProfit = 0;
        for (int i = 1; i < A.length; i++) {
            int currentPrice = A[i];
            if (currentPrice < minPrice) {
                minPrice = currentPrice;
            } else {
                int profit = currentPrice - minPrice;
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {

        int[] niz = {7,8,9,2,5,6,1,3};
        System.out.println(solutionGPT(niz));
    }
}
