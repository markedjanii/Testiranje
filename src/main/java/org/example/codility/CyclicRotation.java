package org.example.codility;

import java.util.Arrays;

public class CyclicRotation {

    public static void main(String[] args) {
        int[] arr = {4, 2, 9, 10, 5};
        int k = 2;
        rotateArray(arr, k);
        System.out.println(Arrays.toString(arr));
    }

    public static void rotateArray(int[] arr, int k) {
        int n = arr.length;
        k %= n; // to handle cases where k is greater than n
        reverseArray(arr, 0, n - 1); // reverse the entire array
        reverseArray(arr, 0, k - 1); // reverse the first k elements
        reverseArray(arr, k, n - 1); // reverse the remaining elements
    }

    public static void reverseArray(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void rotateJuggling(int[] arr, int k) {
        int n = arr.length;
        k %= n; // to handle cases where k is greater than n

        int gcd = gcd(n, k); // calculate the greatest common divisor of n and k
        for (int i = 0; i < gcd; i++) {
            int temp = arr[i];
            int j = i;
            while (true) {
                int nextIndex = j + k;
                if (nextIndex >= n) {
                    nextIndex -= n;
                }
                if (nextIndex == i) {
                    break;
                }
                arr[j] = arr[nextIndex];
                j = nextIndex;
            }
            arr[j] = temp;
        }
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
