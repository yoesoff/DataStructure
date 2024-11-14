package com.mhyusuf.collection;

import java.util.*;

public class BelajarArrayList {
    public static void main(String[] args) {
        // Array List Example
        System.out.println("1. Array List Example");
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("World");
        list.add("World"); // look at this duplicate line
        list.add("Ananda");
        System.out.println(list); // Output: [Hello, World, World, Ananda]
        for(String item : list) {
            System.out.println(item);
        }

        // Map Example
        System.out.println("2. Map Example");
        Map<String, String> map = new HashMap<>();
        map.put("name", "M. Yusuf");
        map.put("age", "25");
        System.out.println(map); // Output: {name=M. Yusuf, age=25}
        for(Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // Set Example
        System.out.println("3. Set Example");
        Set<String> set = new HashSet<>();
        set.add("Hello");
        set.add("World");
        set.add("World"); // look at this duplicate line
        set.add("Ananda");
        System.out.println(set); // Output: [Ananda, Hello, World]
        for (String item : set) {
            System.out.println(item);
        }

        // Queue Example
        System.out.println("4. Queue Example");
        Queue<String> queue = new LinkedList<>();
        queue.add("Hello");
        queue.add("World");
        queue.add("World"); // look at this duplicate line
        queue.add("Ananda");
        System.out.println(queue); // Output: [Hello, World, World, Ananda]
        for (String item : queue) {
            System.out.println(item);
        }

    }
}
