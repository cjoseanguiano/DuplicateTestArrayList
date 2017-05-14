package com.devix.company;

import java.util.ArrayList;
import java.util.HashSet;

import static com.devix.company.Main.Program.hasDuplicates;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> elements = new ArrayList<>();
        elements.add("one");
        elements.add("two");
        elements.add("three");
        elements.add("four");

        long t1 = System.currentTimeMillis();

        for (int i = 0; i < 1000000; i++) {
            if (hasDuplicates(elements)) {
                System.out.println(false);
            }
        }

        long t2 = System.currentTimeMillis();

        for (int i = 0; i < 1000000; i++) {
            ArrayList<String> copy = removeDuplicates(elements);
            if (copy == null) {
                System.out.println(false);
            }
        }

        long t3 = System.currentTimeMillis();
        System.out.println(t2 - t1);
        System.out.println(t3 - t2);

    }

    public static class Program {
        static boolean hasDuplicates(ArrayList<String> list) {
            for (int i = 0; i < list.size(); i++) {
                for (int x = i + 1; x < list.size(); x++) {
                    if (list.get(i) == list.get(x)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    static ArrayList<String> removeDuplicates(ArrayList<String> list) {
        ArrayList<String> result = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        for (String item : list) {
            if (!set.contains(item)) {
                result.add(item);
                set.add(item);
            }
        }
        return result;
    }
}
