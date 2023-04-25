package org.example.codility;

import java.util.HashMap;
import java.util.Map;

public class Leader {

    public static int solutionWithMap(int[] a) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxOccurrences = 0;
        int maxOccurNumber = 0;
        for (int i = 0; i < a.length; i++) {
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
            if (map.get(a[i]) > maxOccurrences) {
                maxOccurrences = map.get(a[i]);
                maxOccurNumber = a[i];
            }
        }
        if (maxOccurrences <= a.length/2) {
            return -1;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] == maxOccurNumber) {
                return i;
            }
        }
        return -1;
    }

    public static int solution(int [] a) {
        int mostFreqNum = a[0];
        int count = 1;
        for (int i = 1; i < a.length; i++) {
            if (a[i] == mostFreqNum) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    mostFreqNum = a[i];
                    count++;
                }
            }
        }
        int totalCount = 0;
        int mostFreqInd = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == mostFreqNum) {
                totalCount++;
                mostFreqInd = i;
            }
        }
        return (totalCount > a.length/2) ? mostFreqInd : -1;
    }

    public static void main(String[] args) {

        int[] niz = {3, 0, 1, 1, 4, 1, 2};
        System.out.println(solution(niz));
    }
}
