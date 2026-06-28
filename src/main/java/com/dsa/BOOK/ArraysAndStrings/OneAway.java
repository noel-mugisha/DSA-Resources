package com.dsa.BOOK.ArraysAndStrings;

public class OneAway {

    boolean oneEditAway(String first, String second) {
        if (first.length() == second.length())
            return checkEdit(first, second);
        else if (first.length() + 1 == second.length())
            return checkInsertOrDelete(first, second);
        else if (second.length() + 1 == first.length())
            return checkInsertOrDelete(second, first);
        else
            return false;
    }

    boolean checkEdit (String first, String second) {
        boolean isDifferentFound = false;
        
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                if (isDifferentFound) return false;
                isDifferentFound = true;
            }
        }
        
        return true;
    }

    boolean checkInsertOrDelete (String shorter, String longer) {
        int i = 0, j = 0;
        boolean isDifferentFound = false;

        while (i < shorter.length() && j < longer.length()) {
            if (shorter.charAt(i) != longer.charAt(j)) {
                if (isDifferentFound) return false;
                isDifferentFound = true;
                j++;
            } else {
                i++;
                j++;
            }
        }

        return true;
    }
}
