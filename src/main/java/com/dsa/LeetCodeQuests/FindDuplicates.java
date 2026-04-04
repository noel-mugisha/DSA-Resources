package com.dsa.LeetCodeQuests;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicates {
    static List<Integer> findDuplicates(int[] nums) {
        var answ = new ArrayList<Integer>();
        for (int i = 0; i <= nums.length-1; i++) {
            var numOfTimes = 0;
            for (int j = 0; j <= nums.length-1; j++) {
                if (nums[i] == nums [j])
                    numOfTimes++;
                if (numOfTimes == 2){
                    answ.add(nums[i]);
                    break;
                }
            }
        }
        return answ;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(findDuplicates(nums));
    }
}
