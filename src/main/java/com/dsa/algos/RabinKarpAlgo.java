package com.dsa.algos;

public class RabinKarpAlgo {
    public static int rabinKarp(String text, String pattern) {

        int n = text.length();
        int m = pattern.length();

        if (m > n) {
            return -1;
        }

        long base = 256;
        long mod = 1_000_000_007;

        // base^(m - 1) % mod
        long highestPower = 1;

        for (int i = 0; i < m - 1; i++) {
            highestPower = (highestPower * base) % mod;
        }

        // Hash of pattern and first window
        long patternHash = 0;
        long windowHash = 0;

        for (int i = 0; i < m; i++) {
            patternHash =
                    (patternHash * base + pattern.charAt(i)) % mod;

            windowHash =
                    (windowHash * base + text.charAt(i)) % mod;
        }

        // Slide the window
        for (int i = 0; i <= n - m; i++) {

            // Hashes match -> verify actual characters
            if (windowHash == patternHash) {

                boolean match = true;

                for (int j = 0; j < m; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j)) {
                        match = false;
                        break;
                    }
                }

                if (match) {
                    return i;
                }
            }

            // Roll the hash to the next window
            if (i < n - m) {

                long outgoing = text.charAt(i);
                long incoming = text.charAt(i + m);

                windowHash =
                        (windowHash - outgoing * highestPower) % mod;

                if (windowHash < 0) {
                    windowHash += mod;
                }

                windowHash =
                        (windowHash * base + incoming) % mod;
            }
        }

        return -1;
    }
}
