package org.example.vezba;

public class StringTasks {

    public static void main(String[] args) {

    }

    private static String removeSpecChar(String str) {
        return str.replaceAll("[^-.,a-zA-Z0-9\\s]","");
    }
}
