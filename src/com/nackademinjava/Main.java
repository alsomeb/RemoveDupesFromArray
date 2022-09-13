package com.nackademinjava;

import java.util.Arrays;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        // One way to get unique elements from the array is by putting all elements of the array into hashmap's key and then print the keySet().
        // The hashmap contains only unique keys, so it will automatically remove that duplicate element from the hashmap keySet.

        int[] numbers = {3,3,5,5,5,10};
        int[] numbersNoDupes = intArrayWithoutDupes(numbers);
        System.out.println("Före: " + Arrays.toString(numbers));
        System.out.println("Efter: " + Arrays.toString(numbersNoDupes));


    }

    public static int[] intArrayWithoutDupes(int[] originalArray) {
        HashMap<Integer, Integer> numbersMap = new HashMap<>();

        for (int i = 0; i < originalArray.length; i++) {
            // Returns the value to which the specified key is mapped
            int count = numbersMap.getOrDefault(originalArray[i], 0);

            // Key är varvets nummer i numbers arr och value blir minst 0 + 1, sen läggs på för varje dupe!
            numbersMap.put(originalArray[i], count + 1);
        }

        int[] arrWithoutDupes = new int[numbersMap.size()]; // Dynamisk size på Array från HashMapen

        // Den kommer funka pga vi kör bara dynamiskt så stor som array length är
        // Behöver för indexering, funkar ej med keySet i vanlig for loop
        int count = 0;
        for (int number : numbersMap.keySet()) {
            arrWithoutDupes[count] = number;
            count++;
        }
        return arrWithoutDupes;
    }
}
