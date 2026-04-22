package com.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class Subseq {
    public static void main(String[] args) {
        String s = "abc";
//        printSubsets(s);
        System.out.println(returnSubsets(s));
    }

    static void printSubsets (String s) {
        helper("", s);
    }

    static void helper (String processed, String unprocessed) {
        if (unprocessed.isEmpty()) {
            System.out.println(processed);
            return;
        }

        char c = unprocessed.charAt(0);
        helper(processed+c, unprocessed.substring(1));
        helper(processed, unprocessed.substring(1));
    }

    static List<String> returnSubsets (String s) {
        return helper2("", s);
    }

    static List<String> helper2(String processed, String unProcessed) {
        if (unProcessed.isEmpty()) {
            List<String> ans = new ArrayList<>();
            ans.add(processed);
            return ans;
        }

        char c = unProcessed.charAt(0);
        List<String> l = helper2(processed + c, unProcessed.substring(1));
        List<String> r = helper2(processed, unProcessed.substring(1));

        l.addAll(r);

        return l;
    }
}
