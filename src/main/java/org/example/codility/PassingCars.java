package org.example.codility;

public class PassingCars {

    public static int solution(int[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        int west = 0;
        int result = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 1) {
                west++;
            }
            if (a[i] == 0) {
                result += sum - west;
            }
            if (result > 1000000000) {
                return -1;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[] niz = {0,0,1,1,0};
        System.out.println(solution(niz));
    }
}
