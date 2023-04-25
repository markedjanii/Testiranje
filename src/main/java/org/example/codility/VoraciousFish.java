package org.example.codility;

import java.util.Stack;

public class VoraciousFish {

    public static int solution(int[] a, int[]b) {
        Stack<Integer> stack = new Stack<>();
        int survivors = 0;
        for (int i = 0; i < b.length; i++) {
            if (b[i] == 1) stack.push(a[i]);
            if (b[i] == 0) {
                while (!stack.isEmpty() && a[i] > stack.peek()) {
                    stack.pop();
                }
                if (stack.isEmpty()) survivors ++;
            }

        }

        return survivors + stack.size();
    }

    public static void main(String[] args) {
        int [] a = {4, 8, 2, 6, 7};
        int [] b = {0, 1, 1, 0, 0};
        System.out.println(solution(a,b));
    }
}
