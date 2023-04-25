package org.example.mocarttestdome;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableSet;
import java.util.TreeSet;

public class Bankomat {


    public static class InvalidBanknoteException extends RuntimeException {
        public InvalidBanknoteException(String message) {
            super(message);
        }
    }

    public static class AmountUnavaliableException extends RuntimeException {
        public AmountUnavaliableException(String message) {
            super(message);
        }
    }

    private Map<Integer, Integer> banknoteMap = new HashMap<>();

    final NavigableSet<Integer> allowed = new TreeSet<>(Arrays.asList(50, 100, 200, 500, 1000, 2000, 5000));

    public void deposit(int banknote, int count) {
        if (!allowed.contains(banknote)) {
            throw new InvalidBanknoteException("This banknote is not supported");
        }
        if (count <= 0) {
            throw new AmountUnavaliableException("Amount of banknotes must be greater than 0");
        }
        if (banknoteMap.containsKey(banknote)) {
            Integer storedCount = banknoteMap.get(banknote);
            banknoteMap.put(banknote, count + storedCount);
        } else {
            banknoteMap.put(banknote, count);
        }
    }

    public int total() {
        int total = 0;
        for (Map.Entry<Integer, Integer> entry : banknoteMap.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            total += key * value;
        }
        return total;
    }

    public int[][] withdraw(int amount) {
        int[][] plan = new int[allowed.size()][2];
        int i = 0;
        for (int banknote : allowed.descendingSet()) {
            int count = amount / banknote;
            int availableCount = banknoteMap.getOrDefault(banknote, 0);
            int dispenseCount = Math.min(count, availableCount);
            if (dispenseCount > 0) {
                banknoteMap.put(banknote, availableCount - dispenseCount);
                amount -= dispenseCount * banknote;
            }
            if (amount == 0) {
                break;
            }
            i++;
        }
        if (amount > 0) {
            throw new AmountUnavaliableException("Amount is unavailable");
        }
        return Arrays.copyOfRange(plan, 0, i);
    }

    //

    public static void main(String[] args) {
        Bankomat b = new Bankomat();
        b.deposit(50, 10);
        b.deposit(100, 10);
        b.deposit(200, 10);
        b.deposit(500, 10);
        System.out.println(b.total());

        /*int[][] r;

        r = b.withdraw(1700);
        System.out.println(Arrays.toString(r[0]));
        System.out.println(Arrays.toString(r[1]));
        System.out.println(b.total());

        r = b.withdraw(2450);
        System.out.println(Arrays.toString(r[0]));
        System.out.println(Arrays.toString(r[1]));
        System.out.println(Arrays.toString(r[2]));
        System.out.println(b.total());*/
    }
}
