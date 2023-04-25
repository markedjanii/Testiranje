package org.example.vezba;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;


public class CollectionsAndMaps
{

    public static void main(String[] args) {
        System.out.println(10%7);
    }

    private static void mapIteration() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1,"prvi");
        map.put(2,"drugi");
        map.put(3,"treci");
        map.put(4,"cetvrti");
        System.out.println(map.keySet()); // [1, 2, 3, 4]
        Set<Entry<Integer, String>> entries = map.entrySet();
        System.out.println(entries); // [1=prvi, 2=drugi, 3=treci, 4=cetvrti]
        for (Entry<Integer,String> entry : entries) {
            System.out.println(entry.getKey() + "***" + entry.getValue());
        }
    }

    private static void treeSet() {
        TreeSet<String> treeadd = new TreeSet<String>();
        treeadd.add("A");
        treeadd.add("B");
        treeadd.add("C");
        treeadd.add("D");

        NavigableSet<String> descendingSet = treeadd.descendingSet();

    }

    private static void nestedListsAndMaps() {
        List<String> countries1 = new ArrayList<>();
        countries1.add("ARE");
        countries1.add("SRB");
        countries1.add("BIH");
        countries1.add("NOR");

        List<String> countries2 = new ArrayList<>();
        countries2.add("ENG");
        countries2.add("ALB");
        countries2.add("USA");
        countries2.add("GER");

        Map<BigDecimal, List<String>> fees = new HashMap<>();
        fees.put(BigDecimal.valueOf(11.00), countries1);
        fees.put(BigDecimal.valueOf(5.00), countries2);
        Set<Entry<BigDecimal, List<String>>> entries = fees.entrySet();
        List<Entry<BigDecimal, List<String>>> entryArrayList = new ArrayList<>(entries);
        entryArrayList.sort(Entry.comparingByKey());

        Collection<List<String>> values = fees.values();
        List<String> innerList = values.stream().flatMap(List::stream).collect(Collectors.toList());
        boolean bool = innerList.contains("ENG");

        System.out.println(fees); //{11.0=[ARE, SRB, BIH, NOR], 5.0=[ENG, ALB, USA, GER]}
        System.out.println(fees.entrySet());  //[11.0=[ARE, SRB, BIH, NOR], 5.0=[ENG, ALB, USA, GER]]
        System.out.println(entryArrayList);  //[11.0=[ARE, SRB, BIH, NOR], 5.0=[ENG, ALB, USA, GER]]
        // sorted: [5.0=[ENG, ALB, USA, GER], 11.0=[ARE, SRB, BIH, NOR]]

        Map<String, Map<String, String>> outerMap = new HashMap<>();
        Map<String, String> innerMap = new HashMap<>();
        innerMap.put("SRB", "Serbia");
        Map<String, String> innerMap2 = new HashMap<>();
        innerMap2.put("DEN", "Denmark");
        Map<String, String> innerMap3 = new HashMap<>();
        innerMap3.put("ENG", "England");
        innerMap3.put("USA", "United States of America");
        outerMap.put("srpski", innerMap);
        outerMap.put("danski", innerMap2);
        outerMap.put("engleski", innerMap3);
        System.out.println(outerMap); // {engleski={USA=United States of America, ENG=England}, srpski={SRB=Serbia}, danski={DEN=Denmark}}

        Map<String, Map<String, String>> result = new HashMap<>();
        for (Entry<String, Map<String, String>> countries : outerMap.entrySet()) {
            Map<String, String> countriesValue = countries.getValue();
            for (Entry<String, String> country : countriesValue.entrySet()) {
                if (country.getKey().equals("DEN")) {
                    Map<String, String> innerResult = new HashMap<>();
                    innerResult.put(country.getKey(), country.getValue());
                    result.put(countries.getKey(), innerResult);
                }
            }
        }
    }

}
