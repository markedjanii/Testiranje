package org.example.mocarttestdome;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookSale {
    public static int nthLowestSelling(int[] sales, int n) {
        Map<Integer, Integer> bookSales = new HashMap<>();

        // Count the sales for each book
        for (int sale : sales) {
            bookSales.put(sale, bookSales.getOrDefault(sale, 0) + 1);
        }

        // Sort the book sales by value in ascending order
        List<Map.Entry<Integer, Integer>> sortedSales = new ArrayList<>(bookSales.entrySet());
        Collections.sort(sortedSales, Map.Entry.comparingByValue());

        // Return the nth key in the sorted list
        return sortedSales.get(n-1).getKey();
    }

    public static void main(String[] args) {
        int x = nthLowestSelling(new int[] { 5, 4, 3, 2, 1, 5, 4, 3, 2, 5, 4, 3, 5, 4, 5 }, 3);
        System.out.println(x); // Output: 2
    }
}
