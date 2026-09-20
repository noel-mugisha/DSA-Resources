# Time Complexity for this algorithm is O(M * N) where M and N are the lengths of string a and b respectively
from functools import lru_cache


# Solved using recursion + memoization
def longest_common_subsequence(a, b):
    @lru_cache(None)
    def solve(i, j):
        if i == len(a) or j == len(b):
            return 0

        if a[i] == b[j]:
            return 1 + solve(i + 1, j + 1)

        return max(
            solve(i + 1, j),
            solve(i, j + 1)
        )

    return solve(0, 0)

# Solved using 2D dynamic programming
def longest_common_subsequenceII(a, b):
    m, n = len(a), len(b)
    dp = [[0] * (n + 1) for _ in range(m + 1)]

    for i in range(1, m + 1):
        for j in range(1, n + 1):
            if a[i - 1] == b[j - 1]:
                dp[i][j] = 1 + dp[i - 1][j - 1]
            else:
                dp[i][j] = max(
                    dp[i - 1][j],
                    dp[i][j - 1]
                )

    return dp[m][n]

# 1DP Tabulation
def longestCommonSubsequenceIII(text1, text2):
    m, n = len(text1), len(text2)

    dp = [0] * (n + 1)

    for i in range(1, m + 1):
        diagonal = 0

        for j in range(1, n + 1):
            temp = dp[j]

            if text1[i - 1] == text2[j - 1]:
                dp[j] = diagonal + 1
            else:
                dp[j] = max(dp[j], dp[j - 1])

            diagonal = temp

    return dp[n]