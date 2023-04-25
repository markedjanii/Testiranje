package org.example.codility;

import java.util.Arrays;

public class DiscIntersection {

    static class Disc implements Comparable<Disc>{
        final int start;
        final int end;

        public Disc(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Disc o) {
            return Integer.compare(this.start, o.start);
        }
    }

    private static int totalStartsLessThanEnd(Disc[] discs, double value, int start, int end) {
        int mid = start + (end - start)/2;
        if (end <= start && discs[mid].start > value) {
            return mid - 1;
        }
        if (end <= start) {
            return mid;
        }
        if (discs[mid].start > value) {
            return totalStartsLessThanEnd(discs, value, start, mid-1);
        } else {
            return totalStartsLessThanEnd(discs, value, mid+1, end);
        }
    }

    public static int solution(int[] a) {
        Disc [] discs = new Disc[a.length];
        for (int i = 0; i < a.length; i++) {
            discs[i] = new Disc(i-a[i], i+a[i]);
        }
        Arrays.sort(discs);
        int total = 0;
        for (int i = 0; i < discs.length; i++) {
            total += totalStartsLessThanEnd(discs, discs[i].end + 0.5, 0, discs.length-1) - i;
            if (total > 1000000) {
                return -1;
            }
        }
        return total;
    }

    public static void main(String[] args) {

        int[] niz = {1,5,2,1,4,0};
        System.out.println(solution(niz));
    }
}
