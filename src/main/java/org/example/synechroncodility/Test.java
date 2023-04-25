package org.example.synechroncodility;

public class Test {

    static int s(int i) {
        if (i == 1) {
            return 1;
        } else {
            return i + s(i-1);
        }
    }
    public static void main (String args[]) {
        try {
            throw new RuntimeException();
            //System.out.println("a");
        } catch (RuntimeException ex) {
            System.out.println("b");
        } finally {
            System.out.println("x");
        }
    }
}
