package org.example.mocarttestdome;

public class MovingTotal {
    private int[] buffer;
    private int index;

    public MovingTotal() {
        buffer = new int[3];
        index = 0;
    }

    public void append(int[] list) {
        for (int i = 0; i < list.length; i++) {
            buffer[index] = list[i];
            index = (index + 1) % 3;
        }
    }

    public boolean contains(int total) {
        int sum = buffer[0] + buffer[1] + buffer[2];
        if (sum == total) {
            return true;
        }
        for (int i = 3; i < buffer.length + 3; i++) {
            sum = sum - buffer[(i - 3) % 3] + buffer[i % 3];
            if (sum == total) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        MovingTotal movingTotal = new MovingTotal();

        movingTotal.append(new int[] { 1, 2, 3, 4 });

        System.out.println(movingTotal.contains(6));
        System.out.println(movingTotal.contains(9));
        System.out.println(movingTotal.contains(12));
        System.out.println(movingTotal.contains(7));

        /*movingTotal.append(new int[] { 5 });

        System.out.println(movingTotal.contains(6));
        System.out.println(movingTotal.contains(9));
        System.out.println(movingTotal.contains(12));
        System.out.println(movingTotal.contains(7));*/
    }
}