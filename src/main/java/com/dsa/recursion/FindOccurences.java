package com.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class FindOccurences {
    public static void main(String[] args) {
        int[] arr = {3,6,3,1,6,5,10,3};
        System.out.println(findAllOccurences(arr, 8));
    }

    static List<Integer> findAllOccurences (int[] arr, int target) {
        int index = 0;
        List<Integer> result = new ArrayList<>();
        var answ = helper(arr, target, index, result);
        if (answ.isEmpty())
            answ.add(-1);
        return answ;
    }

    static List<Integer> helper(int[] arr, int target, int index, List<Integer> list) {
        if (index == arr.length)
            return list;

        if (arr[index] == target)
            list.add(index);

        return helper(arr, target, index+1, list);
    }
}
