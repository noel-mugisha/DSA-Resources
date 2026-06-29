package com.dsa.Strings;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecodeString {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append("#").append(s);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#')
                j++;

            int strLen = Integer.parseInt(str.substring(i, j));

            result.add(str.substring(j + 1, j + 1 + strLen));

            i = j + 1 + strLen;
        }

        return result;
    }
}
