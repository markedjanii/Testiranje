package org.example.codility;

public class FrogRiver {

    public static int solution(int x, int[] a) {
        boolean[] pom = new boolean[x+1];
        int counter = x;
        for (int time = 0; time < a.length; time++) {
            int position = a[time];
            if (!pom[position]) {
                pom[position] = true;
                counter--;
            }
            if (counter == 0) {
                return time;
            }
        }
        return -1;

    }

    public static void main(String[] args) {

        int[] niz = {1, 3, 1, 4, 2, 5, 4, 5};
        System.out.println(solution(5, niz));
    }
}
