package com.dsa.arrays;

public class MajorityElement {
    // Moore's voting Algo
    public int majorityElement(int[] nums) {
        int majEl = -1;
        int count = 0;
        for (int num : nums) {
            if (count == 0)
                majEl = num;
            if (num == majEl)
                count++;
            else
                count--;
        }
        return majEl;
    }
}
