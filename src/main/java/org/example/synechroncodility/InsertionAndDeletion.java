package org.example.synechroncodility;

import java.util.HashMap;
import java.util.Map;

public class InsertionAndDeletion {

    public static int solution(int[] a) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int elem : a) {
            map.put(elem, map.getOrDefault(elem, 0) + 1);
        }
        int minMoves = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            int insertions = Math.abs(key - value);
            int deletions = Math.abs(0 - value);
            minMoves += Math.min(insertions, deletions);
        }
        return minMoves;
    }
    public static void main(String[] args) {

        int[] A = {1, 1, 4, 4, 4, 5, 5, 5, 5};
        System.out.println(solution(A)); // expected output: 3

        int[] B = {10, 10, 10};
        System.out.println(solution(B)); // expected output: 3
    }
}
