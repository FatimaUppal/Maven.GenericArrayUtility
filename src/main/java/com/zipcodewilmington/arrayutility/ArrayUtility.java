package com.zipcodewilmington.arrayutility;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {
    private final T[] array; // Instance variable to hold the array

    public ArrayUtility(T[] array) { // Constructor to initialize the instance variable with the array passed as an argument
        this.array = array;
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        Integer counter = 0; // Counter to keep track of the number of duplicates
        for (T t : arrayToMerge) { // Iterate through the first array
            if (t.equals(valueToEvaluate)) { // If the current element is equal to the value to evaluate
                counter++; // Increment the counter
            }
        }
        for (T t : array) { // Iterate through the instance variable array
            if (t.equals(valueToEvaluate)) { // If the current element is equal to the value to evaluate
                counter++; // Increment the counter
            }
        }
        return counter; // Return the total number of duplicates found
    }

    public T getMostCommonFromMerge(T[] valueToEvaluate) {
        T keyMax = null; // Variable to hold the most common element found
        Integer maxNum = 0; // Counter to keep track of the frequency of the most common element
        HashMap<T, Integer> map = new HashMap<>(); // HashMap to store the frequency of each element in the array
        for(T t:array){ // Iterate through the instance variable array
            T key = t; // Set the current element as the key in the HashMap
            if(map.containsKey(key)) { // If the key already exists in the HashMap
                Integer value = map.get(key); // Get the current frequency of the element
                map.put(key, value+1); // Increment the frequency by 1
            } else { // If the key does not exist in the HashMap
                map.put(key, 1); // Set the frequency of the element to 1
            }
            for (Map.Entry<T, Integer> entry : map.entrySet()){ // Iterate through the HashMap to find the most common element
                if(entry.getValue() > maxNum) { // If the frequency of the current element is greater than the previous most common element
                    maxNum = entry.getValue(); // Set the new max frequency
                    keyMax = entry.getKey(); // Set the new most common element
                }
            }
        }
        return keyMax; // Return the most common element found
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {
        Integer counter = 0; // Counter to keep track of the number of occurrences
        for (T t : array) { // Iterate through the instance variable array
            if (t.equals(valueToEvaluate)) { // If the current element is equal to the value to evaluate
                counter++; // Increment the counter
            }
        }
        return counter; // Return the total number of occurrences found
    }

    public T[] removeValue(T valueToRemove) {
        Integer counter = array.length; // Counter to keep track of the new array length
        for(int i = 0; i < array.length; i++){ // Iterate through the instance variable array
            if(array[i].equals(valueToRemove)){ // If the current element is equal to the value to remove
                counter--; // Decrement the counter to account for the element being removed
            }
        }
        Class arrayClass = array.getClass(); // Get the class of the instance variable array
        Class component = arrayClass.getComponentType(); // Get the component type of the instance variable array
        T[] newArray = (T[]) Array.newInstance(component,counter); // Create a new array with the updated size
        Integer newCount = 0; // Counter to keep track of the current index of the new array
        for(T t : array){ // Iterate through the instance variable array again
            if(!t.equals(valueToRemove)){ // If the current element is not equal to the value to remove
                newArray[newCount] = t; // Add the element to the new array
                newCount++; // Increment the counter for the new array index
            }
        }
        return newArray; // Return the new array with the removed elements
    }
}
