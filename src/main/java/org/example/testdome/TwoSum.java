package org.example.testdome;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] findTwoSum(int[] nums, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        if (nums == null || nums.length < 2) return null;
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int rem = sum - nums[i];
            if (map.containsKey(rem)) {
                result[0] = i;
                result[1] = map.get(rem);
                return result;
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] indices = findTwoSum(new int[] { 3, 1, 7, 5}, 10);
        if(indices != null) {
            System.out.println(indices[0] + " " + indices[1]);
        }
    }
}
