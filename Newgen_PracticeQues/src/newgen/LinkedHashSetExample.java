package newgen;

import java.util.*;

public class LinkedHashSetExample {
    public static void main(String[] args) {
        // Creating a LinkedHashSet
        LinkedHashSet<String> set = new LinkedHashSet<>();

        // Adding elements
        set.add("Apple");
        set.add("Banana");
        set.add("Cherry");
        set.add("Apple");  // Duplicate, won't be added

        // Printing LinkedHashSet
        System.out.println("LinkedHashSet Elements: " + set);

        // Checking if an element exists
        System.out.println("Contains Banana? " + set.contains("Banana"));

        // Removing an element
        set.remove("Cherry");
        System.out.println("After removing Cherry: " + set);

        // Iterating through LinkedHashSet (Insertion Order Maintained)
        for (String fruit : set) {
            System.out.println(fruit);
        }
    }
}
