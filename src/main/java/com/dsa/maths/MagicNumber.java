package com.dsa.maths;

public class MagicNumber {
    public static void main(String[] args) {
        System.out.println(magicNum(6, 5));
    }

    static int magicNum (int number, int base) {
        int answ = 0;
        int newBase = base;
        while (number > 0) {
            int lastDig = number & 1;
            answ += lastDig * newBase;
            newBase*=base;
            number = number >> 1;
        }

        return answ;
    }
}
