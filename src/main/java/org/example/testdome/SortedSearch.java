package org.example.testdome;


public class SortedSearch {
    public static int countNumbers(int[] sortedArray, int lessThan) {
        int count = 0;
        int low = 0;
        int high = sortedArray.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (sortedArray[mid] < lessThan) {
                count = mid + 1;  // all elements to the left of mid are also less than lessThan
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(SortedSearch.countNumbers(new int[] { 1, 3, 5, 7, 9, 11, 13 }, 12));
    }
}
