package com.dsa.oop;

import java.util.*;

public class RandomizedSet {
    private Map<Integer, Integer> elementsMap;
    private List<Integer> elementsList;
    private Random random;

    public RandomizedSet() {
        elementsMap = new HashMap<>();
        elementsList = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (elementsMap.containsKey(val))
            return false;

        // Add into the arr
        elementsList.add(val);
        // Add into the map
        elementsMap.put(val, elementsList.size() - 1);

        return true;
    }

    public boolean remove(int val) {
        if (!elementsMap.containsKey(val))
            return false;

        int index = elementsMap.get(val);
        int lastElement = elementsList.getLast();

        elementsList.set(index, lastElement);
        elementsMap.put(lastElement, index);

        elementsList.removeLast();
        elementsMap.remove(val);

        return true;
    }

    public int getRandom() {
        int randIndex = random.nextInt(elementsList.size());
        return elementsList.get(randIndex);
    }
}


