package com.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class SubseqList {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        printSubseq(arr);
    }

    static void printSubseq (int[] arr) {
        List<Integer> unprocessed = new ArrayList<>();
        List<Integer> processed = new ArrayList<>();
        for (int j : arr) {
            unprocessed.add(j);
        }

        helper(processed, unprocessed);
    }

    static void helper(List<Integer> processed, List<Integer> unprocessed) {
        if (unprocessed.isEmpty()) {
            System.out.println(processed);
            return;
        }

        var temp1 = new ArrayList<>(processed);
        var temp2 = new ArrayList<>(unprocessed);

        processed.add(unprocessed.getFirst());
        unprocessed.removeFirst();
        helper(processed, unprocessed);

        temp2.removeFirst();
        helper(temp1, temp2);
    }
}
