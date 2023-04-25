package org.example.mocarttestdome;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MovingTotalList {
    private List<Integer> numbers;
    private Set<Integer> sums;

    public MovingTotalList() {
        numbers = new ArrayList<>();
        sums = new HashSet<>();
    }

    public void append(int[] list) {
        for (int num : list) {
            if (numbers.size() >= 2) {
                int sum = numbers.get(numbers.size() - 2) + numbers.get(numbers.size() - 1) + num;
                sums.add(sum);
            }
            numbers.add(num);
        }
    }

    public boolean contains(int total) {
        for (int sum : sums) {
            if (sum == total) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        MovingTotalList movingTotal = new MovingTotalList();

        movingTotal.append(new int[] { 1, 2, 3, 4 });

/*        System.out.println(movingTotal.contains(6));
        System.out.println(movingTotal.contains(9));
        System.out.println(movingTotal.contains(12));
        System.out.println(movingTotal.contains(7));*/
        movingTotal.append(new int[] { 7 });

        System.out.println(movingTotal.contains(12));/*
        System.out.println(movingTotal.contains(9));
        System.out.println(movingTotal.contains(12));
        System.out.println(movingTotal.contains(7));*/
    }
}