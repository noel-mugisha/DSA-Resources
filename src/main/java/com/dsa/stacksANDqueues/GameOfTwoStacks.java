package com.dsa.stacksANDqueues;

public class GameOfTwoStacks {

    // Wrapper function to start the recursion
    public static int twoStacks(int x, int[] a, int[] b) {
        // We start with remaining = x, and indices at 0
        return explore(x, a, b, 0, 0, 0);
    }

    private static int explore(int remaining, int[] a, int[] b, int i, int j, int count) {
        // Look-ahead: Can we take from stack A? Can we take from stack B?
        boolean canTakeFromA = (i < a.length && a[i] <= remaining);
        boolean canTakeFromB = (j < b.length && b[j] <= remaining);

        // YOUR BASE CASE: If we cannot add any more numbers from either stack 
        // without exceeding the remaining limit, we just return the exact count.
        if (!canTakeFromA && !canTakeFromB) {
            return count; 
        }

        int maxElements = count;

        // If taking from A is safe, subtract a[i] from remaining and increment count
        if (canTakeFromA) {
            int ans1 = explore(remaining - a[i], a, b, i + 1, j, count + 1);
            maxElements = Math.max(maxElements, ans1);
        }

        // If taking from B is safe, subtract b[j] from remaining and increment count
        if (canTakeFromB) {
            int ans2 = explore(remaining - b[j], a, b, i, j + 1, count + 1);
            maxElements = Math.max(maxElements, ans2);
        }

        return maxElements;
    }
}