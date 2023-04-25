package org.example.testdome;

public class TrainComposition {
    private Wagon head;
    private Wagon tail;

    class Wagon {
        private int wagonId;
        private Wagon next;
        private Wagon prev;

        public Wagon(int wagonId) {
            this.wagonId = wagonId;
        }
    }

    public TrainComposition() {
    }

    public void attachWagonFromLeft(int wagonId) {
        Wagon newWagon = new Wagon(wagonId);
        if (head == null) {
            head = newWagon;
            tail = newWagon;
        } else {
            newWagon.next = head;
            head.prev = newWagon;
            head = newWagon;
        }
    }

    public void attachWagonFromRight(int wagonId) {
        Wagon newWagon = new Wagon(wagonId);
        if (tail == null) {
            head = newWagon;
            tail = newWagon;
        } else {
            tail.next = newWagon;
            newWagon.prev = tail;
            tail = newWagon;
        }
    }

    public int detachWagonFromLeft() {
        int value = head.wagonId;
        Wagon temp = head.next;
        if (temp == tail) {
            tail = null;
        }
        head = temp;
        return value;
    }

    public int detachWagonFromRight() {
        int wagonId = tail.wagonId;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        return wagonId;
    }

    public static void main(String[] args) {
        TrainComposition train = new TrainComposition();
      /*  train.attachWagonFromRight(11);
        train.attachWagonFromRight(7);
        train.attachWagonFromRight(13);*/
        //train.attachWagonFromLeft(2);
        //train.attachWagonFromLeft(4);
        //printWagons(train);
        System.out.println(train.detachWagonFromRight()); // 7
        //System.out.println(train.detachWagonFromLeft()); // 13
        //System.out.println("********************");
        //printWagons(train);
    }

    private static void printWagons(TrainComposition train) {
        Wagon temp = train.head;
        while (temp != null) {
            System.out.println(temp.wagonId);
            temp = temp.next;
        }
    }
}
