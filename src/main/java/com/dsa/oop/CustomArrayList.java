package com.dsa.oop;

public class CustomArrayList {
    private int[] nums = new int[1];
    private int size = 0;

    public CustomArrayList() {
    }

    public void add(int num) {
        if (size == nums.length)
            resize();
        nums[size++] = num;
    }

    public int getSize() {
        return size;
    }

    public void removeLast() {
        if (size == 0) return;
        --size;
    }

    public int remove (int index) {
        if (index < 0 || index >= size)
            throw new ArrayIndexOutOfBoundsException("Index is out of bounds");
        int temp = nums[index];
        for (int i = index; i < size - 1; i++) {
            nums[i] = nums[i+1];
        }
        --size;
        return temp;
    }

    public int get(int index) {
        if (index < 0 || index >= size)
            throw new ArrayIndexOutOfBoundsException("Index is out of bounds");
        return nums[index];
    }

    public void set(int num, int index) {
        if (index < 0 || index >= size)
            throw new ArrayIndexOutOfBoundsException("Index is out of bounds");
        nums[index] = num;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(int num) {
        for (int i = 0; i < size; i++) {
            if (nums[i] == num) return true;
        }
        return false;
    }

    public void clear() {
        size = 0;
    }

    public int insert (int index, int value) {
        if (index < 0 || index >= size)
            throw new ArrayIndexOutOfBoundsException("Index is out of bounds");
        if (size == nums.length)
            resize();
        for (int i = size; i > index; i--) {
            nums[i] = nums[i-1];
        }
        nums[index] = value;
        size++;
        return value;
    }

    private void resize() {
        int[] newArr = new int[nums.length * 2];
        System.arraycopy(nums, 0, newArr, 0, nums.length);
        nums = newArr;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(nums[i]);
            if (i < size - 1)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
