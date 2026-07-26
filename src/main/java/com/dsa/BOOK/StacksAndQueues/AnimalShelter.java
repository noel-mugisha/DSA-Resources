package com.dsa.BOOK.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class AnimalShelter {
    private LinkedList<Dog> dogQueue;
    private LinkedList<Cat> catQueue;
    private int order; // Increments with every arriving animal

    public AnimalShelter() {
        this.dogQueue = new LinkedList<>();
        this.catQueue = new LinkedList<>();
        this.order = 0;
    }

    public void enqueue(Animal animal) {
        animal.setOrder(order);
        order++;

        if (animal instanceof Dog) {
            dogQueue.addLast((Dog) animal);
        } else if (animal instanceof Cat) {
            catQueue.addLast((Cat) animal);
        } else {
            throw new IllegalArgumentException("Unknown animal species");
        }
    }


    public Animal dequeueAny() {
        if (dogQueue.isEmpty() && catQueue.isEmpty()) {
            throw new NoSuchElementException("No animals currently in shelter");
        }

        if (dogQueue.isEmpty()) {
            return dequeueCat();
        }

        // If no cats exist, we must return the oldest dog
        if (catQueue.isEmpty()) {
            return dequeueDog();
        }

        // Both exist: Peek at both heads and compare timestamps
        Dog oldestDog = dogQueue.peek();
        Cat oldestCat = catQueue.peek();

        if (oldestDog.getOrder() < oldestCat.getOrder()) {
            return dequeueDog();
        } else {
            return dequeueCat();
        }
    }

    public Dog dequeueDog() {
        if (dogQueue.isEmpty()) {
            throw new NoSuchElementException("No dogs available for adoption");
        }
        return dogQueue.poll();
    }

    public Cat dequeueCat() {
        if (catQueue.isEmpty()) {
            throw new NoSuchElementException("No cats available for adoption");
        }
        return catQueue.poll();
    }
}