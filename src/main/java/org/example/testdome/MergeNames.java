package org.example.testdome;

import java.util.HashSet;
import java.util.Set;

public class MergeNames {

  public static String[] uniqueNames(String[] names1, String[] names2) {

      Set<String> elements = new HashSet();
      for (String element : names1) {
          elements.add(element);
      }
      for (String element : names2) {
          elements.add(element);
      }
      return elements.toArray(new String[0]);
  }

  public static void main(String[] args) {

    String[] names1 = new String[]{"Ava", "Emma", "Olivia"};
    String[] names2 = new String[]{"Olivia", "Sophia", "Emma"};
    System.out
        .println(String.join(", ", MergeNames.uniqueNames(names1, names2))); // should print Ava, Emma, Olivia, Sophia
  }
}
