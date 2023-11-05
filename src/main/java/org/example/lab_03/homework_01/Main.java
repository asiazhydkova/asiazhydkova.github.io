package org.example.lab_03.homework_01;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Set<Integer> set1 = new TreeSet<>(Arrays.asList(1, 3, 5, 5, 86, 6, 2, 25, 34, 67));
        Set<Integer> set2 = new TreeSet<>(Arrays.asList(6, 8, 95, 1, 34, 4, 7, 6, 405, 841));


        System.out.println("Union set -> " + union(set1, set2));
        System.out.println("Intersect set -> " + intersect(set1, set2));
    }

    public static Set<Integer> union(Set set1, Set set2) {
        Set<Integer> resultSet = new TreeSet<>(set1);
        resultSet.addAll(set2);
        return resultSet;
    }

    public static Set<Integer> intersect(Set set1, Set set2) {
        Set<Integer> resultSet = new TreeSet<>(set1);
        resultSet.retainAll(set2);
        return resultSet;
    }
}
